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
<form action = "custom.do" method = "get">
	<table align = "center">
		<tr>
			<td colspan = "2">
				<h2>사원 정보</h2>
				<div style="color:red; text-align: center;"> ${message} </div>
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${loginUser.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${loginUser.pw}</td>
		</tr>
		<tr>
			<td >이름</td>
			<td>${loginUser.name}</td>
		</tr>
		<tr>
			<td>권한</td>
			<c:choose>
				<c:when test = '${result == 2}'>
					<td>관리자</td>
				</c:when>
				<c:otherwise>
					<td>일반회원</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>성별</td>
			<c:choose>
				<c:when test='${loginUser.sex == "1"}'>
					<td>남자</td>
				</c:when>
				<c:otherwise>
					<td>여자</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${loginUser.phone}</td>
		</tr>
		<tr>
			<td colspan = "2"><input type = "button" value = "메인 페이지로 이동" onclick="location.href='../main.jsp'"></td>
		</tr>
	</table>
</form>
</body>
</html>