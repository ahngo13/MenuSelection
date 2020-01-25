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
	
	<%
		String message=(String)request.getAttribute("status");
	
		if(message.equals("fail")){ 
		
			
	%>
	
	<script>
		alert("비밀먼호가 틀립니다");
		history.back();
	</script>
	
	<% 
		} else if(message.equals("update")){
	%>
		
	
	<script>
		alert("수정되었습니다");
	</script>
	
	<%
		} else if(message.equals("delete")){
	%>
	
	<script>
		alert("삭제되었습니다");
	</script>
	
	<%
		} else if(message.equals("insert")){	
	%>
	
	<script>
		alert("게시되었습니다");
	</script>
	
	<%
		}else {
	%>
	<script>
		alert('에러');
		history.back();
	</script>
	<%
	}
	%>
	
	<script>
		location.href="/board/main";
	</script>

</body>
</html>