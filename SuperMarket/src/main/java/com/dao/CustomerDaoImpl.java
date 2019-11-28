package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.jdbc.Template;
import com.models.Customers;
import com.mysql.jdbc.PreparedStatement;

public class CustomerDaoImpl implements CustomerDao {

	public int registration(Customers customer) throws Exception {
		String sql="insert into customer values(?,?,?,?,?)";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, customer.getCustomerId());
		ps.setString(2, customer.getPassword());
		ps.setString(3, customer.getName());
		ps.setString(4, customer.getMobileNo());
		ps.setString(5, customer.getEmailId());
		int i=ps.executeUpdate();
		return i;
	}

	public ResultSet login(Customers customer) throws Exception {
		Template template=new Template();
		String sql="select * from customer where customerID='"+customer.getCustomerId()+"' AND Password='"+customer.getPassword()+"'";
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
		return rs;
	}

	public ResultSet viewCustomers() throws Exception {
		Template template=new Template();
		String sql="select * from customer";
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	}

	public ResultSet viewProfile(String customerId) throws Exception {
		Template template=new Template();
		String sql="select * from customer where CustomerID=?";
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, customerId);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	public int forward(Customers customer) throws Exception
	{
		ResultSet rs=viewProfile(customer.getCustomerId());
		if(rs==null)
		{
			return 0;
		}
		else
		{
			Template template=new Template();
			String sql="update customer set Password=? where CustomerID=?";
			Connection con=template.getTemplate();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, customer.getPassword());
			ps.setString(2, customer.getCustomerId());
			int i=ps.executeUpdate();
			return i;
	}

}
}
