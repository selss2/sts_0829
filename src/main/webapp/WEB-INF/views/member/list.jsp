<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var = "pgSize" value = "10"/>
<c:choose>
	<c:when test = "${totCount %pgSize eq 0}">
		<c:set var = "totPg" value = "${totCount/pgSize}"/>
	</c:when>
	<c:otherwise>
		<c:set var = "tatPg" value = "${totCount/pgSize+1}"/>
	</c:otherwise>
</c:choose>
<c:set var = "starPg" value = "${pgNum - ((pgNum-1)%pgSize)}"/>
<c:choose>
	<c:when test = "${starPg +pgSize-1 le totPg}">
		<c:set var = "lastpg" value = "${starPg + pgSize -1}"/>
	</c:when>
<c:otherwise>
	<c:set var = "lastpg" value = "${totPg}"/>
</c:otherwise>		
</c:choose>	

<div class="box" style='padding-top:0; width:90%'>
<ul class="list-group">
  <li class="list-group-item">홍 길 동</li>
  <li class="list-group-item">총학생수 : ${totCount}</li>
</ul>
		<div class="panel panel-primary">
  <div class="panel-heading">학생 리스트</div>
<table id="member_list_table">
  <tr>
	    <th>ID</th>
	    <th>이 름</th>
	    <th>등록일</th>
	    <th>생년월일</th>
	    <th>이메일</th>
	    <th>전화번호</th>
	    <th>성적</th>
  </tr>
  <tbody>
  <c:forEach items="${list}" var="member">
  <tr>
    <td>${member.id}</td>
    <td><a class="name">${member.name}</a></td>
    <td>${member.regDate}</td>
    <td>${member.birth}</td>
    <td>${member.email}</td>
    <td>${member.phone}</td>
    <td>${member.grade}</td>
<td><a class="regist">등록</a>/<a class="update">수정</a></td>
</tr>
</c:forEach>

  <tbody>
</table>

<nav aria-label="Page navigation">
  <ul class="pagination">
  	<c:if test="${starPg - pgSize gt 0}">
  		<li>
  			<a href = "${context}/member/list/${starPg-pgSize}" aria-label="Previous">
  				<span aria-hidden = "true">&laquo;</span>
  			</a>
  		</li>
  	</c:if>
  	
  	<c:forEach begin = "${starPg}" end = ${lastPg} step = "1" varStatus = "1">
  		<c:choose>
  			<c:when test = ${}
  
  
  
  
  
  
  
  
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
	</div>