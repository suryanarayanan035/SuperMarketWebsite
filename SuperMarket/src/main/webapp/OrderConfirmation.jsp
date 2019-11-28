<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%
    response.setHeader("cache-control","no-cache, no-store, must-revalidate");
    	if(session.getAttribute("customerId").toString().equals(""))
    	{
    		response.sendRedirect("CustomerLogin.jsp");
    	}
    	String customerId=session.getAttribute("customerId").toString();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Confirm Your Order</h2>
<table border="1">
<tr>
<td>SerialNo</td>
<td>Product Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Amount</td>
</tr>
<%
String mId="";
String str="";
int finaltotal=0;
try{
List<String> marketId=new ArrayList<String>();
List<String> name=new ArrayList<String>();
List<Integer> price=new ArrayList<Integer>();
List<Integer> quantitylist=new ArrayList<Integer>();
marketId=(ArrayList<String>)session.getAttribute("listMarketId");
name=(ArrayList<String>)session.getAttribute("namelist");
price=(ArrayList<Integer>)session.getAttribute("pricelist");
quantitylist=(ArrayList<Integer>)session.getAttribute("quantitylist");
System.out.println(name.get(1));
int i=1;
int total=0;
int quantity,priceValue;
Iterator<String> itr=marketId.iterator();
Iterator<String> nameItr=name.iterator();
Iterator<Integer> priceItr=price.iterator();
Iterator<Integer> qlItr=quantitylist.iterator();
while(itr.hasNext())
{
	str=itr.next();
	if(str==null)
	{
	
	}
	else
	{
		mId=str;
	}
	priceValue=(Integer)priceItr.next();
	quantity=(Integer)qlItr.next();
	total=(priceValue*quantity);
	finaltotal=finaltotal+total;
	out.print("<tr>");
	out.print("<td>"+i+"</td>");
	out.print("<td>"+nameItr.next()+"</td>");
	out.print("<td>"+priceValue+"</td>");
	out.print("<td>"+(Integer)quantity+"</td>");
	out.print("<td>"+(Integer)total+"</td>");
	out.print("</tr>");
	i++;
}
}
catch(Exception e)
{
	e.printStackTrace();
}
session.setAttribute("marketId", mId);
session.setAttribute("orderValue", finaltotal);
%>
</table><br>
Bill Value is:Rs<%=finaltotal %>
<a href="createOrder"><button>Confirm My order</button></a>
</body>
</html>