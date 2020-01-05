<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<%@include file ="/WEB-INF/views/common/header.jsp" %>

<body>
<center>
<h1>Kakao Map</h1>
</center>
<p style="margin-top:-12px">
    <b>Chrome 브라우저는 https 환경에서만 geolocation을 지원합니다.</b> 참고해주세요.
</p>
<div id="map" style="width:100%;height:350px;"></div>
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8507bdcbfea943c9e828a2a8c91bd11a"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 10 // 지도의 확대 레벨 
	    }; 
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	/*
	크롬에서는 geolocation이 ssl 적용하지 않을 경우 사용 불가하므로 테스트를 위해 주석 처리
	
	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	} */
	
	// 지도에 마커와 인포윈도우를 표시하는 함수입니다
	function displayMarker(locPosition, message) {
	
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;
	
	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
	}   

	function addressSearch(beforeNextGb){
		var keyword = jQuery('#keyword');
		var page = Number.parseInt(jQuery('#page').val());
	
		if(beforeNextGb == 'back'){
			page--;
		}else if(beforeNextGb == 'next'){
			page++;
		}else{
			page = 1;
		}
		
		if(keyword.val() == '' || keyword.val() == undefined){
			alert('주소를 입력 해주세요.');
			keyword.focus();
			return;
		}
		
		/* var formData = ({
			email: email.val(),
			password : password.val()
		}) */
		
		jQuery.ajax({
		    type: "get",
			//data: formData,
	        url:'/kakao/address-search?keyword='+keyword.val()+'&page='+page,
	        success:function(data){
	        	jQuery('#address-list').empty();
	        	jQuery('#address-list').append(data);
	        	
			   /* if(data == '200'){
				   alert('200');
				   //goURL('/member/join-success');
				   return;
			   } */
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
                //jQuery('#goodsListLoadingZone').hide();
                //ui_loading.detachLoading();//로딩이미지 none
                alert("일시적인 장애가 발생했습니다. 잠시후에 다시 요청 하시기 바랍니다.");
    		}
	    })
	}
	
 	function addressSelect(x, y){
		
		var locPosition = new kakao.maps.LatLng(x, y); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
		var message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
	} 
	 

	
	/*
	var totalCount              = '$!{totalRowCnt}';          
	var loadingZoneCurrentPage  = Number(jQuery('#hospitalListLoadingZone').attr('currentpage'));
	var rowsPerPage             = $!{rowsPerPage};
	var loadingZoneIsMoreData   = (jQuery('#hospitalListLoadingZone').attr('ismoredata') == "true");
	var ajaxLoding              = false;
	var nextPage                = $!{currentPage};

	function addlist(){
	    
	    if (loadingZoneIsMoreData && !ajaxLoding)  {
	        loadingZoneCurrentPage++;
	        nextPage++;
	        ajaxLoding = true;
	        
	        //var paramList = [];
	        //paramList.push("pageNo=");
			if(nextPage == '' || nextPage == undefined){
	        		nextPage = 1;
	    	}
	        
			jQuery.ajax({
			    type: "get",
	            url:'/hospital-list/more?' + 'currentPage=' + nextPage ,
				dataType: "html",
	            success:function(data){
			   	   jQuery('#hospitalList').append(data); //.trigger("create");
				   ui_more.init(addlist);
				   
				   ajaxLoding = false; 
				   return;
	            },
				error: function(jqXHR, textStatus, errorThrown) {
	                        //jQuery('#goodsListLoadingZone').hide();
	                        //ui_loading.detachLoading();//로딩이미지 none
	                        alert("일시적인 장애가 발생했습니다. 잠시후에 다시 요청 하시기 바랍니다.");
	            }
	        })
	        //ui_loading.attachLoading();//로딩이미지 block
	        
	        loadingZoneIsMoreData = (totalCount/rowsPerPage > loadingZoneCurrentPage) ? true : false;
	    }
	}
	*/
	
</script>
	<div class="form-group">
	    <input type="text" id="keyword" name="keyword" placeholder="주소 입력" class="form-control" />
	</div>  
	<button class="btn btn-primary" onclick="javascript:addressSearch();">주소 검색</button>
	<div id="address-list"></div>
	
	<h2>키워드 검색</h2>
		region = ${result.region}<br>
		keyword = ${result.keyword}<br>
		selectedRegion = ${result.selectedRegion}<br>
		pageableCount = ${result.pageableCount}<br>
		totalCount = ${result.totalCount}<br>
		isEnd = ${result.isEnd}<br>
		
	<c:forEach items="${result.documentList}" var="document">
	<hr>
		placeName = ${document.placeName}<br>
		distance = ${document.distance}<br>
		placeUrl = ${document.placeUrl}<br>
		categoryName = ${document.categoryName}<br>
		addressName = ${document.addressName}<br>
		roadAddressName = ${document.roadAddressName}<br>
		id = ${document.id}<br>
		phone = ${document.phone}<br>
		categoryGroupCode = ${document.categoryGroupCode}<br>
		categoryGroupName = ${document.categoryGroupName}<br>
		x = ${document.x}<br>
		y = ${document.y}<br>
	</c:forEach>
				
		
</body>

<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</html>