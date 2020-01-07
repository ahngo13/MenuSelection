<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<style>
		table, tr, td {
	 		border:1px solid black;
	 	}
	 	table {
	 		border-collapse: collapse;
	 		text-align:center;
	 	}
	 	td {
	 	font-size: 20px;
	 	}
	</style>
</head>
<body>
	<%-- <c:forEach items="${list}" var="board">
		e = ${board.bno }<br>
		a = ${board.title}<br>
		b = ${board.content }<br>
		c = ${board.writer }<br>
		d = ${board.passwd }<br><br>
	</c:forEach> --%>
	
	<div style="width:1300px; margin:100px auto">
		<table>
			<tr >
				<td style="width:200px;">번호</td>
				<td style="width:800px;">제목</td>
				<td style="width:300px;">글쓴이</td>
			</tr>
			
			<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bno }</td>
				<td><a href="/board/content?bno=${board.bno}">${board.title}</a></td>
				<td>${board.writer }</td>
			</tr>
			</c:forEach>
			
		</table>
	
	
	</div>
	
	
	
</body>
</html>