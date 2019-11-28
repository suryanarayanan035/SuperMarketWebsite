package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDaoImpl;
import com.models.Order;

public class AcceptOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AcceptOrderController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Order order=new Order();
		OrderDaoImpl dao=new OrderDaoImpl();
		order.setOrderId(Integer.parseInt(request.getParameter("orderId").toString()));
		order.setOrderStatus("Accepted");
		try
		{
			int i=dao.acceptOrder(order);
			if(i==0)
			{
				response.getWriter().print("Sorry retry again");
			}
			else
			{
				response.sendRedirect("orderRequests");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
