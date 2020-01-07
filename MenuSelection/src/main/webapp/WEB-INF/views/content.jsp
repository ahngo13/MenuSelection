<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	 	}
	 	td {
	 	font-size: 20px;
	 	}
	 	input[type=text] {
	 		width: 95%;
			margin-bottom:7px;
			maring-left: 7px;
	 	}
	 	textarea {
	 		margin: 7px;
	 	}
	 	.btn {
	 		height: 30px;
	 		width: 70px;
	 		
	 	}
	</style>
</head>
<body>

	<div style="width:1100px; margin:100px auto">
		
		<form>
			<table style="max-width:1100px; width:1100px;">
				<c:forEach items="${list}" var="board">
				<tr style="width:100px;">
					<td>번호</td>
					<td>${board.bno}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="20" cols="100">${board.writer}</textarea></td>
				</tr>
				</c:forEach>
			
			</table>
			
			<div style="border: 1px solid black; width:400px; margin-top:10px; padding:3px;">
				비밀번호 : <input type="password" name="passwd" style="width:75%;" >
			</div>
			<div style="float:left; margin-top:10px;">
					<input type="submit" name=action value="commit" class="btn">
					<input type="submit" name="action" value="delete" class="btn">
					<a href="/board/main"><input class="btn" type="button" value="cancel"></a>
			</div>
	
		</form>
	
	</div>
	
	
	
</body>
</html>