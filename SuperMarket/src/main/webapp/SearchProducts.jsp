<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.sql.*,java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form action="searchProducts" method="post" id="search">
<select name="marketId">
<%
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("customerId").toString().equals(""))
	{
		response.sendRedirect("CustomerLogin.jsp");
	}
	session.setAttribute("customerId",session.getAttribute("customerId").toString());
	ResultSet rs=(ResultSet)session.getAttribute("rs");
	while(rs.next())
	{
		
		out.print("<option value='"+rs.getString(1)+"'>"+rs.getString(3)+"</option>");
	}
%>
</select>
<input type="submit" value="search" />
</form>
<form action="orderProducts" id="order">
</form>
<table border="1" id="products">
<tr>
<td>Product</td>
<td>Options</td>
</tr>
<%
try
{
	String msg=(String)session.getAttribute("msg");
	if(msg.equals("no execution"))
	{
	}
	else
	{
	ResultSet searchRS=(ResultSet)session.getAttribute("searchRS");
	int i=0;
	while(searchRS.next())
	{
		i++;
		Blob blob=searchRS.getBlob(5);
		byte byteArray[]=blob.getBytes(1, (int)blob.length());
		String image = Base64.getEncoder().encodeToString(byteArray);
		out.print("<td height='300' width='200'>");
		out.print("Name:"+searchRS.getString(2)+"<br>");
		%><img src="ImageServlet?id=<%=searchRS.getInt(1) %>" /><%
		out.print("Description:"+searchRS.getString(3)+"<br>");
		out.print("Price:"+searchRS.getInt(4));
		out.print("</td>");
		out.print("<td height='300' width='200'>");
		%>
		Quantity:<br><input type="text"   name="<%=i+"quantity" %>"  value ="0"form="order" required/>
		<input type="hidden" value="<%=searchRS.getInt(1) %>" value="0" name="<%=i+"order" %>" form="order"  required/>
<%
		out.print("</td>");
		out.print("</tr>");
		
	}
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</table>
<input type="submit" value="orders" form="order">
</body>
</html>