package com.hanbit.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hanbit.web.util.Constants;
@Repository
public class MemberDAOImpl implements MemberDAO{
	private SqlSessionFactory sqlSessionFactory = null;
    public MemberDAOImpl(SqlSessionFactory sqlSessionFactory) {
	  this.sqlSessionFactory = sqlSessionFactory;
    }
	@Override
	public int insert(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",member);
	}
	@Override
	public int update(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",member);
	}

	@Override
	public List<MemberVO> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public MemberVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",id);
	}
	@Override
	public List<MemberVO> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("",name);
	}
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
	@Override
	public int delete(MemberVO member) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",member);
	}
	@Override
	public boolean login(MemberVO param) {
		boolean loginOk= false;
		if(param.getId()!=null 
				&& param.getPw()!=null 
				&& this.existId(param.getId())){
			MemberVO member = this.findById(param.getId());
			if(member.getPw().equals(param.getPw())){
				loginOk = true;
			}
		}
		System.out.println("LOGIN_OK ?"+loginOk);
		return  false;
	}
	@Override
	public boolean existId(String id){
		SqlSession session = sqlSessionFactory.openSession();
		int temp = session.selectOne("",id);
		return false; 
	}
}




