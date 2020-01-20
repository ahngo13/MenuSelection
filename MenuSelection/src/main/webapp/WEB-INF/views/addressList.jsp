<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<ul class="list-group">
<!-- 지번주소 리스트 -->
<c:forEach items="${documentList}" var="list">
	<li class="list-group-item">
		<a onclick="javascript:addressSelect(${list.address.y}, ${list.address.x});" class="state-open">
		 ${list.addressName}
		</a>
	<%--  	 <li>region1depthName = ${list.address.region1depthName}</li>
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
		<li>y = ${list.address.y}</li>  --%>
	</li>
</c:forEach>
</ul>

<c:if test="${page > '1'}">
<button class="btn btn-primary" style="width: 150px;" onclick="javascript:addressSearch('back');">이전</button>
</c:if>
<c:if test="${kakaoBean.isEnd == false}">
<button class="btn btn-primary" style="width: 150px;" onclick="javascript:addressSearch('next');">다음</button>
</c:if>
<input type="hidden" id="page" value="${page}">

<%-- <br>
kakaoBean
isEnd = ${kakaoBean.isEnd} <br>
keyword = ${kakaoBean.keyword} <br>
pageableCount = ${kakaoBean.pageableCount} <br>
selectedRegion = ${kakaoBean.selectedRegion} <br>
totalCount = ${kakaoBean.totalCount} 
<hr> --%>

