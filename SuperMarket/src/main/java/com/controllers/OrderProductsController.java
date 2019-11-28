package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDaoImpl;


public class OrderProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int testid;
    
    public OrderProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImpl dao=new ProductDaoImpl();
		int productId=0;
		int quantity=0;
		String ordername,orderquantity;
		int k=1;
		int x=0;
		ResultSet rs=null;
		String order,quantityl;
		List<String> marketId=new ArrayList<String>();
		List<Integer> idList=new ArrayList<Integer>();
		List<String> name=new ArrayList<String>();
		List<Integer> price=new ArrayList<Integer>();
		List<Integer> quantitylist=new ArrayList<Integer>();
		HttpSession session=request.getSession();
		int id=0;
		int i=0;
		try
		{
			try {
			 rs=dao.viewAllProducts();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			while(rs.next())
			{
				i=i+1;
				if(i==6)
				{
					break;
				}
				order=i+"order";
				quantityl=i+"quantity";
				ordername=""+request.getParameter(order).toString().replace("order", "");
				orderquantity=""+request.getParameter(quantityl).toString().replace("quantity", "");
				productId=Integer.parseInt(ordername);
				quantity=Integer.parseInt(orderquantity);
				 System.out.println("map id="+productId);
				 ResultSet prs=dao.viewProducts(productId);
				 idList.add(productId);
				 while(prs.next()) {
				 name.add(prs.getString(2));
				 price.add(prs.getInt(4));
				 marketId.add(prs.getString(6));
				 quantitylist.add(quantity);
				 System.out.println();
				 }
				 }
		
			session.setAttribute("namelist", name);
			session.setAttribute("pricelist", price);
			session.setAttribute("listMarketId", marketId);
			session.setAttribute("quantitylist", quantitylist);
			session.setAttribute("idList", idList);
			response.sendRedirect("OrderConfirmation.jsp");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


