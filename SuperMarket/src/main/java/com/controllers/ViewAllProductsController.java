package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDaoImpl;
import com.models.Products;


public class ViewAllProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewAllProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Products product=new Products();
		ProductDaoImpl dao=new ProductDaoImpl();
		HttpSession session=request.getSession();
		ResultSet rs=null;
		try
		{
			rs=dao.viewAllProducts();
			
				session.setAttribute("rs", rs);
				session.setAttribute("adminId", session.getAttribute("adminId").toString());
				response.sendRedirect("ViewAllProducts.jsp");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
