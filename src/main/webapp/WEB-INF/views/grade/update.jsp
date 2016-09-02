<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<section id="grade_update">
	<form id="grade_update_form">
	<ul class="list-group">
		<li class = "list-group-item">이름 : 홍길동</li>
		<li class = "list-group-item">성별 : 남</li>
		<li class = "list-group-item">전공 : 컴퓨터 공학</li>
		<li class = "list-group-item">학년 : 3학년</li>
	</ul>
	<div>
    	<label for="ex1">Java</label>
    	<div><input type="text" id="id" name="id" placeholder="90"></div>
  	</div>
  	<div>
    	<label for="ex1">Javascript</label>
    	<div><input type="text" id="id" name="id" placeholder="90"></div>
  	</div>
  	<div>
    	<label for="ex1">SQL</label>
    	<div><input type="text" id="id" name="id" placeholder="90"></div>
  	</div>
  	<div>
    	<label for="ex1">HTML</label>
    	<div><input type="text" id="id" name="id" placeholder="90"></div>
  	</div>
  		<input type="hidden" name="action" value="regist" />
		<input type="hidden" name="page" value="login" />
		<input id="bt_send" type="submit" value="수 정"/>
		<input id="bt_cancel" type="reset" value="취 소"/>
	</form>
</section>

<script type="text/javascript">
$(function() {
	$('#grade_update').addClass('box').css('padding-top','0');
	$('#grade_update #bt_send').addClass('btn').addClass(' btn-primary');
	$('#grade_update #bt_cancel').addClass('btn').addClass(' btn-danger');
	$('#grade_update_form').addClass('form-horizontal');
	$('#grade_update_form > div').addClass('form-group').addClass('form-group-lg');
	$('#grade_update_form > div > label').addClass('col-sm-2').addClass('control-label');
	$('#grade_update_form > div > div').addClass('col-sm-10');
	$('#grade_update_form > div > div > input').addClass('form-control');
	$('#grade_update #rd_major > label:gt(1)').addClass('radio-inline');
});
</script>
