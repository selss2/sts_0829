package com.hanbit.web.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;



public class AccountDAO {
	private static AccountDAO instance = new AccountDAO();
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private AccountDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE,
				Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static AccountDAO getInstance() {
		return instance;
	}
	public int insertAccount(AccountBean acc) {
		int result = 0; 
		String sql = "insert into account (id, account_no, money) "
				+ "values (?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setInt(2, acc.getAccountNo());
			pstmt.setInt(3, acc.getMoney());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int selectMoney(int accNo) {
		int money = 0;
		String sql = "select money from account "
				+ "where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				money = rs.getInt("MONEY");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return money;
	}
	public void deposit(AccountBean acc) {
		String sql = "update account set money = ?"
				+ "where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acc.getMoney());
			pstmt.setInt(2, acc.getAccountNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void withdraw(AccountBean acc) {
		this.deposit(acc);
	}
	public List<AccountMemberBean> selectAll() {
		List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
		String sql= "select "
				+ "account_no as acc,"
				+ "id as id,"
				+ "name as name,"
				+ "money as money,"
				+ "ssn as birth"
				+ " from account_member"
				+ " order by name";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountMemberBean acc = new AccountMemberBean();
				acc.setAccountNo(rs.getInt("ACC"));
				acc.setId(rs.getString("ID"));
				acc.setName(rs.getString("NAME"));
				acc.setMoney(rs.getInt("MONEY"));
				acc.setBirth(rs.getString("BIRTH").substring(0, 6));
				list.add(acc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Map<?, ?> selectMap() {
		Map<String,AccountMemberBean> map = new HashMap<String,AccountMemberBean>();
		String sql = "select * from account_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountMemberBean am = new AccountMemberBean();
				am.setAccountNo(rs.getInt("ACCOUNT_NO"));
				am.setId(rs.getString("ID"));
				am.setMoney(rs.getInt("MONEY"));
				am.setName(rs.getString("NAME"));
				am.setPw(rs.getString("PW"));
				am.setRegDate(rs.getString("REG_DATE"));
				am.setSsn(rs.getString("SSN"));
				map.put(String.valueOf(am.getAccountNo()), am);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}














