<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${css}/member.css" />
<div class="box">
	<form action="${context}/member/result/logout_result.jsp" method="post">
		<input type="hidden" name="id" value="" />
		<input type="hidden" name="pw" value="" />
		<input type="submit" value="로그아웃"  />
	</form>
	
	</div>	
