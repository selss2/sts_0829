package com.hanbit.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;


@Component
public interface MemberService{
	public String regist(MemberDTO mem);
	public MemberDTO findOne(Command command);
	public String update(MemberDTO member);
	public void delete(MemberDTO member);
	public void logout(MemberDTO member);
	public MemberDTO show();
	public MemberDTO login(MemberDTO member);
	public Retval count();
	public List<?> list();
	public List<?> findBy(String keyword);
	public int existId(String id);
	
}