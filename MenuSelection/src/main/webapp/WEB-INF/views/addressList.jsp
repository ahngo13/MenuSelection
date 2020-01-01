<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr>
<c:forEach items="${documentList}" var="list">
<ul>
	<li>addressName = ${list.addressName}</li>
	<li>region1depthName = ${list.roadAddress.region1depthName}</li>
	<li>region2depthName = ${list.roadAddress.region2depthName}</li>
	<li>region3depthName = ${list.roadAddress.region3depthName}</li>
	<li>roadName = ${list.roadAddress.roadName}</li>
	<li>undergroundYn = ${list.roadAddress.undergroundYn}</li>
	<li>mainBuildingNo = ${list.roadAddress.mainBuildingNo}</li>
	<li>buildingName = ${list.roadAddress.buildingName}</li>
	<li>zoneNo = ${list.roadAddress.zoneNo}</li>
	<li>x = ${list.roadAddress.x}</li>
	<li>y = ${list.roadAddress.y}</li>
</ul>
</c:forEach>
<hr>

kakaoBean
isEnd = ${kakaoBean.isEnd} <br>
keyword = ${kakaoBean.keyword} <br>
pageableCount = ${kakaoBean.pageableCount} <br>
selectedRegion = ${kakaoBean.selectedRegion} <br>
totalCount = ${kakaoBean.totalCount}
</hr>