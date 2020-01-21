<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
	<style>
	 	.table a {
	 		text-decoration: none;
	 	}
	 	
	</style>
	  
</head>
<body>	
	
 
	
	<div class="container" style="margin-top: 100px;">
	<table class="table table-bordered table-dark table-striped">
			<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>글쓴이</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bno }</td>
				<td><a href="/board/content?bno=${board.bno}">${board.title}</a></td>
				<td>${board.writer }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	
	
	</div>
	
	
	
</body>
</html>