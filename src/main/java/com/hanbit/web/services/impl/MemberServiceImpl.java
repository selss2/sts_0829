package com.hanbit.web.services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired private SqlSession sqlSession;
	@Autowired Command command;
	@Autowired MemberDTO member;
	@Override
	public String regist(MemberDTO member) {
		return (sqlSession.getMapper(MemberMapper.class).insert(member)==1)?"success": "fail";
	}
	@Override
	public String update(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = mapper.update(mem);
		String retval = "";
		if (result == 1) {
			retval = "success";
		}else{
			retval = "fail";
		}
		return retval;
	}
	@Override
	public MemberDTO show() {
		return null;
	}
	@Override
	public void delete(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.delete(member);
	}
	@Override
	public Retval count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Retval r = mapper.count(); 
		if(r==null){
			System.out.println("Retval 은 null");
		}else{
			System.out.println("Retval 은 null 아님");
		}
		return r;
	}
	@Override
	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command);
	}
	@Override
	public List<?> list(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list(command);
	}
	@Override
	public List<?> findBy(String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findByName(keyword);
	}
	@Override
	public void logout(MemberDTO member) {
		if (member.getId().equals(member.getId()) 
				&& member.getPw().equals(member.getPw())) {
			member = null;
		}
	}
	@Override
	public MemberDTO login(MemberDTO param) {
		logger.info("MemberService login ID is {}",member.getId());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		command.setKeyword(member.getId());
		command.setOption("mem_id");
		MemberDTO retval = mapper.findOne(command);
		logger.info("MemberService PASSWORD(param) is {}",param.getPw());
		logger.info("MemberService PASSWORD(retval) is {}",retval.getPw());
		if(retval.getPw().equals(param.getPw())){
			logger.info("MemberService login is {}"," SUCCESS ");
			return retval;
		}else{
			logger.info("MemberService login is {}"," FAIL ");
			retval.setId("NONE");
			return retval;
		}
	}
	@Override
	public int existId(String id){
		logger.info("MemberService existId ID is {}",id);
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.existId(id);
	}
}