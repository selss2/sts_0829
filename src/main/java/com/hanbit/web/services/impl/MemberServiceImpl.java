package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private MemberDTO member;
	@Autowired
	private Command command;

	public void logoutSession(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		if (member.getId().equals(member.getId()) && member.getPw().equals(member.getPw())) {
			member = null;
		}
	}

	public List<?> findBy(String keyword) {
		return null;
	}

	@Override
	public Map<?, ?> map() {
		return null;
	}

	public String myAccount() {
		return member.toString();
	}

	@Override
	public MemberDTO getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> list(Command command) {
		// TODO Auto-generated method stub
		return list(command);
	}

	@Override
	public String regist(MemberDTO member) {
		return (sqlSession.getMapper(MemberMapper.class).insert(member) == -1) ? "success" : "fail";
	}

	@Override
	public String update(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = mapper.update(member);
		String retval = "";
		if (result == 1) {
			retval = "success";
			System.out.println("서비스 수정결과 성공");
		} else {
			retval = "fail";
			System.out.println("서비스 수정결과 실패");
		}
		return retval;
	}

	@Override
	public void delete(MemberDTO mem) {

	}

	@Override
	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		logger.info("MemberService login ID = {}", member.getId());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		command.setKeyword(member.getId());
		command.setOption("mem_id");
		MemberDTO mem = mapper.findOne(command);
		if (member.getPw().equals(mem.getPw())) {
			logger.info("MemberService login {}", " SUCCESS ");
			return mem;
		}
		logger.info("MemberService login {}", " FAIL ");
		mem.setId("NONE");
		return mem;
	}

	@Override
	public MemberDTO findById(String id) {
		return null;
	}

	@Override
	public int existId(String id) {
		logger.info("MemberService existId ID = {}", id);
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.existId(id);
	}

	@Override
	public List<?> list() {
		return null;
	}

	@Override
	public int count(Command command) {
		return 0;
	}
}