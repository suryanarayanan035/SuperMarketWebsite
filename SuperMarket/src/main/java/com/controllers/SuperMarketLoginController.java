package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SuperMarketDaoImpl;
import com.models.SuperMarket;


public class SuperMarketLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SuperMarketLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SuperMarket market=new SuperMarket();
		SuperMarketDaoImpl dao=new SuperMarketDaoImpl();
		market.setmarketID(request.getParameter("marketId"));
		market.setPassword(request.getParameter("password"));
		try 
		{
			ResultSet rs=dao.login(market);
			if(rs.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("marketId", market.getmarketID());
				response.sendRedirect("MarketDashboard.jsp");
			}
			else
			{
				String msg="Error Retry Again";
				request.setAttribute("msg", msg);
				response.sendRedirect("SuperMarketLogin.jsp");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
