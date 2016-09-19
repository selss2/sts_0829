package com.hanbit.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.services.IntegerMath;
import com.hanbit.web.services.ListService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@RequestMapping("/main")
	public String goMain(){
		logger.info("AdminController ! goMain() ");
		return "admin:admin/content.tiles";
	}
	public void aaa(){
		ListService abc = ()->null;
		IntegerMath def = (int a,int b)->a+b;
	}
	
}