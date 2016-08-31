package com.hanbit.web.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;

public class Test {
	@Autowired MemberServiceImpl service;
	public String test(){
		MemberVO m = service.findById("hong");
	   return m.getName();
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.test());
	}
}
