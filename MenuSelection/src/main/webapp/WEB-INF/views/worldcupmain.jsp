<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WorldcupMain</title>

</head>
<body>
<h1>
	Start The Food WorldCup!!!
</h1>

<input type="button" id="button" onclick="button0_click();" value="Start the WorldCup"/>

<br>
<p>Select the images</p>
 
		<a href="#">
		<img id="test01" width="220" height="277" src="/resources/images/testimage.jpg" alt="" onclick="button1_click();"> 
		<img id="test02" width="220" height="277" src="/resources/images/testimage2.jpg" alt="" onclick="button2_click();">
		<img id="test03" width="220" height="277" src="/resources/images/testimage3.jpg" alt="" onclick="button3_click();">
		<img id="test04" width="220" height="277" src="/resources/images/testimage4.jpg" alt="" onclick="button4_click();"></a>

<br>
<img width="220" height="277" src="/resources/images/testimage.jpg" 
onmouseover="this.src='none'" 
onmouseout="this.src='/resources/images/testimage.jpg'">

<img width="220" height="277" src="/resources/images/testimage.jpg" 
onclick="this.src='none'" 
onmouseout="this.src='/resources/images/testimage2.jpg'">


<script>

	function button0_click() {
		alert("Start the WorldCup");		
	}
	function button1_click() {
		alert("You select the NO_1.");
	}
	function button2_click() {
		alert("You select the NO_2.");
	}
	function button3_click() {
		alert("You select the NO_3.");
	}
	function button4_click() {
		alert("You select the NO_4.");
	}
	
	
</script>



</body>
</html>