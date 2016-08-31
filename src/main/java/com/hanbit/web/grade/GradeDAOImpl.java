package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


public class GradeDAOImpl {
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	private static GradeDAOImpl instance = new GradeDAOImpl();
		public static GradeDAOImpl getInstance() {
		return instance;
	}

	private GradeDAOImpl() {
		con = DatabaseFactory
				.createDatabase(Vendor.ORACLE, 
						Constants.USER_ID, 
						Constants.USER_PW)
				.getConnection();
	}

	public int insert(GradeVO g){
		int result = 0;
		String sql="insert into grade(seq,grade,java,sql,html,javascript,id,exam_date)"
				+ "values(seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getGrade());
			pstmt.setInt(2, g.getJava());
			pstmt.setInt(3,g.getSql());
			pstmt.setInt(4, g.getHtml());
			pstmt.setInt(5, g.getJavascript());
			pstmt.setString(6, g.getId());
			pstmt.setString(7, g.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<?> list() {
		List<GradeVO> list = new ArrayList<GradeVO>();
		String sql = "select * from grade";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GradeVO g = new GradeVO();
				g.setSeq(String.valueOf(rs.getInt("SEQ")));
				g.setId(rs.getString("ID"));
				g.setExamDate(rs.getString("EXAM_DATE"));
				g.setGrade(rs.getString("GRADE"));
				g.setJava(rs.getInt("JAVA"));
				g.setHtml(rs.getInt("HTML"));
				g.setJavascript(rs.getInt("JAVASCRIPT"));
				g.setSql(rs.getInt("SQL"));
				list.add(g);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int count() {
		return 0;
	}

	public int count(String examDate) {
		int result = 0;
		String sql = "select count(*) as count from grade "
				+ "where exam_date = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, examDate);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public GradeVO findBySeq(String seq) {
		GradeVO bean = new GradeVO();
		String sql = "select * from grade where seq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(seq));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setExamDate(rs.getString("EXAM_DATE"));
				bean.setGrade(rs.getString("GRADE"));
				bean.setHtml(rs.getInt("HTML"));
				bean.setId(rs.getString("ID"));
				bean.setJava(rs.getInt("JAVA"));
				bean.setJavascript(rs.getInt("JAVASCIRPT"));
				bean.setSeq(String.valueOf(rs.getInt("SEQ")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	public List<?> findById(String id) {
		List<GradeVO> list = new ArrayList<GradeVO>();
		String sql= "select * from grade where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeVO bean = new GradeVO();
				bean.setSeq(String.valueOf(rs.getInt("SEQ")));
				bean.setExamDate(rs.getString("EXAM_DATE"));
				bean.setJava(rs.getInt("JAVA"));
				bean.setHtml(rs.getInt("HTML"));
				bean.setSql(rs.getInt("SQL"));
				bean.setJavascript(rs.getInt("JAVASCRIPT"));
				bean.setId(rs.getString("ID"));
				bean.setGrade(rs.getString("GRADE"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int update(GradeVO grade) {
		//"과목,점수,seq"
		int result = 0;
		String sql = "update grade set"+ grade.getSubject()+"="+grade.getScore()+ "where seq =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(grade.getSeq()));
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int delete(String del) {
		int result =0;
		String sql = "delete from grade where seq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(del));
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
	
