<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box"style='padding-top:0'></div>
<div class="panel panel-default"></div>
<div class="panel-heading">계좌 목록</div>
<table id="account_list" class="table"></table>

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
  <li class="list-group-item">총게시글 : 120개</li>
</ul>
		<div class="panel panel-primary">
  <div class="panel-heading">자유게시판</div>
<table id="free_board_table">
  <tr>
	    <th>No.</th>
	    <th>제목</th>
	    <th>등록일</th>
	    <th>조회수</th>
  </tr>
  <tr>
    <td>12</td>
    <td><a class="name">하이루~방가방가!!</a></td>
    <td>1999.12.20</td>
    <td>10000</td>
    </tr>
  <tr>
    <td>11</td>
    <td><a class="name">게시판 11번글!</a></td>
    <td>1999.12.20</td>
    <td>10000</td>
    </tr>
  <tr>
    <td>10</td>
    <td><a class="name">freeboard Test~!!</a></td>
    <td>1999.12.20</td>
    <td>10000</td>
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