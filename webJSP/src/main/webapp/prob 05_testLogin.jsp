<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id="pinksung";
	String pwd="1234";
	String name="성윤정";

	if(id.equals(request.getParameter("id"))&&
		pwd.equals(request.getParameter("pwd"))){
		
	Cookie c = new Cookie("username",URLEncoder.encode(name,"UTF-8"));
	c.setMaxAge(365*24*60*60);
	response.addCookie(c);
%>
	<h2>성공적으로 로그인하셨습니다.</h2>
	<p><a href="prob 05_main.jsp">들어가기</a>
<%}else{ %>
	<h2>로그인에 실패했습니다.</h2>
	<p><a href="prob 05_loginForm.jsp">돌아가기</a>
<%} %>
</body>
</html>