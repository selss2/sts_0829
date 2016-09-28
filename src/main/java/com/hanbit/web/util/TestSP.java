package com.hanbit.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.MemberService;
import com.hanbit.web.services.impl.MemberServiceImpl;

public class TestSP {
	@Autowired MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(TestSP.class);
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		Retval r = service.count();
		int totCount = r.getCount();
		logger.info("결과 : {}",totCount);
	}
}