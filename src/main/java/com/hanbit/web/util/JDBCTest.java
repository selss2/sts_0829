package com.hanbit.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.constants.Values;

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select name from member "
				+ "where mem_id = 'hong'",result="";
		
		List<String> list = new ArrayList<String>();
		try {
			Class.forName(Values.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Values.ORACLE_URL,
					Values.USER_ID,
					Values.USER_PW);
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