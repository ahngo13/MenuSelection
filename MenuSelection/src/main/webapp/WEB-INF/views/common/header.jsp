<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>What am i eating today?</title>  	
  	<link rel="shortcut icon" href="#">

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Hi+Melody&display=swap&subset=korean" rel="stylesheet">
	<style>
		#p {
        font-family: "Hi Melody", cursive;
        font-size: 23px;
      	}
      	#ps{
      		font-weight: 500;
      	}
	</style>
	
	
</head>

<body>
	<div class="jumbotron text-center" style="margin-bottom: 0" id="p">
		<h1 style="font-size:50px; font-weight: bold;">오늘 뭐먹지?</h1>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="p">
		<a class="navbar-brand" href="/" id="p">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar" id="p">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar p">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/worldcup/main" id="p ps" > 음식 월드컵 </a></li>
				<li class="nav-item"><a class="nav-link" href="/board/main"id="p ps"> 맛집 공유 게시판 </a></li>
			</ul>
		</div>
	</nav>