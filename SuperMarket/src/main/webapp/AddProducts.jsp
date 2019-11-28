<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    response.setHeader("cache-control","no-cache, no-store, must-revalidate");
    String marketId=(String)session.getAttribute("marketId");
    	if(marketId==null)
    	{
    		response.sendRedirect("SuperMarketLogin.jsp");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("marketID", marketId);
%>
<form action="registerProduct" enctype="multipart/form-data" name="form" method="post">
<label>Product Name</label><br>
<input type="text" name="name" /><br>
<label>Description:</label>(*Do mention the Quantity also)<br>
<textarea name="description"></textarea><br>
<label>Image</label><br>
<input type="file" name="image" /><br>
<label>Price</label><br>
<input type="text" name="price" /><br>
<input type="submit" value="Login">
</form>
</body>
</html>