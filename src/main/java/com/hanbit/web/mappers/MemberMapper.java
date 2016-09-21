package com.hanbit.web.mappers;

import java.util.List;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;


public interface MemberMapper {
	public int insert(MemberDTO member);
	public int delete(MemberDTO member);
	public int update(MemberDTO member);
	public List<MemberDTO> list();
	public MemberDTO findOne(Command command);
	public List<MemberDTO> findByname(String name);
	public int count();
	public boolean login(MemberDTO param);
	public boolean existId(String id);
	public int findId(String id);
	public int genderCount(String gender);
}