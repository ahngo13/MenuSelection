<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<%@include file="/WEB-INF/views/common/header.jsp"%> 

<style>
	
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
 
</style>
	
	<div class="container" style="margin-top: 100px; margin-bottom:200px; position: relative; ">
		
		<form action="/board/action" method="post">
			<table class="table table-bordered">
				
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="10" cols="100"></textarea></td>
				</tr>

			</table>
			
			<div style="position: absolute; right:13px;">
				<div style="border: 1px solid black; width:400px; margin-top:10px; padding:3px; ">
					작성자 : <input type="text" name="writer" style="width:75%;" >
				</div>
				<div style="border: 1px solid black; width:400px; margin-top:10px; padding:3px; ">
					비밀번호 : <input type="password" name="passwd" style="width:75%;" >
				</div>
				<div style="margin-top: 10px; float: right;">
						<input type="submit" name=action value="insert" class="btn btn-secondary">
						<a href="/board/main"><input class="btn btn-secondary" type="button" value="cancel"></a>
				</div>
			</div>
	
		</form>
	</div>
	
	
	
</body>

<%@include file="/WEB-INF/views/common/footer.jsp"%>

</html>