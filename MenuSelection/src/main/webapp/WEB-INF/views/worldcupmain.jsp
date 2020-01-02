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
<!--  	<img alt="" src=""> -->

<p>Select the images</p>
<img id="scream" width="220" height="277" src="/resources/images/testimage.jpg" alt="Photo">

<!--"/resources/images/image/logo.png"-->
<script>
window.onload = function() {
  var c = document.getElementById("myCanvas");
  var ctx = c.getContext("2d");
  var img = document.getElementById("scream");
  ctx.drawImage(img, 10, 10);
}
</script>

</body>
</html>