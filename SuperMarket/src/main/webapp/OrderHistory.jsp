<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("marketId").toString().equals(null))
	{
		response.sendRedirect("SuperMarketLogin.jsp");
	}
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>Sl. No</td>
<td>Order ID</td>
<td>Ordered Products</td>
<td>Order Quantity</td>
<td>Order Value</td>
<td>CustomerName</td>
<td>Action</td>
</tr>
<%
int i=0;
String str[];
String aqstr[];
	ResultSet rs=(ResultSet)session.getAttribute("historyrs");
	List<String[]> productNames=(List<String[]>)session.getAttribute("historyproductNames");
	List<String> customerNames=(List<String>)session.getAttribute("historycustomerNames");
	List<Integer> quantitylist=new ArrayList<Integer>();
	String qstr="";
	int j=0;
	while(rs.next())
	{
		i++;
		aqstr=rs.getString(7).split(",");
		System.out.println(aqstr);
		str=productNames.get(j);
		System.out.println(str);
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
				System.out.println(str[k]);
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
		out.print("<td>"+customerNames.get(j)+"</td>");
		out.print("<td>"+rs.getString(6)+"</td>");
		

		out.print("</tr>");
		j++;
	}
%>
</table>
</body>
</html>