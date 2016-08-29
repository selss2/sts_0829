<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="../../css/member.css" />
<div class="box">
		<form action="${context}/member/result/delete_result.jsp" method = "post">
	<input type="text" name ="confirm" value="" />
	<input type="hidden" name="id" value="" />
	
	<input type="submit" value="탈퇴" />
		<input type="reset" value="취소" />
	</form>
	<embed src="../../img/starwars.gif">
		<h1>탈퇴</h1> 
	<a href="../../index.jsp">
		<img src="../../img/home.png" alt="home" style="width: 30px"/>
	</a>
	<a href="../member_controller.jsp">
		<img src="../../img/member.jpg" alt="member" style="width: 30px"/>
	</a>
	</div>
