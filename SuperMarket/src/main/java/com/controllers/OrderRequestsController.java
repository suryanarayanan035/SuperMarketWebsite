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

public class OrderRequestsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public OrderRequestsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String marketId=session.getAttribute("marketId").toString();
		List<String[]> productNames=new ArrayList<String[]>();
		List<String> customerNames=new ArrayList<String>();
		String orderStatus="Waiting";
		Order order=new Order();
		order.setMarketId(marketId);
		System.out.println(marketId);
		order.setOrderStatus(orderStatus);
		OrderDaoImpl dao=new OrderDaoImpl();
		dao.sql1="select * from orders where MarketID=? AND OrderStatus=?";
		try
		{
			ResultSet rs=dao.viewMarketOrders(order);
			productNames=dao.getProductNamesMarket(order);
			customerNames=dao.getCustomerNames(order);
			for(int i=0;i<productNames.size();i++)
			{
				System.out.print(productNames.get(i));
			}

			session.setAttribute("marketOrderResultSet", rs);
			session.setAttribute("productNames", productNames);
			session.setAttribute("customerNames", customerNames);
			response.sendRedirect("OrderRequests.jsp");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
