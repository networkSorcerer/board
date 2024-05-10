<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<main class="form-signin w-100 m-auto">
		<c:if test="${empty adminLogin}">
		<form id="loginForm">
			<h1 class="h3 mb-3 fw-normal">관리자 로그인 페이지</h1>
			
			<div class="form-floating">
				<input type="text" class="form-control"
				name="adminId" id="adminId" placeholder="Admin Id">
				<label for="adminId">Admin Id</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control"
				name="adminPasswd" id="adminPasswd" placeholder="Admin Password">
				<label for="adminPasswd">Admin Password</label>
			</div>
			<button type="button" id="loginBtn">Sign in</button>
		</form>
		</c:if>
		
		<c:if test="${not empty adminLogin }">
			<h3>${adminLogin.adminId}님 환영합니다</h3>
			<button type="button" id="logoutBtn">Log out</button>
		</c:if>
	</main>
	<script src="/resources/include/js/jquery-3.7.1.min.js"></script>
	<script src="/resources/include/js/common.js"></script>
	<script src="/resources/include/js/adminLogin.js"></script>
	<script>
		$(function(){
			let errorMsg = "${errorMsg}";
			if(errorMsg != "") {
				alert(errorMsg);
				errorMsg="";
			}
		});
	</script>
	
</body>
</html>