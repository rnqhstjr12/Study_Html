<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%!
String url = "jdbc:mysql://localhost/nscott";
String uid = "root";
String pass = "ezen1234";
String sql = "select * from item";

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width = '800' border = '1'>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, uid, pass);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	while (rs.next()) {
		out.println("<tr>");
		out.println("<th>" + rs.getString("name") + "</th>");
		out.println("<th>" + rs.getString("price") + "</th>");
		out.println("<th>" + rs.getString("description") + "</th>");
		out.println("</tr>");
	}
} catch (Exception e) {
	e.printStackTrace();
} finally {
	try {
		if (rs != null) rs. close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>
</table>
</body>
</html>