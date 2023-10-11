<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="item" class="com.mission.javabeans.ItemBean"/>
<jsp:setProperty name="item" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>상품명</td>
		<td><jsp:getProperty name="item" property="name"/></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><jsp:getProperty name="item" property="price"/></td>
	</tr>
	<tr>
		<td>설명</td>
		<td><jsp:getProperty name="item" property="des"/></td>
	</tr>
</table>
</body>
</html>