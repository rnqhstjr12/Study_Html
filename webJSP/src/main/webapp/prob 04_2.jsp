<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public int sum(int a) {
	int n = 0;
	for (int i = 1; i <= a; i++) {
		n += i;
	}
	return n;
}
%>
<h1>1 부터 10 까지 자연수 합 구하기</h1>
<%
int n = Integer.parseInt(request.getParameter("n"));
for(int i = 0; i < n; i++) {
	out.print((i + 1) + "+");
}
out.print(n + " = " + sum(n));
%>
</body>
</html>