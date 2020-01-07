<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<%@include file ="/WEB-INF/views/common/header.jsp" %>

<body>
<h1>
	Start The Food WorldCup!!!
</h1>

<input type="button" id="start" onclick="button_click('0');" value="Start the WorldCup"/>

<br>

<p>Select the images</p>
 
		<img style="display:none;" id="test01" width="220" height="277" src="/resources/images/testimage.jpg" alt="" onclick="button_click('1');"> 
		<img style="display:none;" id="test02" width="220" height="277" src="/resources/images/testimage2.jpg" alt="" onclick="button_click('2');">
		<img style="display:none;" id="test03" width="220" height="277" src="/resources/images/testimage3.jpg" alt="" onclick="button_click('3');">
		<img style="display:none;" id="test04" width="220" height="277" src="/resources/images/testimage4.jpg" alt="" onclick="button_click('4');">
		<input type="hidden" id="first" value="">
		<input type="hidden" id="second" value="">
<br>


<script>
	var first=0;
	var second=0;

	function button_click(imgGb) {
		if(imgGb==1 || imgGb==2){
			if(imgGb==1){
				alert("You select the NO_1.");
			}
			else if(imgGb==2){
				alert("You select the NO_2.");
			}
			$("#test03").show();
			$("#test04").show();
			$("#test01").hide();
			$("#test02").hide();
			
			$("#first").val(imgGb);
			var first = $("#first").val();
		}
		else if(imgGb==3 || imgGb==4){
			if(imgGb==3){
				alert("You select the NO_3.");
			}
			else if(imgGb==4){
				alert("You select the NO_4.");
			}
			$("#test03").hide();
			$("#test04").hide();
			
			$("#second").val(imgGb);
			var second = $("#second").val();
		}
		else if(imgGb==0){
			$("#start").hide();
			$("#test01").show();
			$("#test02").show();
		}
		
		
/* 		 if(first!=0 && second!=0){
			$("#test0"+first).show();
			$("#test0"+second).show();

		}  */
		
		
		
	}
	
</script>



</body>

<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</html>