package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;
@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired private SqlSession sqlSession;
	@Autowired private MemberDTO member;
	@Autowired private SubjectDTO subject;
	
	@Override
	public String regist(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String msg = "";
		MemberDTO temp = this.findById(mem.getId());
		if (temp == null) {
			System.out.println(mem.getId()+"가 존재하지 않음,가입 가능한 ID");
			int result = mapper.insert(mem);
			if (result==1) {
				msg = "success";
			} else {
				msg = "fail";
			}
		} else {
			System.out.println(mem.getId()+"가 존재함,가입 불가능한 ID");
			msg = "fail";
		}
		
		return msg;
	}


	@Override
	public void update(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = mapper.update(mem);
		if (result == 1) {
			System.out.println("서비스 수정결과 성공");
		}else{
			System.out.println("서비스 수정결과 실패");
		}
	}
	@Override
	public MemberDTO show() {
		return member;
	}
	@Override
	public void delete(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.delete(member);
	}


	@Override
	public int count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}


	@Override
	public MemberDTO findById(String findID) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findById(findID);
	}


	@Override
	public List<?> list() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list();
	}


	@Override
	public List<?> findBy(String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findByName(keyword);
	}


	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void logout(MemberDTO member) {
		if (member.getId().equals(member.getId()) 
				&& member.getPw().equals(member.getPw())) {
			member = null;
		}
		
	}


	@Override
	public MemberDTO login(MemberDTO member) {
		logger.info("MemberService login ID = {}",member.getId());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		MemberDTO mem = mapper.findById(member.getId());
		if(mem.getPw().equals(member.getPw())){
			logger.info("MemberService login {}"," SUCCESS ");
			return mem;
		}
		logger.info("MemberService login {}"," FAIL ");
		mem.setId("NONE");
		return mem;
	}
}