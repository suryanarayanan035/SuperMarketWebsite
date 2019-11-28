package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDaoImpl;
import com.models.Customers;

public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Customers customer=new Customers();
			CustomerDaoImpl dao=new CustomerDaoImpl();
			customer.setCustomerId(request.getParameter("customerId"));
			customer.setPassword(request.getParameter("password"));
			try {
				int i=dao.forward(customer);
				if(i==0)
				{
					response.getWriter().print("Id does not exist register or try again");
				}
				else
				{
					response.sendRedirect("CustomerLogin.jsp");
				}
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
