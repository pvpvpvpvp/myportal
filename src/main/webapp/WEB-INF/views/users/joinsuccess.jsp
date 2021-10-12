<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 성공</title>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/users.css"/>
<link rel="stylesheet" 
	href="<c:url value="/css/main.css"/>" />
</head>
<body>
	<div id="container">
		<%-- import header.jsp here --%>
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<%-- import navigation.jsp" --%>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<div id="wrapper">
			<div id="content">
				<!-- Contents 영역 -->
				<h1>회원 가입 성공</h1>
	<p class="jr-success">
		회원가입을 축하합니다.
	</p>
	<p>
		<a href="<c:url value="/users/login" />">로그인하기</a>
	</p>
			</div>
		</div>
		<%-- import footer.jsp --%>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>
