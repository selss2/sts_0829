<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<link rel="apple-touch-icon" sizes="57x57"
   href="${img}/favicons/apple-touch-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
   href="${img}/favicons/apple-touch-icon-60x60.png">
<link rel="icon" type="image/png"
   href="${img}/favicons/favicon-32x32.png" sizes="32x32">
<link rel="icon" type="image/png"
   href="${img}/favicons/favicon-16x16.png" sizes="16x16">
<link rel="manifest" href="${img}/favicons/manifest.json">
<link rel="shortcut icon" href="${img}/favicons/favicon.ico">
<link rel="stylesheet" type="text/css" href="${css}/normalize.css">
<link rel="stylesheet" type="text/css" href="${css}/application.css">
<link rel="stylesheet" type="text/css" href="${css}/owl.css">
<link rel="stylesheet" type="text/css" href="${css}/animate.css">
<link rel="stylesheet" type="text/css" href="${css}/fonts/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${css}/et-icons.css">
<link rel="stylesheet" type="text/css" href="${css}/cardio.css">
<section id="user_content" class="box section-padded">
   <div>
      <div class="row text-center title">
         <h2>Services</h2>
         <h4 class="light muted">Achieve the best results with our wide
            variety of training options!</h4>
      </div>
      <div class="row services">
         <div class="col-md-4">
            <div id="kaup" class="service">
               <div class="icon-holder">
                  <img src="${img}/icons/heart-blue.png" alt="" class="icon">
               </div>
               <h4 class="heading">KAUP INDEX</h4>
               <p class="description">카우프 지수</p>
            </div>
         </div>
         <div class="col-md-4">
            <div id="rock_sissor_paper" class="service">
               <div class="icon-holder">
                  <img src="${img}/icons/rockpaper.png" alt="" class="icon">
               </div>
               <h4 class="heading">ROCK SISSOR PAPER</h4>
               <p class="description">가위바위보</p>
            </div>
         </div>
         <div class="col-md-4">
            <div  id="lotto" class="service">
               <div class="icon-holder">
                  <img src="${img}/icons/lotto.png" alt="" class="icon">
               </div>
               <h4 class="heading">LOTTO DRAWING</h4>
               <p class="description">로또</p>
            </div>
         </div>
      </div>
   </div>
   <div class="cut cut-bottom"></div>
</section>
<section id="user_content_subject" class="section gray-bg">
   <div class="container">
         <div class="row title text-center">
            <h2 class="margin-top">MAJOR SUBJECT</h2>
            <h4 class="margin-top">TOP 3</h4>
         </div>
               <div class="row">
         <div class="col-md-4">
            <div id="major_subject_1" class="team text-center" value="java">
               <div class="cover"
                  style="background:url('${img}/team/bears_cover.jpg'); background-size:cover;">
                  <div class="overlay text-center">
                     <h3 class="white">자바</h3>
                     <h5 class="light light-white">자바</h5>
                  </div>
               </div>
               <img src="${img}/team/team_bears.png" alt="Team Image" class="avatar">
               <div class="title">
                  <h4>Java</h4>
                  <h5 class="muted regular">Server Program Language</h5>
               </div>
               <input type="hidden" name='major_subject_1' value="java">
               <input type="button" data-toggle="modal" data-target="#modal1"
                  class="btn btn-blue-fill" value="과목 정보 보기"/>
            </div>
         </div>
         <div class="col-md-4">
            <div id="major_subject_2" class="team text-center" value="javascript">
               <div class="cover"
                  style="background:url('${img}/team/tigers_cover.jpg'); background-size:cover;">
                  <div class="overlay text-center">
                     <h3 class="white">How are you?</h3>
                     <h5 class="light light-white">glad to meet you</h5>
                  </div>
               </div>
               <img src="${img}/team/team_tigers.jpg" alt="Team Image" class="avatar">
               <div class="title">
                  <h4>Java script</h4>
                  <h5 class="muted regular">UI Program Language</h5>
               </div>
               <input type="hidden" name='major_subject_2' value="javascript">
               <input type="button" data-toggle="modal" data-target="#modal1"
                  class="btn btn-blue-fill" value="과목 정보 보기"/>
            </div>
         </div>
         <div class="col-md-4">
            <div id="major_subject_3" class="team text-center" value="spring">
               <div class="cover"
                  style="background:url('${img}/team/twins_cover.jpg'); background-size:cover;">
                  <div class="overlay text-center">
                     <h3 class="white">Hi</h3>
                     <h5 class="light light-white">happy to meet you</h5>
                  </div>
               </div>
               <img src="${img}/team/team_twins.png" alt="Team Image" class="avatar">
               <div class="title">
                  <h4>Spring</h4>
                  <h5 class="muted regular">그냥 어려움</h5>
               </div>
               <input type="hidden" name='major_subject_3' value="spring">
               <input type="button" data-toggle="modal" data-target="#modal1"
                  class="btn btn-blue-fill" value="과목 정보 보기"/>
            </div>
         </div>
      </div>
   </div>
</section>
<script src="${js}/owl.carousel.min.js"></script>
<script src="${js}/wow.min.js"></script>
<script src="${js}/typewriter.js"></script>
<script src="${js}/jquery.onepagenav.js"></script>
<script src="${js}/main.js"></script>