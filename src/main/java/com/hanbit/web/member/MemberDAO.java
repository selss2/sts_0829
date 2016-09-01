package com.hanbit.web.member;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface MemberDAO {
	public int insert(MemberVO mem);
	public int update(MemberVO mem);
	public List<MemberVO> list();
	public MemberVO findById(String pk);
	public List<MemberVO> findByName(String name);
	public int count();
	public int delete(MemberVO member);
	public boolean login(MemberVO param);
	public boolean existId(String id);
}
