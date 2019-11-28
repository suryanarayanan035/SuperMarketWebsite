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
response.setHeader("cache-control","no-cache, no-store, must-revalidate");
if(session.getAttribute("marketId").toString().equals(null))
{
	response.sendRedirect("SuperMarketLogin.jsp");
}
	ResultSet rs=(ResultSet)session.getAttribute("marketProfile");
	rs.next();
	out.print("MarketName:"+rs.getString(3)+"<br>");
	out.print("Market ID:"+rs.getString(1)+"<br>");
	out.print("MobileNo:"+rs.getString(4)+"<br>");
	out.print("Email ID:"+rs.getString(8)+"<br>");
	out.print("StreetLine1:"+rs.getString(5)+"<br>");
	out.print("Locality:"+rs.getString(6)+"<br>");
	out.print("City:"+rs.getString(7)+"<br>");
%>
</body>
</html>