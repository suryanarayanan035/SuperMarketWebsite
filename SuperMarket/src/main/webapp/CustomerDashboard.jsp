<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
    	String customerId=(String)session.getAttribute("customerId");
    	if(customerId==null)
    	{
    		response.sendRedirect("CustomerLogin.jsp");
    	}
    	session.setAttribute("customerId",customerId);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerDshboard</title>
</head>
<body>
<%
	out.print("Welcome"+session.getAttribute("customerId"));
%>
<br><a href="searchMarkets">Search Products</a>
<br><a href="viewOrders">viewOrders</a>
<br><a href="CustomerLogout.jsp">Customer Logout</a>
<br><a href="viewCustomerProfile">View Profile</a>
</body>
</html>