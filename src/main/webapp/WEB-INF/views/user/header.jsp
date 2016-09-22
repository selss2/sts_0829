<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="user_header"  class="navbar navbar-default"  style='height: 50px'>
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
    <a id="go_user_home"><img id="header_brand"></a>
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
          <ul id="account" class="dropdown-menu">
            <li><a>계좌 정보</a></li>
            <li><a>계좌생성</a></li>
            <li><a>입출금</a></li>
            <li><a>계좌해지</a></li>
            
          </ul>
        </li>
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">내성적 <span class="caret"></span></a>
          <ul id ="grade" class="dropdown-menu">
            <li><a>최근 성적 보기</a></li>
            <li><a>지난 성적 조회</a></li>
            
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
        <li style="text-align:right; margin-top:14px;">${user.name}님 환영합니다</li>
        <li><a id="logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>로그아웃</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>  <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a id = "a_mypage" href="#">마이페이지</a></li>
            <li><a id = "a_detail" href="#">내정보 보기</a></li>
            <li><a id = "a_update" href="#">내정보 수정</a></li>
            <li><a id = "a_delete" href="#">회원탈퇴</a></li>
          </ul>
        </li>
      </ul>
    </div>
    </div>
    
  </div>
</nav>

<script type="text/javascript">
$(function() {
	$('#logout').click
});
</script>