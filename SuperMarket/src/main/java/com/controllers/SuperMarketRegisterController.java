package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SuperMarketDaoImpl;
import com.models.SuperMarket;


public class SuperMarketRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SuperMarketRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SuperMarket market=new SuperMarket();
		String id=request.getParameter("marketId").toString();
		market.setmarketID(id);
		System.out.println(id);
		market.setPassword(request.getParameter("password"));
		market.setName(request.getParameter("name"));
		market.setMobileNo(request.getParameter("mobileNo"));
		market.setStreetLine1(request.getParameter("streetLine1"));
		market.setLocality(request.getParameter("locality"));
		market.setCity(request.getParameter("city"));
		market.setEmailId(request.getParameter("emailId"));
		SuperMarketDaoImpl dao=new SuperMarketDaoImpl();
		try
		{
		ResultSet rs=dao.test(market.getmarketID());
		if(!rs.next())
		{
			dao.register(market);
			String msg="SuccesFully Registered";
			HttpSession session=request.getSession();
			session.setAttribute("msg", msg);
			response.sendRedirect("RegisterSuperMarket.jsp");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Primary key already used");
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
	}
}

}
