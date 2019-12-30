<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>KAKAO data</h1>
		region = ${result.region}<br>
		keyword = ${result.keyword}<br>
		selectedRegion = ${result.selectedRegion}<br>
		pageableCount = ${result.pageableCount}<br>
		totalCount = ${result.totalCount}<br>
		isEnd = ${result.isEnd}<br>
		
	<c:forEach items="${result.documentList}" var="document">
	<hr>
		placeName = ${document.placeName }<br>
		distance = ${document.distance}<br>
		placeUrl = ${document.placeUrl }<br>
		categoryName = ${document.categoryName }<br>
		addressName = ${document.addressName }<br>
		roadAddressName = ${document.roadAddressName }<br>
		id = ${document.id }<br>
		phone = ${document.phone }<br>
		categoryGroupCode = ${document.categoryGroupCode }<br>
		categoryGroupName = ${document.categoryGroupName }<br>
		x = ${document.x }<br>
		y = ${document.y }<br>
	</c:forEach>
				
		
</body>
</html>