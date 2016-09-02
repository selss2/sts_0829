<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default"  style='height: 50px'>
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
     <ul class="nav navbar-nav navbar-right">
        <li><a id="a_school_info"><span class="glyphicon glyphicon-education" aria-hidden="true"></span>학교 소개</a></li></ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a id="a_school_map"><span class="glyphicon glyphicon-road" aria-hidden="true"></span>오시는 길</a></li></ul>
    <div class="navbar-header"><a id = "go_public_home"><img id="header_brand"></a></div>
      <ul class="nav navbar-nav navbar-right">
        <li><a id="free_board"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>자유 게시판</a></li></ul>
    </div>
    
</nav>
<script>
$(function(){
$('#go_public_home').click(function(){controller.home();});
$('#a_school_info').click(function(){controller.move('public','school_info');});
$('#a_school_map').click(function(){controller.move('public','school_map');});
$('#free_board').click(function(){controller.move('public','free_board');});
});
</script>