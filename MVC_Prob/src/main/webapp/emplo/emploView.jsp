<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 보기</title>
<link rel = "stylesheet" type = "text/css" href = "css/emplo.css">
<script type = "text/javascript" src = "script/emplo.js"></script>
</head>
<body>
<div id = "wrap" align = "center">
<h1>정보 보기</h1>
<form method = "post" name = "frm" action = "EmploServlet">
<input type="hidden" name="command" value="emplo_write"> 
	<table>
		<tr>
			<th>아이디</th><td>${emplo.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${emplo.pw}</td>
		</tr>
		<tr>
			<th>이름</th><td>${emplo.name}</td>
		</tr>
		<tr>
			<th>권한</th>
			<td>
			<c:choose>
				<c:when test='${emplo.lv == "A"}'>운영자</c:when>
				<c:otherwise>일반사원</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
			<c:choose>
				<c:when test='${emplo.gender == "1"}'>남자</c:when>
				<c:otherwise>여자</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>전화번호</th><td>${emplo.phone}</td>
		</tr>
		<tr>
			<th>가입일</th><td><fmt:formatDate value = "${emplo.enter}"/></td>
		</tr>
	</table>
	<br><br>
	<input type = "button" value = "수정" onclick = "location.href='EmploServlet?command=emplo_update_form&id=${emplo.id}'">
	<input type = "button" value = "삭제" onclick = "location.href='EmploServlet?command=emplo_delete&id=${emplo.id}'">
	<input type = "button" value = "목록" onclick = "location.href='EmploServlet?command=emplo_list'">
	<input type = "button" value = "등록" onclick = "location.href='EmploServlet?command=emplo_write_form'">
</form>
</div>
</body>
</html>