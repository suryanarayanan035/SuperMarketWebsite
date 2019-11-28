<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<%
response.setHeader("cache-control","no-cache, no-store, must-revalidate");
%>

<%
String adminId=(String)session.getAttribute("adminId");
session.setAttribute("adminId",adminId); 
%>
<a href="RegisterSuperMarket.jsp"><button>Register Shop</button></a>
<a href="ViewMarkets"><button>View Markets</button></a>
<a href="viewCustomers"><button>View Customers</button></a>
<a href="viewAllProducts"><button>viewProducts</button></a>
<a href="viewOrdersAdmin"><button>viewOrders</button></a>
<a href="Logout.jsp"><button>Logout</button></a>
</body>
</html>