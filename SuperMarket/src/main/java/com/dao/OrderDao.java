package com.dao;

import java.sql.ResultSet;
import java.util.List;

import com.models.Order;

public interface OrderDao {
	
	public int createOrder(Order order) throws Exception;
	public ResultSet viewOrders(Order order) throws Exception;
	public List<String[]> getProductNames(Order order) throws Exception;
	public List<String> getMarketNames(Order order) throws Exception;
	public int acceptOrder(Order order) throws Exception;
}
