package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDaoImpl;
import com.models.Order;

public class CreateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Order order=new Order();
		String productId="";
		String quantity="";
		OrderDaoImpl dao=new OrderDaoImpl();
		List<Integer> list=(List<Integer>)session.getAttribute("idList");
		List<Integer> quantitylist=(List<Integer>)session.getAttribute("quantitylist");
		Iterator itr1=quantitylist.iterator();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			productId=productId+(itr.next()+",");
			quantity=quantity+(itr1.next()+",");
		}
		LocalDate date=LocalDate.now();
		order.setCustomerId(session.getAttribute("customerId").toString());
		order.setMarketId(session.getAttribute("marketId").toString());
		order.setDate(date);
		order.setOrderValue(Integer.parseInt(session.getAttribute("orderValue").toString()));
		order.setOrderStatus("Waiting");
		order.setProductId(productId);
		order.setQuantity(quantity);
		try
		{
		 int i=dao.createOrder(order);
		 if(i==0)
		 {
			 
			 response.sendRedirect("viewCustomerOrders.jsp");
		 }
		 else
		 {
			 out.print("You have ordered the products Successfully");
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
