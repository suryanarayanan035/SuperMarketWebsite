<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	String adminId=(String)session.getAttribute("adminId");
	if(adminId==null)
	response.sendRedirect("adminLogin.jsp");
	session.setAttribute("adminId", adminId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>
</head>
<body>
<table border="1">
<tr>
<td>CustomerID</td>
<td>Password</td>
<td>Customer Name</td>
<td>Mobile No</td>
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