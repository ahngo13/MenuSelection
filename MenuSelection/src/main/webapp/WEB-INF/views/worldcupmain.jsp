<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<%@include file ="/WEB-INF/views/common/header.jsp" %>

<body>

	<div class="container" style="margin: 30px; height: 500px;">
		<br><br><br>
			<h1 id="p" style="text-align: center; font-size:50px; font-weight: bold;">
				음식 월드컵을 시작하겠습니다...!!!<br>
				<br>
			</h1>
			<div style="text-align: center;">
				<input type="button" id="start"
					class="btn btn-primary, btn btn-primary btn-lg" id="p"
					onclick="button_click('0');" value="월드컵 시작" />
			</div>
			<br>

			<p id="p" style="text-align: center;">Select the images</p>
			<div style="text-align: center; " id="p">
				<img style="display: none;" id="test01" width="450" height="500"
					src="/resources/images/korean.jpg" class="rounded-circle" alt=""
					onclick="button_click('1');"> <img style="display: none;"
					id="test02" width="450" height="500"
					src="/resources/images/American.jpg" class="rounded-circle" alt=""
					onclick="button_click('2');"> <img style="display: none;"
					id="test03" width="450" height="500"
					src="/resources/images/japan.jpg" class="rounded-circle" alt=""
					onclick="button_click('3');"> <img style="display: none;"
					id="test04" width="450" height="500"
					src="/resources/images/chinese.jpg" class="rounded-circle" alt=""
					onclick="button_click('4');"> <input type="hidden" id="first"
					value="0"> <input type="hidden" id="second" value="0">
				<input type="hidden" id="finalfinal" value="0">
			</div>
			<br>
	</div>

	<script>
		function button_click(imgGb) {
			if ($("#finalfinal").val() == 0) {
				if (imgGb == 1 || imgGb == 2) {
					if (imgGb == 1) {
						alert("한식을 골랐습니다!!!");
					} else if (imgGb == 2) {
						alert("양식을 골랐습니다!!!");
					}
					$("#test03").show();
					$("#test04").show();
					$("#test01").hide();
					$("#test02").hide();

					$("#first").val(imgGb);

				} else if (imgGb == 3 || imgGb == 4) {
					if (imgGb == 3) {
						alert("일식을 골랐습니다!!!");
					} else if (imgGb == 4) {
						alert("중식을 골랐습니다!!!");
					}
					$("#test03").hide();
					$("#test04").hide();

					$("#second").val(imgGb);
					var second = $("#second").val();
					var first = $("#first").val();

					$("#test0" + first).show();
					$("#test0" + second).show();
					//final=999;
					$("#finalfinal").val(imgGb);
				} else if (imgGb == 0) {
					$("#start").hide();
					$("#test01").show();
					$("#test02").show();
				}
			}

			else {
				if (imgGb == 1) {
					alert("한식 먹으러 갑시다!!!");
					$("#test01").show();
					$("#test02").hide();
					$("#test03").hide();
					$("#test04").hide();
				} else if (imgGb == 2) {
					alert("양식 먹으러 갑시다!!!");
					$("#test02").show();
					$("#test01").hide();
					$("#test03").hide();
					$("#test04").hide();
				} else if (imgGb == 3) {
					alert("일식 먹으러 갑시다!!!");
					$("#test03").show();
					$("#test01").hide();
					$("#test02").hide();
					$("#test04").hide();
				} else if (imgGb == 4) {
					alert("중식 먹으러 갑시다!!!");
					$("#test04").show();
					$("#test01").hide();
					$("#test02").hide();
					$("#test03").hide();
				}
			}
		}
	</script>



</body>

<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</html>