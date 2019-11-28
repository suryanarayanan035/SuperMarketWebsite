package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDaoImpl;
import com.dao.SuperMarketDaoImpl;

public class ViewUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewUsersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDaoImpl dao = new CustomerDaoImpl();
		try {
			ResultSet rs=dao.viewCustomers();
			HttpSession session=request.getSession();
			session.setAttribute("rs", rs);
			response.sendRedirect("ViewUsers.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
