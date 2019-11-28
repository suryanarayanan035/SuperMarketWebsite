<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>

<%
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("customerId").toString().equals(null))
	{
		response.sendRedirect("CustomerLogin.jsp");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>Sl. No</td>
<td>OrderID</td>
<td>Ordered Products</td>
<td>Quantities</td>
<td>Order Value</td>
<td>MarketName</td>
<td>Order Status</td>
</tr>
<%
int i=0;
String str[];
String aqstr[];
	ResultSet rs=(ResultSet)session.getAttribute("orderResultSet");
	List<String[]> productNames=(List<String[]>)session.getAttribute("productNames");
	List<String[]> marketNames=(List<String[]>)session.getAttribute("marketNames");
	List<Integer> quantitylist=new ArrayList<Integer>();
	String qstr="";
	int j=0;
	while(rs.next())
	{
		i++;
		aqstr=rs.getString(7).split(",");
		str=productNames.get(j);
		out.print("<tr>");
		out.print("<td>"+i+"</td>");
		out.print("<td>"+rs.getInt(1)+"</td>");
		out.print("<td>");
		for(int k=0;k<str.length;k++)
		{
			if(str[k]==null)
			{
				
			}
			else
			{
				out.print(str[k]+"<br>");
			}
		}
		
		out.print("</td>");
		out.print("<td>");
		for(int k=0;k<aqstr.length;k++)
		{
			if(aqstr[k]==null)
			{
				
			}
			else
			{
				out.print(aqstr[k]+"<br>");
			}
		}
		out.print("</td>");
		out.print("<td>"+rs.getInt(4)+"</td>");
		out.print("<td>"+marketNames.get(j)+"</td>");
		out.print("<td>"+rs.getString(6)+"</td>");
		out.print("</tr>");
		j++;
	}
%>
</table>
</body>
</html>