package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.MemberDTO;

public interface MemberMapper {
	public int insert(MemberDTO mem);
	public int update(MemberDTO mem);
	public List<MemberDTO> list();
	public MemberDTO findById(String pk);
	public List<MemberDTO> findByName(String name);
	public int count();
	public int delete(MemberDTO member);
	public boolean login(MemberDTO param);
	public boolean existId(String id);
}
