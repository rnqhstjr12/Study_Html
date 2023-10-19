<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test = "${empty loginUser}">
	<jsp:forward page='login.do'/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src = "script/member.js"></script>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1 align = "center">회원 전용 페이지</h1>
<div align = "center">
	<img src="images/yuna.jpg" width="30%" height="30%">
</div>
</body>
</html>