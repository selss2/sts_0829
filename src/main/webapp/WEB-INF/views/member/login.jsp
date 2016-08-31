<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="box">
 <form id = "member_login_form" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="id"  class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  name="pw" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="remember_me" value="remember-me"> Remember me
          </label>
        </div>
        <input class="btn btn-lg btn-primary btn-block" type="submit">Sign in</input>
      </form>
</section>
<script type ="text/javascript">
   $(function () {
      
      $('#member_login_form input[type="submit"]').click(function() {
               ('#member_login_form').submit();})
       $('#member_login_form').attr('action',app.context()+'/member/login/execute');
   });
</script>