package com.hanbit.web.member;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.home.HomeController;

@Controller
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
		System.out.println("검색어:"+keyword);
		System.out.println("옵션 :"+option);
		System.out.println("context :"+context);
		MemberVO member = (MemberVO) service.findById(keyword);
		System.out.println("NAME : "+member.getName());
		System.out.println("이미지:"+member.getProfileImg());
		model.addAttribute("member", member);
		model.addAttribute("img", context+"/resources/img");
		return "admin:member/detail.tiles";
	}
	@RequestMapping("/login/execute")
	public String executeLogin(@RequestParam("id") String id,
			@RequestParam("pw")String pw) {
		logger.info("MemberController ! login() ");
		System.out.println("로그인시 넘어온 id");
		System.out.println("로그인시 넘어온 pw");
		return "user:user/content.tiles";
	}
	// --- MOVE ---
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("MemberController ! goMain() ");	
		return "admin:member/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("MemberController ! regist() ");
		return "public:member/regist.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("MemberController ! detail() ");
		return "member/detail.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("MemberController ! update() ");
		return "member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("MemberController ! delete() ");
		return "member/delete.tiles";
	}
	@RequestMapping("/login")
	public String moveLogin() {
		logger.info("MemberController ! login() ");
		return "public:member/login.tiles";
	}
	@RequestMapping("/logout")
	public String moveLogout() {
		logger.info("MemberController ! logout() ");
		return "member/logout.tiles";
	}
	@RequestMapping("/list")
	public String moveList() {
		logger.info("MemberController ! list() ");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find")
	public String moveFindBy() {
		logger.info("MemberController ! find_by() ");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("MemberController ! count() ");
		return "admin:member/count.tiles";
	}
}
