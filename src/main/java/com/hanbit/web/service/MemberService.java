package com.hanbit.web.service;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;

public interface MemberService extends CommonService{
	public String regist(MemberDTO mem);
	public MemberDTO findById(String findID);
	public void update(MemberDTO stu2);
	public void delete(MemberDTO member);
	public String login(MemberDTO member);
	public void logout(MemberDTO member);
	public MemberDTO show();
	
}
