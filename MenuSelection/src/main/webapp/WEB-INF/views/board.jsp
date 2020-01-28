<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<%@include file="/WEB-INF/views/common/header.jsp"%> 
	

	<div class="container" id="p" style="margin-top: 100px; margin-bottom:200px;">
		<table class="table table-bordered table-striped">
			<thead style="border-bottom: 3px solid lightgray;">
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
		
		<a href="/board/writeBoard"><input class="btn btn-secondary" type="button" value="글쓰기"></a>
	
	
	</div>
	
	
	
</body>

<%@include file="/WEB-INF/views/common/footer.jsp"%>

</html>