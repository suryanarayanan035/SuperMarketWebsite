package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDaoImpl;
import com.models.Order;

public class ViewOrdersAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewOrdersAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<String[]> productNames=new ArrayList<String[]>();
		List<String> customerNames=new ArrayList<String>();
		String orderStatus="Waiting";
		OrderDaoImpl dao=new OrderDaoImpl();
		try
		{
			ResultSet rs=dao.viewOrdersAdmin();
			productNames=dao.getProductNamesAdmin();
			customerNames=dao.getCustomerNamesAdmin();
			for(int i=0;i<productNames.size();i++)
			{
				System.out.print(productNames.get(i));
				System.out.println(customerNames.get(i));
			}

			session.setAttribute("adminmarketOrderResultSet", rs);
			session.setAttribute("adminProductNames", productNames);
			session.setAttribute("adminCustomerNames", customerNames);
			response.sendRedirect("ViewOrdersAdmin.jsp");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
