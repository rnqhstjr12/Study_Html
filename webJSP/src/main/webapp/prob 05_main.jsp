<%@page import="java.net.URLDecoder"%>
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
Cookie []ck = request.getCookies();
String str= null;
if(ck != null){
	for(Cookie c : ck)
		{
			str = URLDecoder.decode(c.getValue(),"UTF-8");
		}
	out.print(str);	
%>
	님 안녕하세요<br>
	저희 홈페이지에 방문해 주셔서 감사합니다.<br>
	즐거운 시간 되세요....<br>
	<form method="post" action="prob 05_logout.jsp">
		<input type="submit" value="로그아웃">
	</form>
<%} else { %>
	<h2>로그인에 실패했습니다.</h2>
	<p><a href="prob 05_loginForm.jsp">되돌아가기</a>
<%} %>
</body>
</html>