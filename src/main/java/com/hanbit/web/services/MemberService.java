package com.hanbit.web.services;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.hanbit.web.domains.MemberDTO;

@Component
public interface MemberService{
	public String regist(MemberDTO mem);
	public MemberDTO findById(String findID);
	public void update(MemberDTO stu2);
	public void delete(MemberDTO member);
	public void logout(MemberDTO member);
	public MemberDTO show();
	public MemberDTO login(MemberDTO member);
	public int count();
	public List<?> list();
	public List<?> findBy(String keyword);
	Map<?, ?> map();
	
}