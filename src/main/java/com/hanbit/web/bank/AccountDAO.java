package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;
public interface AccountDAO {
	public int openAccount(AccountVO bean);
	public int deposit(String accountNo, String money);
	public int withDraw (String account, String withdrawMoney);
	public int updateAccount(AccountMemberVO acc);
	public int deleteAccount(String delete);
	public List<?> findAccount ();
	public AccountMemberVO findByAcc (int account);
	public List<?> findByName(String name);
	public int count();
	public Map<?, ?> selectMap();
}