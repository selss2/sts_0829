package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
@Repository
public interface MemberMapper {
	public int insert(MemberDTO mem);
	public int update(MemberDTO mem);
	public List<MemberDTO> list(Command command);
	public MemberDTO findOne(Command command);
	public List<MemberDTO> findByName(String name);
	public Retval count();
	public int delete(MemberDTO member);
	public boolean login(MemberDTO param);
	public int existId(String id);
}