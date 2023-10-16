<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%!
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

String url = "jdbc:mysql://localhost/nscott";
String uid = "root";
String pass = "ezen1234";
String sql = "select * from employee";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width = '800' border = '1'>
	<tr>
		<th>name</th><th>address</th><th>ssn</th>
	</tr>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, uid, pass);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	while (rs.next()) {
		out.println("<tr>");
		out.println("<td>" + rs.getString("name") + "</td>");
		out.println("<td>" + rs.getString("address") + "</td>");
		out.println("<td>" + rs.getString("ssn") + "</td>");
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