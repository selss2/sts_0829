package com.hanbit.web.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user","img","java","js"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option")String option,
			@RequestParam("context")String context,
			Model model){
		logger.info("MemberController ! findById : {}","??");
		MemberVO member = (MemberVO) service.findById(keyword);
		model.addAttribute("member", member);
		model.addAttribute("img", context+"/resources/img");
		return "admin:member/detail.tiles";
	}
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
			@RequestParam("pw")String pw,
			@RequestParam("context")String context,
			Model model, HttpSession session) {
		logger.info("TO LOGIN ID {}",id);
		logger.info("TO LOGIN PW {}",pw);
		logger.info("CONTEXT : {}",context);
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		
		String sm = service.login(member);
		model.addAttribute("user",sm);
		model.addAttribute("context",context);
		model.addAttribute("js", context+"/resources/js");
		model.addAttribute("css", context+"/resources/css");
		model.addAttribute("img", context+"/resources/img");

		return "user:user/content.tiles";
	}
	// --- MOVE ---
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}", "main");	
		return "admin:member/content.tiles";
	}
	@RequestMapping("/login")
	public String login() {
		logger.info("GO TO Member {}", "login");
		return "public:member/login.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("GO TO Member {}", "regist");
		return "public:member/regist.tiles";
	}
	@RequestMapping("/a_detail")
	public String moveA_detail(@RequestParam("key")String key) {
		logger.info("GO TO Member {}", "a_detail");
		logger.info("KEY IS {}", key);
		return "admin:member/a_detail.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO Member {}", "detail");
		return "user:member/detail.tiles";
	}

	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GO TO Member {}", "update");
		return "user:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO Member {}", "delete");
		return "user:member/delete.tiles";
	}

	@RequestMapping("/logout")
	public String moveLogout() {
		logger.info("GO TO Member {}", "logout");
		return "member/logout.tiles";
	}
	@RequestMapping("/list")
	public String moveList() {
		logger.info("GO TO Member {}", "list");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find")
	public String moveFindBy() {
		logger.info("GO TO Member {}", "find");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("GO TO Member {}", "count");
		return "admin:member/count.tiles";
	}
	@RequestMapping("/content")
	public String moveUserContent() {
		logger.info("GO TO User {}", "content");
		return "user:user/content.tiles";
	}
	@RequestMapping("/kaup")
	public String moveKaup() {
		logger.info("GO TO User {}", "kaup");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/rock_sissor_paper")
	public String moveRock_sissor_paper() {
		logger.info("GO TO User {}", "rock_sissor_paper");
		return "user:user/rock_sissor_paper.tiles";
	}
	@RequestMapping("/lotto")
	public String moveLotto() {
		logger.info("GO TO User {}", "lotto");
		return "user:user/lotto.tiles";
	}
}
