<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type= "text/javascript" src = "script/member.js"></script>
<style type="text/css">
 td{
 	border: 1px solid;black;
 	width: 200px;
 	text-align: center;
 }
</style>
</head>
<body>
<jsp:include page="/header.jsp"/>
<form action = "login.do" method = "post" name = "frm">
	<table align = "center">
		<tr>
			<td colspan = "2">로그인</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type = "text" name = "id" size = "10"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "pw" size = "10"></td>
		</tr>
		<tr>
			<td>레벨</td>
			<td>
				<select name = "lv">
					<option value = "A">관리자</option>
					<option value = "B" selected = "selected">일반회원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan = "2">
				<input type = "submit" value = "로그인" onclick = "return loginCheck()">
				<input type = "reset" value = "취소">
			</td>
		</tr>
	</table>
	<div style="color:red; text-align: center;"> ${message} </div>
</form>
</body>
</html>