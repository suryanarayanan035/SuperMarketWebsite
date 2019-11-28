<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.sql.*" %>
<%
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	String id=(String)session.getAttribute("adminId");
	if(id==null)
	{
		response.sendRedirect("AdminLogin.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Supermarkets</title>
</head>
<body>
<table border="1">
<tr>
<td>MarketID</td>
<td>Password</td>
<td>SuperMarket Name</td>
<td>Mobile No</td>
<td>Locality</td>
<td>Street Line 1</td>
<td>City</td>
<td>Email ID</td>
</tr>
<%
try
{
	ResultSet rs=(ResultSet)session.getAttribute("rs");
	while(rs.next())
	{
		out.print("<tr>");
		out.print("<td>"+rs.getString(1)+"</td>");
		out.print("<td>"+rs.getString(2)+"</td>");
		out.print("<td>"+rs.getString(3)+"</td>");
		out.print("<td>"+rs.getString(4)+"</td>");
		out.print("<td>"+rs.getString(5)+"</td>");
		out.print("<td>"+rs.getString(6)+"</td>");
		out.print("<td>"+rs.getString(7)+"</td>");
		out.print("<td>"+rs.getString(8)+"</td>");
		out.print("</tr>");
	}
}
catch(Exception e)
{
	out.print(e.getMessage());
}
%>
</table>
</body>
</html>