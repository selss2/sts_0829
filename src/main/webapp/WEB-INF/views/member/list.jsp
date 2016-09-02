<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box"style='padding-top:0'></div>
<div class="panel panel-default"></div>
<div class="panel-heading">학생 목록</div>
<table id="member_list" class="table"></table>

<style>
table {font-family: arial, sans-serif;border-collapse: collapse;width: 100%;}
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<div class="box" style='padding-top:0; width:90%'>
<ul class="list-group">
  <li class="list-group-item">홍 길 동</li>
  <li class="list-group-item">총학생수 : 120명</li>
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
  <tr>
    <td>hong</td>
    <td><a class="name">홍길동</a></td>
    <td>2016-09-01</td>
    <td>1980-01-01</td>
    <td>hong@test.com</td>
    <td>010-1234-5678</td>
<td><a class="regist">등록</a>/<a class="update">수정</a></td>  </tr>
   <tr>
    <td>hong</td>
    <td><a class="name">홍길동</a></td>
    <td>2016-09-01</td>
    <td>1980-01-01</td>
    <td>hong@test.com</td>
    <td>010-1234-5678</td>
    <td><a class="regist">등록</a>/<a class="update">수정</a></td>
  </tr>
    <tr>
    <td>hong</td>
    <td><a class="name">홍길동</a></td>
    <td>2016-09-01</td>
    <td>1980-01-01</td>
    <td>hong@test.com</td>
    <td>010-1234-5678</td>
<td><a class="regist">등록</a>/<a class="update">수정</a></td>
  </tr>
</table>
<nav aria-label="Page navigation">
  <ul class="pagination">
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
	
<script type="text/javascript">
	$(function(){
			$("#member_list_table .name").click(function(){controller.moveWithKey('member','a_detail','hong');});	
			$("#member_list_table .regist").click(function(){controller.moveWithKey('grade','regist','hong');});	
			$("#member_list_table .update").click(function(){controller.moveWithKey('grade','update','hong');});	
	});
</script>
