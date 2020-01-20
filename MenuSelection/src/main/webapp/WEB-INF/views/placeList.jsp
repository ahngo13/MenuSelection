<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!-- 음식점 리스트 -->
<c:forEach items="${placeList}" var="list" varStatus="status">
	<div id="acordeon">
       <div class="panel-group" id="accordion">
         <div class="panel panel-default">
           <div class="panel-heading">
             <h4 class="panel-title">
               <a onclick="javascript:placeSelect(${list.y}, ${list.x}, '${list.placeName}');" class="state-open">
                 ${list.placeName}
               <input type="hidden" id="listX${status.count}" value="${list.x}">
               <input type="hidden" id="listY${status.count}" value="${list.y}">
               <input type="hidden" id="listName${status.count}" value="${list.placeName}">
               </a>
             </h4>
           </div>
         </div>
       </div>
   </div>
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
</c:forEach>

<br>
placeBean
isEnd = ${placeBean.isEnd} <br>
keyword = ${placeBean.keyword} <br>
pageableCount = ${placeBean.pageableCount} <br>
selectedRegion = ${placeBean.selectedRegion} <br>
totalCount = ${placeBean.totalCount} 
<input type="hidden" id="pageableCount" value="${placeBean.pageableCount}">

<hr>
