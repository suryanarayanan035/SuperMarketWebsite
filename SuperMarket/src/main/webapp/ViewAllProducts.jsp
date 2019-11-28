<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*,java.io.*,java.util.Base64" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	String adminId=(String)session.getAttribute("adminId");
	if(adminId==null)
	{
		response.sendRedirect("AdminLogin.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr>
<td>ProductID</td>
<td>Name</td>
<td>Description</td>
<td>Image</td>
<td>Price</td>
<td>MarketID</td>
</tr>
<%
try
{
	ResultSet rs=(ResultSet)session.getAttribute("rs");
	while(rs.next())
	{
		Blob blob=rs.getBlob(5);
		byte image[]=blob.getBytes(1, (int)blob.length());
		String encode = Base64.getEncoder().encodeToString(image);
		out.print("<tr>");
		out.print("<td>"+rs.getInt(1)+"</td>");
		out.print("<td>"+rs.getString(2)+"</td>");
		out.print("<td>"+rs.getString(3)+"</td>");
		out.print("<td>"+rs.getInt(4)+"</td>");
		out.print("<td>");%>
		<img src="ImageServlet?id=<%=rs.getInt(1) %>" />
		<%
		out.print("</td>");
		out.print("<td>"+rs.getString(6)+"</td>");
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