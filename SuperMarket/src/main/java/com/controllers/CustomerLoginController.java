package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.models.Customers;

public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CustomerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customers customer=new Customers();
		CustomerDaoImpl dao=new CustomerDaoImpl();
		customer.setCustomerId(request.getParameter("customerId"));
		customer.setPassword(request.getParameter("password"));
		HttpSession session=request.getSession();
		try
		{
		ResultSet rs=dao.login(customer);
		if(rs.next())
		{
			session.setAttribute("customerId", request.getParameter("customerId"));
			response.sendRedirect("CustomerDashboard.jsp");
		}
		else
		{
			response.sendRedirect("CustomerLogin.jsp");
		}
		}
		catch(Exception e)
		{
			
		}
		
	}

}
