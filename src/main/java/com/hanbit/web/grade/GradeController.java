package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("========GradeController ! goMain() ");	
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("===GradeController ! regist() ");
		return "grade/regist.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("===GradeController ! update() ");
		return "grade/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("===GradeController ! delete() ");
		return "grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String moveList() {
		logger.info("===GradeController ! list() ");
		return "grade/list.tiles";
	}

}


