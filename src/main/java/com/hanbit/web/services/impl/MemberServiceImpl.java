package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired private MemberDTO member;
	@Autowired private SubjectDTO subject;
	
	public MemberServiceImpl() {
	}

	@Override
	public List<?> list() {
		return null;
	}

	@Override
	public List<?> findBy(String keyword) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public Map<?, ?> map() {
		return null;
	}

	@Override
	public String regist(MemberDTO mem) {
		return null;
	}

	@Override
	public MemberDTO findById(String findID) {
		return null;
	}

	@Override
	public void update(MemberDTO stu2) {
		
	}

	@Override
	public void delete(MemberDTO member) {
		
	}

	@Override
	public String login(MemberDTO member) {
		return null;
	}

	@Override
	public void logout(MemberDTO member) {
		
	}

	@Override
	public MemberDTO show() {
		return null;
	}
}
	
	