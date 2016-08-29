/**
 * 
 */
package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

import com.hanbit.web.util.CommonService;


/**
 * @date   :2016. 6. 20. 
 * @author :pakjkwan@gmail.com
 * @file   :AccountService.java
 * @story  :
*/
public interface AccountService extends CommonService{
	// 1개설 2입금 3조회 4출금 5통장내역 6해지
		
		// 1개설
		public String openAccount(String id);
		// 2입금
		public void deposit(String depositInfo);
		// 3출금
		public String withdraw(String withdrawInfo);
		// 4.수정 .. 사용자의 요청에 의해 비번만 전환가능
		public String updateAccount(AccountBean acc);
		// 5해지
		public void deleteAccount();
		// 7조회(계좌번호)
		public AccountBean findByAccountNo(String accNo);
		// 원래 요구사항에는 없었지만.. 필요에 따라 생성하는 메소드
		public int restMoney(int accNo);
		
}
