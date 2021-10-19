<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="/myportal/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>

<body>
	<div id="container">
		<%-- import header.jsp here --%>
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<%-- import navigation.jsp" --%>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<div id="wrapper">
			<div id="content">
			<table border="1" width="640">
				<tr>
					<td colspan="2"><h3>게시판</h3></td>
				</tr>
				<tr>
					<th colspan="2">글보기</th>
				</tr>
				<tr>
					<td>제목</td>
					<td>${content.title }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<div>
							${content.content }
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="<c:url value="/board/list"/>">글목록</a>
						<a href="<c:url value="/board/modify/${no }"/>">글수정</a>
					</td>
				</tr>
			
			</table>
			</div>
		</div>
		<%-- import footer.jsp --%>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
	
	

</body>
</html>
