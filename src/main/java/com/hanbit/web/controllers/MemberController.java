package com.hanbit.web.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.constants.Values;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;
import com.hanbit.web.util.Pagination;

@Controller
@SessionAttributes({"user","context","js","css","img"})
@Scope("session")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	@Autowired Command command;
	@Autowired MemberDTO member;
	@Autowired Retval retval;
	
	@RequestMapping(value="/count/{option}")
	public Model count(@PathVariable("option") String option,
			Model model){
		logger.info("TO COUNT CONDITION IS {}",option);
		Retval r = service.count();
		model.addAttribute("count", r.getCount());
		return model;
	}
	@RequestMapping(value="/countall")
	public Model countAll(
			Model model){
		logger.info("TO COUNT CONDITION IS {}","ALL IS ...");
		model.addAttribute("count", service.count());
		return model;
	}
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
			@PathVariable("keyword")String keyword,
			Model model){
		logger.info("TO SEARCH KEYWORD IS {}",keyword);
		logger.info("TO SEARCH OPTION IS {}",option);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("THIS PATH IS {}","LOGINED_HEADER");
		return "user/header.jsp";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody MemberDTO login(@RequestParam("id") String id,
			@RequestParam("pw")String pw,HttpSession session) {
		logger.info("TO LOGIN ID IS {}",id);
		logger.info("TO LOGIN PW IS {}",pw);
		member.setId(id);
		member.setPw(pw);
		MemberDTO user = service.login(member);
		if(user.getId().equals("NONE")){
			logger.info("Controller LOGIN IS {}","FAIL");
			return user;
		}else{
			logger.info("Controller LOGIN IS {}","SUCCESS");
			session.setAttribute("user", user);
			return user;
		}
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		logger.info("GO TO {}","LOGOUT");
		status.setComplete();
		logger.info("SESSION IS {}","CLEAR");
		return "redirect:/";
	}
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");
		return "admin:member/content.tiles";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST,
			consumes="application/json")
	public @ResponseBody Retval signup(@RequestBody MemberDTO param) {
		logger.info("SIGN UP {}","EXEUTE");
		logger.info("SIGN UP ID = {}",param.getId());
		logger.info("SIGN UP PW = {}",param.getPw());
		logger.info("SIGN UP NAME = {}",param.getName());
		logger.info("SIGN UP SSN = {}",param.getSsn());
		logger.info("SIGN UP EMAIL = {}",param.getEmail());
		logger.info("SIGN UP PHONE = {}",param.getPhone());
		retval.setMessage(service.regist(param));
		logger.info("SIGN UP REVAL = {}",retval.getMessage());
		return retval;
	}
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval CheckDup(@PathVariable String id) {
		logger.info("CHECK DUP {}","EXEUTE");
		if(service.existId(id)==1){
			retval.setFlag("TRUE");
			retval.setMessage("입력하신 ID는 이미 존재합니다");
		}else{
			retval.setFlag("FALSE");
			retval.setMessage("입력하신 ID는 사용가능 합니다.");
			retval.setTemp(id);
		}
		logger.info("RETVAL FLAG IS {}",retval.getFlag());
		logger.info("RETVAL MSG IS {}",retval.getMessage());
		return retval;
	}
	@RequestMapping("/list/{pgNum}")
	public String list(@PathVariable String pgNum,Model model){
		logger.info("LIST pgNum {}",pgNum);
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int[]rows = new int[2];
		Retval r = service.count();
		int totCount = r.getCount();
		int totPg = 0;
		int startPg = 0,lastPg = 0;
		int pgNum2 = Integer.parseInt(pgNum);
		logger.info("LIST totCount {}",totCount);
	//	int pgCount = totCount/Values.PG_SIZE;
		rows = Pagination.getStartRow(totCount, Integer.parseInt(pgNum), Values.PG_SIZE); 
		command.setStart(rows[0]);
		command.setEnd(rows[1]);
		model.addAttribute("list", service.list(command));
		int pgSize = Values.PG_SIZE;
		if(totCount % pgSize == 0){
			totPg = totCount/pgSize;
		}else{
			totPg = totCount/pgSize + 1;
		}
		startPg = pgNum2 - ((pgNum2-1)%pgSize);
		if(startPg + pgSize-1 <= totPg){
			lastPg =  startPg + pgSize -1;
		}else{
			lastPg = totPg;
		}
		logger.info("LIST pgSize {}",pgSize);
		model.addAttribute("pgSize", pgSize);
		model.addAttribute("totCount", totCount);
		model.addAttribute("totPg", totPg);
		model.addAttribute("pgNum", pgNum2);
		model.addAttribute("startPg", startPg);
		model.addAttribute("lastPg", lastPg);
		
		return "admin:member/list.tiles";
	}
	@RequestMapping("/search")
	public String search(
			@RequestParam(value="keyField") String keyField,
			@RequestParam(value="keyword") String keyword,
		//	@RequestParam(value="pgNum") String strPgNum,
			Model model){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
	//	service.list(Command);
		model.addAttribute("list", list);
		return "admin:member/list.tiles";
	}
	
	
	
	
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key")String key) {
		logger.info("GO TO {}","a_detail");
		logger.info("KEY IS {}",key);
		return "admin:member/a_detail.tiles";
	}
	@RequestMapping("/detail")
	public @ResponseBody MemberDTO moveDetail(HttpSession session) {
		logger.info("GO TO {}","detail");
		return (MemberDTO) session.getAttribute("user");
	}
	@RequestMapping("/update")
	public @ResponseBody Retval update(@RequestBody MemberDTO param,
			HttpSession session) {
		logger.info("GO TO {}","update");
		MemberDTO temp = (MemberDTO) session.getAttribute("user");
			temp.setPw(param.getPw());
			temp.setEmail(param.getEmail());
		retval.setMessage(service.update(temp));
		return retval;
	}
	
	@RequestMapping("/content")
	public String moveUserContent() {
		logger.info("GO TO {}","content");
		return "user:user/content.tiles";
	}
	@RequestMapping("/kaup")
	public String moveKaup() {
		logger.info("GO TO {}","kaup");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/rock_sissor_paper")
	public String moveRockSissorPaper() {
		logger.info("GO TO {}","rock_sissor_paper");
		return "user:user/rock_sissor_paper.tiles";
	}
	@RequestMapping("/lotto")
	public String moveLotto() {
		logger.info("GO TO {}","lotto");
		return "user:user/lotto.tiles";
	}
}