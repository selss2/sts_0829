package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.util.CommonService;


public interface MemberService extends CommonService{
	public String regist(MemberVO mem);
	public MemberVO findById(String findID);
	public void update(MemberVO stu2);
	public void delete(MemberVO member);
	public SubjectMemberVO login(MemberVO member);
	public void logout(MemberVO member);
	public MemberVO show();
	
}