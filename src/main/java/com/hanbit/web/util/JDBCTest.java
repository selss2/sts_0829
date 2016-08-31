package com.hanbit.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select name from member "
				+ "where id = 'hong2'",result="";
		
		List<String> list = new ArrayList<String>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
			// rs = stmt.executeQuery(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// System.out.println(list);
		System.out.println("결과"+result);
		
	}
}
