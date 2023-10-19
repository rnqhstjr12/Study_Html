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
<form action = "custom.do" method = "post" name = "frm">
	<table align = "center">
		<tr>
			<td colspan = "2">사원등록</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type = "text" name = "id" size = "10" value = "yuna"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "pw" size = "10" value = "1111"></td>
		</tr>
		<tr>
			<td >이름</td>
			<td><input type = "text" name = "name" size = "24" value = "김연아"></td>
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<select name = "lv">
					<option value = "A">관리자</option>
					<option value = "B" selected = "seleckted">일반회원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<select name = "sex">
					<option value = "1">남자</option>
					<option value = "2" selected = "seleckted">여자</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type = "text" name = "phone" size = "30" value = "010-7777-7777"></td>
		</tr>
		<tr>
			<td colspan = "2">
				<input type = "submit" value = "등록" onclick = "return insertCheck()">
				<input type = "reset" value = "취소">
				<input type = "button" value = "메인 페이지로 이동" onclick="location.href='../main.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>