package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDaoImpl;


public class ViewCustomerProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewCustomerProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String customerId=session.getAttribute("customerId").toString();
		CustomerDaoImpl dao=new CustomerDaoImpl();
		try {
				ResultSet rs=dao.viewProfile(customerId);
				session.setAttribute("customerProfile", rs);
				response.sendRedirect("ViewCustomerProfile.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
