package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDaoImpl;
import com.models.Products;

public class ViewProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Products product=new Products();
		ProductDaoImpl dao=new ProductDaoImpl();
		HttpSession session=request.getSession();
		product.setMarketId(session.getAttribute("marketId").toString());
		System.out.println(session.getAttribute("marketId").toString());
		ResultSet rs;
		try
		{
			rs=dao.viewProducts(product.getMarketId());
			
				session.setAttribute("rs", rs);
				session.setAttribute("marketId", session.getAttribute("marketId").toString());
				response.sendRedirect("ViewProducts.jsp");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	}


