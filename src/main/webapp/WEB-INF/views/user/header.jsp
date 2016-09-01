<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="user_header"  class="navbar navbar-default"  style='height: 50px'>
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
    <img id="header_brand">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">내계좌 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">계좌 정보</a></li>
            <li><a href="#">계좌생성</a></li>
            <li><a href="#">입출금</a></li>
            <li><a href="#">계좌해지</a></li>
            
          </ul>
        </li>
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">내성적 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">성적목록</a></li>
            <li><a href="#">성적조회</a></li>
            
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="과목명만 입력">
        </div>
        <button type="submit" class="btn btn-default">과목별 조회</button>
      </form>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav navbar-right">
        <li style="text-align:right; margin-top:14px;">${user}님 환영합니다</li>
        <li><a id="logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>로그아웃</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>  <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">비밀번호 변경</a></li>
          </ul>
        </li>
      </ul>
    </div>
    </div>
    
  </div>
</nav>
<script type="text/javascript">
$(function(){
	$('#user_header').css('height','50px');
	$('.navbar-header').css('height','50px');
	$('#user_header #logout').addClass('cursor').click(function() {controller.home();});
});
</script>