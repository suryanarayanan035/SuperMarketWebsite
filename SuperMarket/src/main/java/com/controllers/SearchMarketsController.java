package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SuperMarketDaoImpl;

/**
 * Servlet implementation class SearchMarketsController
 */
public class SearchMarketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SearchMarketsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SuperMarketDaoImpl dao=new SuperMarketDaoImpl();
		HttpSession session=request.getSession();
		try
		{
		ResultSet rs=dao.viewSupermarket();
		session.setAttribute("msg", "no execution");
		session.setAttribute("rs", rs);
		response.sendRedirect("SearchProducts.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
