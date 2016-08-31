package com.hanbit.web.subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hanbit.web.util.Constants;


public class SubjectDAOImpl {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs; 
	private static SubjectDAOImpl instance = new SubjectDAOImpl();
	private SubjectDAOImpl() {
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SubjectDAOImpl getInstance() {
		return instance;
	}
	public void insert(SubjectVO sub){
		String sql = "insert into subject(subj_seq,id,major,subjects)"
				+ " values(subj_seq.nextval,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sub.getId());
			pstmt.setString(2, sub.getMajor());
			pstmt.setString(3, sub.getSubjects());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1){
			System.out.println("과목 추가 성공");
		}else{
			System.out.println("과목 추가 실패");
		}
		
	}
	public SubjectVO findById(String id){
		SubjectVO s = null;
		String sql = "select "
				+ "id as id, "
				+ "major as major, "
				+ "subjects as sub "
				+ "from subject where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				s = new SubjectVO();
				s.setId(rs.getString("id"));
				s.setMajor(rs.getString("major"));
				s.setSubjects(rs.getString("sub"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}


