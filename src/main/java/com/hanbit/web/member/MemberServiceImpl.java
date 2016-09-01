package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;
@Service
public class MemberServiceImpl implements MemberService{
	private MemberDAOImpl dao;
	private SubjectDAOImpl subjDao;
	@Autowired private MemberVO member;
	@Autowired private SubjectVO subject;
	@Autowired private SubjectMemberVO subjectMember;
	private AccountServiceImpl accService;
	
	public MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		subjDao = SubjectDAOImpl.getInstance();
	}
	
	@Override
	public String regist(MemberVO mem) {
		String msg = "";
		MemberVO temp = this.findById(mem.getId());
		if (temp == null) {
			System.out.println(mem.getId()+"가 존재하지 않음,가입 가능한 ID");
			int result = dao.insert(mem);
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
	public void update(MemberVO mem) {
		int result = dao.update(mem);
		if (result == 1) {
			System.out.println("서비스 수정결과 성공");
		}else{
			System.out.println("서비스 수정결과 실패");
		}
	}
	@Override
	public MemberVO show() {
		return member;
	}
	@Override
	public void delete(MemberVO member) {
		dao.delete(member);
	}


	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}


	@Override
	public MemberVO findById(String findID) {
		return dao.findById(findID);
	}


	@Override
	public List<?> list() {
		
		return dao.list();
	}


	@Override
	public List<?> findBy(String keyword) {
		// TODO Auto-generated method stub
		return dao.findByName(keyword);
	}


	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectMemberVO login(MemberVO member) {
			if (dao.login(member)) {
				member = dao.findById(member.getId());
			//	accService.map();
				subject = subjDao.findById(member.getId());
				subjectMember.setEmail(member.getEmail());
				subjectMember.setId(member.getId());
				subjectMember.setImg(member.getProfileImg());
		/*		subjectMember.setMajor(subject.getMajor());*/
				subjectMember.setName(member.getName());
				subjectMember.setPhone(member.getPhone());
				subjectMember.setPw(member.getPw());
				subjectMember.setReg(member.getRegDate());
				subjectMember.setSsn(member.getSsn());
				/*subjectMember.setSubjects(subject.getSubjects());*/
				
			}else{
				subjectMember.setId("fail");
			}
		return subjectMember;
	}


	@Override
	public void logout(MemberVO member) {
		if (member.getId().equals(member.getId()) 
				&& member.getPw().equals(member.getPw())) {
			member = null;
		}
		
	}
}
