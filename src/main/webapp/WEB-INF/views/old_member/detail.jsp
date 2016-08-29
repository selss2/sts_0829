<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/global.css" />
<link rel="stylesheet" href="${css}/member.css" />
<div class="box">
		<h1>회원상세정보</h1>
		<table id="member_detail">
				<tr>
				<td rowspan="5" style="width:30%">
				<img src="${img}/member/${user.img}" alt="W3Schools.com" width="104"
			height="142"></td>
				<td style="width:20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width:40%">${user.id}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이 름</td>
				<td>${user.name}</td>
			</tr>
			
			<tr>
				
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>남</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">이메일</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">전공과목</td>
				<td>${user.major}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">수강과목</td>
				<td colspan="2">${user.subjects}</td>
				
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">900101</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${user.reg}</td>
				
			</tr>
		</table>
		
		<br /> 
		<p>
			
		</p>
		<a href="${context}/member/member_controller.jsp">
			<img src="${img}/member.jpg" alt="member" style="width:30px" /></a>
			<a href="${context}/index.jsp">
		<img src="${img}/home.png" alt="member" style="width:30px" />
		</a>
	</div>
