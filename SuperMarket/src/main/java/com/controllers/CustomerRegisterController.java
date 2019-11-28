package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDaoImpl;
import com.models.Customers;

public class CustomerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CustomerRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customers customer=new Customers();
		CustomerDaoImpl dao=new CustomerDaoImpl();
		customer.setName(request.getParameter("name").toString());
		customer.setCustomerId(request.getParameter("customerId").toString());
		customer.setPassword(request.getParameter("password").toString());
		customer.setMobileNo(request.getParameter("mobileNo").toString());
		customer.setEmailId(request.getParameter("emailId").toString());
		HttpSession session=request.getSession();
		try
		{
			int i=dao.registration(customer);
			if(i!=0)
			{
				session.setAttribute("customerId", request.getParameter("customerId").toString());
				response.sendRedirect("CustomerDashboard.jsp");
			}
			else
			{
				response.sendRedirect("CustomerRegistration.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
