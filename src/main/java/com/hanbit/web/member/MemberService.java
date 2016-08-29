package com.hanbit.web.member;

import java.util.List;
import com.hanbit.web.subject.SubjectMember;
import com.hanbit.web.util.CommonService;

public interface MemberService extends CommonService{
	public String regist(MemberBean mem);
	public MemberBean findById(String findID);
	public void update(MemberBean stu2);
	public void delete(MemberBean member);
	public SubjectMember login(MemberBean member);
	public void logout(MemberBean member);
	public MemberBean show();
}
