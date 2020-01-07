<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!-- 음식점 리스트 -->
<c:forEach items="${placeList}" var="list">
	<div id="acordeon">
       <div class="panel-group" id="accordion">
         <div class="panel panel-default">
           <div class="panel-heading">
             <h4 class="panel-title">
               <a onclick="javascript:addressSelect(${list.y}, ${list.x});" class="state-open">
                 ${list.placeName}
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
isEnd = ${kakaoBean.isEnd} <br>
keyword = ${kakaoBean.keyword} <br>
pageableCount = ${kakaoBean.pageableCount} <br>
selectedRegion = ${kakaoBean.selectedRegion} <br>
totalCount = ${kakaoBean.totalCount} 

<hr>