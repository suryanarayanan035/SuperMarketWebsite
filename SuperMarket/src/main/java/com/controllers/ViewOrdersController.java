package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDaoImpl;
import com.models.Order;


public class ViewOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewOrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDaoImpl dao=new OrderDaoImpl();
		HttpSession session=request.getSession();
		List<String[]> productNames=new ArrayList<String[]>();
		List<String> marketNames=new ArrayList<String>();
		try
		{
			Order order=new Order();
			order.setCustomerId(session.getAttribute("customerId").toString());
			ResultSet orderResultSet=dao.viewOrders(order);
			productNames=dao.getProductNames(order);
			marketNames=dao.getMarketNames(order);
			session.setAttribute("orderResultSet", orderResultSet);
			session.setAttribute("productNames", productNames);
			session.setAttribute("marketNames", marketNames);
			response.sendRedirect("ViewCustomerOrders.jsp");
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}

}
