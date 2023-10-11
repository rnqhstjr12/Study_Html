<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 글쓰기</h1>
<form method="post" action="prob 06_1_boardWrite.jsp">
<table border="1">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="name" size="12"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd" size="12"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" size="12"></td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td><input type="text" name="title" size="12"></td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td><textarea name="content" cols="80" rows="20"></textarea></td>
	</tr>
	<tr>
		<td><input type="submit" value="등록"></td>
		<td><input type="reset" value="다시 작성"></td>
	</tr>
</table>
</form>
</body>
</html>