<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<hr>
<!-- 지번주소 리스트 -->
<c:forEach items="${documentList}" var="list">
<ul>
	<li onclick="javascript:addressSelect(${list.address.y}, ${list.address.x});">${list.addressName}</li>
 	 <li>region1depthName = ${list.address.region1depthName}</li>
	<li>region2depthName = ${list.address.region2depthName}</li>
	<li>region3depthName = ${list.address.region3depthName}</li>
	<li>region3depthName = ${list.address.region3depthHName}</li>
	<li>hCode = ${list.address.hCode}</li>
	<li>bCode = ${list.address.bCode}</li>
	<li>mountainYn = ${list.address.mountainYn}</li>
	<li>mainAddressNo = ${list.address.mainAddressNo}</li>
	<li>subAddressNo = ${list.address.subAddressNo}</li>
	<li>zipCode = ${list.address.zipCode}</li>
	<li>x = ${list.address.x}</li>
	<li>y = ${list.address.y}</li> 
</ul>
</c:forEach>

<c:if test="${page > '1'}">
<input value="이전" type="button" onclick="javascript:addressSearch('back');">
</c:if>
<c:if test="${kakaoBean.isEnd == false}">
<input value="다음" type="button" onclick="javascript:addressSearch('next');">
</c:if>
<input type="hidden" id="page" value="${page}">
<hr>

kakaoBean
isEnd = ${kakaoBean.isEnd} <br>
keyword = ${kakaoBean.keyword} <br>
pageableCount = ${kakaoBean.pageableCount} <br>
selectedRegion = ${kakaoBean.selectedRegion} <br>
totalCount = ${kakaoBean.totalCount} 
<hr>
