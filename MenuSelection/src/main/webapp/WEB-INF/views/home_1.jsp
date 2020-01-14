<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@include file ="/WEB-INF/views/common/header.jsp" %>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.tim-title{
	text-align:center;
}
.kakaomapview{
	border-style:solid;
	border-width:2px;
	height:500px;
	text-align:center;
}
.menuicon{
	border:solid 2px green;
	height:104px;
	text-align:center;
	margin-bottom:10px;
}
.imgcon{
	max-width: 100%;
	height: 100px;
	padding: 0px;
	display:inline;
	margin:50px;
}
#id{
	height:100px;
}

</style>
</head>
<body style>
	<div class=main>
		<div class="contariner tim-container">
			<div class="tim-title">
				<h1>오늘 뭐먹지?</h1>
			</div>
		</div>

		<div id="navbar">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/">TIE</a>
					</div>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="/">주변 식당들</a>
							<li><a href="/worldcup/main">오늘 뭐먹지 월드컵</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="menuicon">
			<ul>
				<li class="imgcon"><img src="/resources/images/jjajang.jpg" id="im"></li>
				<li class="imgcon"><img src="/resources/images/chobab.jpg" id="im"></li>
				<li class="imgcon"><img src="/resources/images/st.jpg" id="im"></li>
			</ul>
		</div>
		<div class="kakaomapview">
			<h3>여기에 지도 들어올거야</h3>
		</div>

	</div>
	
	
</body>

<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</html>