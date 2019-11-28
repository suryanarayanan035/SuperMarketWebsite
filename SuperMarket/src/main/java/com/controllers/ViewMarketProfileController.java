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

/**
 * Servlet implementation class ViewMarketProfileController
 */
public class ViewMarketProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewMarketProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String marketId=session.getAttribute("marketId").toString();
		SuperMarketDaoImpl dao=new SuperMarketDaoImpl();
		try {
				ResultSet rs=dao.test(marketId);
				session.setAttribute("marketProfile", rs);
				response.sendRedirect("ViewMarketProfile.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
