<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!-- 음식점 리스트 -->
<ul class="list-group">
<c:forEach items="${placeList}" var="list" varStatus="status">
	<li class="list-group-item">
		<a onclick="javascript:placeSelect(${list.y}, ${list.x}, '${list.placeName}');" class="state-open">
			<div>
				<strong>${list.placeName}</strong> <span>${list.categoryName}</span> <span>(${list.distance}m)</span>
			</div>
			<div>
				${list.roadAddressName}(${list.addressName})
			</div>
			<div>
				${list.phone} <a href="${list.placeUrl}" target="_blank">상세보기</a>
			</div>
			<input type="hidden" id="listX${status.count}" value="${list.x}">
			<input type="hidden" id="listY${status.count}" value="${list.y}">
			<input type="hidden" id="listName${status.count}" value="${list.placeName}">
		</a>
	</li>

<%-- <ul>
	<li>id = ${list.id}</li>
	<li>placeName = ${list.placeName}</li>
	<li>categoryName = ${list.categoryName}</li>
	<li>categoryGroupCode = ${list.categoryGroupCode}</li>
	<li>categoryGroupName = ${list.categoryGroupName}</li>
	<li>phone = ${list.phone}</li>
	<li>addressName = ${list.addressName}</li>
	<li>roadAddressName = ${list.roadAddressName}</li>
	<li>x = ${list.x}</li>
	<li>y = ${list.y}</li>
	<li>place_url = ${list.placeUrl}</li>
	<li>distance = ${list.distance}</li>
</ul> --%>
</c:forEach>
</ul>

<%-- placeBean
isEnd = ${placeBean.isEnd} <br>
keyword = ${placeBean.keyword} <br>
pageableCount = ${placeBean.pageableCount} <br>
selectedRegion = ${placeBean.selectedRegion} <br>
totalCount = ${placeBean.totalCount}  --%>
<input type="hidden" id="pageableCount" value="${placeBean.pageableCount}">

