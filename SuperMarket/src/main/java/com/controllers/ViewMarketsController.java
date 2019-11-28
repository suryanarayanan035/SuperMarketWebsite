package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SuperMarketDaoImpl;
import com.models.SuperMarket;

public class ViewMarketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public ViewMarketsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SuperMarketDaoImpl dao = new SuperMarketDaoImpl();
		try {
			ResultSet rs=dao.viewSupermarket();
			HttpSession session=request.getSession();
			session.setAttribute("rs", rs);
			response.sendRedirect("ViewSupermarkets.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
