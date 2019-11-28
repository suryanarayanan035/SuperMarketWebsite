package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDaoImpl;
import com.dao.SuperMarketDaoImpl;
import com.models.Products;


public class SearchProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SearchProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImpl dao=new ProductDaoImpl();
		Products product=new Products();
		SuperMarketDaoImpl marketdao=new SuperMarketDaoImpl();
		product.setMarketId(request.getParameter("marketId"));
		System.out.println(request.getParameter("marketId"));
		ResultSet searchRS,rs;
		HttpSession session=request.getSession();
		try
		{
			rs=marketdao.viewSupermarket();
			searchRS=dao.viewProducts(product.getMarketId());
			session.setAttribute("msg", "execute");
			session.setAttribute("searchRS", searchRS);
			session.setAttribute("rs", rs);
			response.sendRedirect("SearchProducts.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
