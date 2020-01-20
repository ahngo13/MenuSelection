<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!-- 도로명주소 리스트 -->
<ul class="list-group">
<c:forEach items="${documentList}" var="list">
	<li class="list-group-item">
               <a onclick="javascript:addressSelect(${list.roadAddress.y}, ${list.roadAddress.x});" class="state-open">
                 ${list.roadAddress.addressName}
               </a>
	</li>
  	<%-- <li>region1depthName = ${list.roadAddress.region1depthName}</li>
	<li>region2depthName = ${list.roadAddress.region2depthName}</li>
	<li>region3depthName = ${list.roadAddress.region3depthName}</li>
	<li>roadName = ${list.roadAddress.roadName}</li>
	<li>undergroundYn = ${list.roadAddress.undergroundYn}</li>
	<li>mainBuildingNo = ${list.roadAddress.mainBuildingNo}</li>
	<li>subBuildingNo = ${list.roadAddress.subBuildingNo}</li>
	<li>buildingName = ${list.roadAddress.buildingName}</li>
	<li>zoneNo = ${list.roadAddress.zoneNo}</li>
	<li>x = ${list.roadAddress.x}</li>
	<li>y = ${list.roadAddress.y}</li>  --%>
</c:forEach>
</ul>
<c:if test="${page > 1}">
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
