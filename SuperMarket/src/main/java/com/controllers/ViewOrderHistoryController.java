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

public class ViewOrderHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewOrderHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Order order=new Order();
		List<String[]> productNames=new ArrayList<String[]>();
		List<String> customerNames=new ArrayList<String>();
		OrderDaoImpl dao=new OrderDaoImpl();
		order.setMarketId(session.getAttribute("marketId").toString());
		order.setOrderStatus("ted");
		try
		{
			ResultSet rs=dao.viewMarketOrdersHistory(order);
			productNames=dao.getProductNamesMarketHistory(order);
			customerNames=dao.getCustomerNamesHistory(order);
			for(int i=0;i<productNames.size();i++)
			{
				System.out.print(productNames.get(i));
			}

			session.setAttribute("historyrs", rs);
			session.setAttribute("historyproductNames", productNames);
			session.setAttribute("historycustomerNames", customerNames);
			response.sendRedirect("OrderHistory.jsp");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	}


