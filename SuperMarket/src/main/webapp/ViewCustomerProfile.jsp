<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("cache-controll","no-cache, no-store, must-revalidate");
	if(session.getAttribute("customerId").toString().equals(null))
	{
		response.sendRedirect("CustomerLogin.jsp");
	}
	ResultSet rs=(ResultSet)session.getAttribute("customerProfile");
	rs.next();
	out.print("Name:"+rs.getString(3)+"<br>");
	out.print("Customer ID:"+rs.getString(1)+"<br>");
	out.print("MobileNo:"+rs.getString(4)+"<br>");
	out.print("Email ID:"+rs.getString(5)+"<br>");
%>
</body>
</html>