<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    response.setHeader("cache-control","no-cache, no-store, must-revalidate");
		String marketId=(String)session.getAttribute("marketId");
    	if(marketId==null)
    	{
    		response.sendRedirect("SuperMarketLogin.jsp");
    	}
    	session.setAttribute("marketId", marketId);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="AddProducts.jsp">Add Products</a>
<a href="MarketLogout.jsp"><button>Logout</button></a>
<a href="viewMarketProfile"><button>View Profile</button></a>
<a href="viewProducts" >View Products</a>
<a href="orderRequests" >View OrderRequests</a>
<a href="viewOrderHistory" >View OrdersHistory</a>
</body>
</html>