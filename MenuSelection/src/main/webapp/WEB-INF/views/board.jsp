<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="board">
		e = ${board.bno }<br>
		a = ${board.title}<br>
		b = ${board.content }<br>
		c = ${board.writer }<br>
		d = ${board.passwd }<br><br>
	</c:forEach>
	
	
	
	
</body>
</html>