<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>

<%@include file="/WEB-INF/views/common/header.jsp"%>

<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>오늘 뭐먹지?</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">메인</a></li>
				<li class="nav-item"><a class="nav-link" href="/worldcup/main">음식 월드컵</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/main">맛집 공유 게시판</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<h2>About Me</h2>
				<h5>Photo of me:</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text about me in culpa qui officia deserunt mollit
					anim..</p>
				<h3>Some Links</h3>
				<p>Lorem ipsum dolor sit ame.</p>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="#">Active</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<h2>TITLE HEADING</h2>
				<h5>Title description, Dec 7, 2017</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text..</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum
					consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco.</p>
				<br>
				<h2>TITLE HEADING</h2>
				<h5>Title description, Sep 2, 2017</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text..</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum
					consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco.</p>
			</div>
		</div>
	</div>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>

</body>

<%@include file="/WEB-INF/views/common/footer.jsp"%>

</html>