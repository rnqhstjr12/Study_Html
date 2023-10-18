<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "com.magic.dao.EmployeesDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
EmployeesDAO edao = EmployeesDAO.getInst();
Connection conn = edao.getConnection();
out.println("연동용");
%>
</body>
</html>