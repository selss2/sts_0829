<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="apple-touch-icon" sizes="57x57" href="${img}/favicons/apple-touch-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="${img}/favicons/apple-touch-icon-60x60.png">
<link rel="icon" type="image/png" href="${img}/favicons/favicon-32x32.png" sizes="32x32">
<link rel="icon" type="image/png" href="${img}/favicons/favicon-16x16.png" sizes="16x16">
<link rel="manifest" href="${img}/favicons/manifest.json">
<link rel="shortcut icon" href="${img}/favicons/favicon.ico">
<!-- Normalize -->
<link rel="stylesheet" type="text/css" href="${css}/normalize.css">
<!-- Owl -->
<link rel="stylesheet" type="text/css" href="${css}/owl.css">
<!-- Animate.css -->
<link rel="stylesheet" type="text/css" href="${css}/animate.css">
<!-- Font Awesome -->
<link rel="stylesheet" type="text/css" href="${css}/font//font-awesome-4.1.0/css/font-awesome.min.css">
<!-- Elegant Icons -->
<link rel="stylesheet" type="text/css" href="${css}/font//eleganticons/et-icons.css">
<!-- Main style -->
<link rel="stylesheet" type="text/css" href="${css}/cardio.css">
	<section id="services" class="box section-padded">
		<div>
			<div class="row text-center title">
				<h2>Services</h2>
				<h4 class="light muted">다양한 기능을 즐겨보세요</h4>
			</div>
			<div class="row services">
				<div class="col-md-4">
					<div class="service">
						<div class="icon-holder">
							<img src="${img}/icons/heart-blue.png" alt="" class="icon">
						</div>
						<h4 class="heading">카우푸 지수</h4>
						<p class="description">kaup지수 구하기</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="service">
						<div class="icon-holder">
							<img src="${img}/icons/rockpaper.png" alt="" class="icon">
						</div>
						<h4 class="heading">가위바위보</h4>
						<p class="description">안내면술래</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="service">
						<div class="icon-holder">
							<img src="${img}/icons/lotto.png" alt="" class="icon">
						</div>
						<h4 class="heading">로또</h4>
						<p class="description">배팅</p>
					</div>
				</div>
			</div>
		</div>
		<div class="cut cut-bottom"></div>
	</section>
	<section id="team" class="section gray-bg">
		<div class="container">
			<div class="row title text-center">
				<h2 class="margin-top">KBO 리그</h2>
				<h4 class="light muted">TOP 3</h4>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="team text-center">
						<div class="cover" style="background:url('${img}/team/bears_cover.jpg'); background-size:cover;">
							<div class="overlay text-center">
								<h3 class="white">$69.00</h3>
								<h5 class="light light-white">1 - 5 sessions / month</h5>
							</div>
						</div>
						<img src="${img}/team/team_bears.png" alt="Team Image" class="avatar">
						<div class="title">
							<h4>수강과목1</h4>
							<h5 class="muted regular">두산 베어스</h5>
						</div>
						<button data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill">Sign Up Now</button>
					</div>
				</div>
				<div class="col-md-4">
					<div class="team text-center">
						<div class="cover" style="background:url('${img}/team/tigers_cover.jpg'); background-size:cover;">
							<div class="overlay text-center">
								<h3 class="white">$69.00</h3>
								<h5 class="light light-white">1 - 5 sessions / month</h5>
							</div>
						</div>
						<img src="${img}/team/team_tigers.jpg" alt="Team Image" class="avatar">
						<div class="title">
							<h4>수강과목2</h4>
							<h5 class="muted regular">기아 타이거즈</h5>
						</div>
						<a href="#" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill ripple">Sign Up Now</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="team text-center">
						<div class="cover" style="background:url('${img}/team/twins_cover.jpg'); background-size:cover;">
							<div class="overlay text-center">
								<h3 class="white">$69.00</h3>
								<h5 class="light light-white">1 - 5 sessions / month</h5>
							</div>
						</div>
						<img src="${img}/team/team_twins.png" alt="Team Image" class="avatar">
						<div class="title">
							<h4>수강과목3</h4>
							<h5 class="muted regular">엘지 트윈스</h5>
						</div>
						<a href="#" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill ripple">Sign Up Now</a>
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