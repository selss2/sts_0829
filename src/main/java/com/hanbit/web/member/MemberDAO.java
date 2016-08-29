package com.hanbit.web.member;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface MemberDAO {
	public int insert(MemberBean mem);
	public int update(MemberBean mem);
	public int exeUpdate(String sql);
	public List<MemberBean> list();
	public MemberBean findById(String pk);
	public List<MemberBean> findByName(String name);
	public int count();
	public int delete(MemberBean member);
	public boolean login(MemberBean param);
	public boolean existId(String id);
}
