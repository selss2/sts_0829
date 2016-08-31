package com.hanbit.web.util;

import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;

public class Test {
	public String test(){
		MemberVO m = MemberServiceImpl.getInstance().findById("hong");
	   return m.getName();
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.test());
	}
}
