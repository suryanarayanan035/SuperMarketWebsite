package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jdbc.Template;
import com.models.Order;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class OrderDaoImpl implements OrderDao {
	List<String[]> productNames=new ArrayList<String[]>();
	public String sql1;

	public int createOrder(Order order) throws Exception {
		String sql="INSERT INTO orders(ProductID,CustomerID,OrderValue,MarketID,OrderStatus,Quantity) values(?,?,?,?,?,?)";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, order.getProductId());
		ps.setString(2, order.getCustomerId());
		ps.setInt(3, order.getOrderValue());
		ps.setString(4, order.getMarketId());
		ps.setString(5, order.getOrderStatus());
		ps.setString(6, order.getQuantity());
		int i=ps.executeUpdate();
		return i;
	}
	
	public ResultSet viewOrders(Order order) throws Exception {
		String sql="Select * from orders where CustomerID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1,order.getCustomerId());
		ResultSet rs=ps.executeQuery();
		return rs;
}
	public List<String[]> getProductNames(Order order) throws Exception
	{
		ResultSet rs=viewOrders(order);
		String array[];
		ResultSet innerrs;
		String nameArray[]=new String[200];
		String sql="Select * from products where ProductID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		while(rs.next())
		{
					
			array=rs.getString(2).split(",");
			System.out.println(array);
			for(int i=0;i<array.length;i++)
			{
				ps.setInt(1, Integer.parseInt(array[i]));
				innerrs=ps.executeQuery();
				innerrs.next();
				nameArray[i]=innerrs.getString(2);
				System.out.println(nameArray[i]);
				
			}
			productNames.add(nameArray);
		}
		
		return productNames;
	}

	public List<String> getMarketNames(Order order) throws Exception {
		ResultSet rs=viewOrders(order);
		ResultSet innerrs;
		List<String> name=new ArrayList<String>();
		String sql="Select * from supermarket where SupermarketID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		while(rs.next())
		{
			ps.setString(1, rs.getString(5));
			innerrs=ps.executeQuery();
			innerrs.next();
			name.add(innerrs.getString(3));
		}
		return name;
	}
	public ResultSet viewMarketOrders(Order order) throws Exception {
		String sql="select * from orders where MarketID=? AND OrderStatus=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		
		ps.setString(1,order.getMarketId());
		ps.setString(2, order.getOrderStatus());
		ResultSet rs=ps.executeQuery();
		return rs;
}
	public List<String> getCustomerNames(Order order) throws Exception {
		ResultSet rs=viewMarketOrders(order);
		System.out.println(rs.getFetchSize());
		ResultSet innerrs;
		List<String> name=new ArrayList<String>();
		String sql="Select * from customer where CustomerID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		Iterator itr=name.iterator();
		while(rs.next())
		{
			ps.setString(1, rs.getString(3));
			innerrs=ps.executeQuery();
			innerrs.next();
			name.add(innerrs.getString(3));
		
		}
		return name;
	}
	public List<String[]> getProductNamesMarket(Order order) throws Exception
	{
		ResultSet rs=viewMarketOrders(order);
		String array[];
		ResultSet innerrs;
		String nameArray[]=new String[200];
		String sql="Select * from products where ProductID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		while(rs.next())
		{
					
			array=rs.getString(2).split(",");
			System.out.println(array);
			for(int i=0;i<array.length;i++)
			{
				ps.setInt(1, Integer.parseInt(array[i]));
				innerrs=ps.executeQuery();
				innerrs.next();
				nameArray[i]=innerrs.getString(2);
				System.out.println(nameArray[i]);
				
			}
			productNames.add(nameArray);
		}
		
		return productNames;
	}
	public int acceptOrder(Order order) throws Exception
	{
		String sql="update orders set OrderStatus=? where OrderID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1, order.getOrderStatus());
		ps.setInt(2, order.getOrderId());
		int i=ps.executeUpdate();
		return i;
	}
	public int rejectOrder(Order order) throws Exception
	{
		String sql="update orders set OrderStatus=? where OrderID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
		ps.setString(1, order.getOrderStatus());
		ps.setInt(2, order.getOrderId());
		int i=ps.executeUpdate();
		return i;
	}
	public ResultSet viewMarketOrdersHistory(Order order) throws Exception {
		String sql="select * from orders where MarketID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1,order.getMarketId());
		ResultSet rs=ps.executeQuery();
		return rs;
}
	public List<String[]> getProductNamesMarketHistory(Order order) throws Exception
	{
		ResultSet rs=viewMarketOrdersHistory(order);
		String array[];
		ResultSet innerrs;
		String nameArray[]=new String[200];
		String sql="Select * from products where ProductID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		while(rs.next())
		{
					
			array=rs.getString(2).split(",");
			System.out.println(array);
			for(int i=0;i<array.length;i++)
			{
				ps.setInt(1, Integer.parseInt(array[i]));
				innerrs=ps.executeQuery();
				innerrs.next();
				nameArray[i]=innerrs.getString(2);
				System.out.println(nameArray[i]);
				
			}
			productNames.add(nameArray);
		}
		
		return productNames;
	}
	public List<String> getCustomerNamesHistory(Order order) throws Exception {
		ResultSet rs=viewMarketOrdersHistory(order);
		ResultSet innerrs;
		List<String> name=new ArrayList<String>();
		String sql="Select * from customer where CustomerID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);

		while(rs.next())
		{
			ps.setString(1, rs.getString(3));
			innerrs=ps.executeQuery();
			innerrs.next();
			name.add(innerrs.getString(3));
		
		}
		return name;
	}
	public ResultSet viewOrdersAdmin() throws Exception {
		String sql="select * from orders";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
}
	public List<String> getCustomerNamesAdmin() throws Exception {
		ResultSet rs=viewOrdersAdmin();
		ResultSet innerrs;
		List<String> name=new ArrayList<String>();
		String sql="Select * from customer where CustomerID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);

		while(rs.next())
		{
			ps.setString(1, rs.getString(3));
			innerrs=ps.executeQuery();
			innerrs.next();
			name.add(innerrs.getString(3));
		
		}
		return name;
	}
	public List<String[]> getProductNamesAdmin() throws Exception
	{
		ResultSet rs=viewOrdersAdmin();
		String array[];
		ResultSet innerrs;
		String nameArray[]=new String[200];
		String sql="Select * from products where ProductID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		while(rs.next())
		{
					
			array=rs.getString(2).split(",");
			System.out.println(array);
			for(int i=0;i<array.length;i++)
			{
				ps.setInt(1, Integer.parseInt(array[i]));
				innerrs=ps.executeQuery();
				innerrs.next();
				nameArray[i]=innerrs.getString(2);
				System.out.println(nameArray[i]);
				
			}
			productNames.add(nameArray);
		}
		
		return productNames;
	}
	
}
