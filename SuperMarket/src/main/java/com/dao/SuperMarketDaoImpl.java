package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.Template;
import com.models.SuperMarket;
import com.models.SuperMarket;
import com.mysql.jdbc.PreparedStatement;

public class SuperMarketDaoImpl implements SuperMarketDao {

	public ResultSet viewSupermarket() throws Exception {
		Template template=new Template();
		String sql="select * from supermarket";
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	
	public ResultSet test(String marketID) throws Exception
	{
		String sql="select * from supermarket where SupermarketID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, marketID);
		ResultSet rs=ps.executeQuery();
		return rs;
	}

	public int register(SuperMarket market) throws Exception {
		String sql="insert into supermarket values(?,?,?,?,?,?,?,?)";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, market.getmarketID());
		ps.setString(2, market.getPassword());
		ps.setString(3, market.getName());
		ps.setString(4, market.getMobileNo());
		ps.setString(5, market.getStreetLine1());
		ps.setString(6, market.getLocality());
		ps.setString(7, market.getCity());
		ps.setString(8, market.getEmailId());
		
		int i=ps.executeUpdate();
		return i;
	}

	public ResultSet login(SuperMarket market) throws Exception {
		Template template=new Template();
		String sql="select * from supermarket where SupermarketID='"+market.getmarketID()+"' AND Password='"+market.getPassword()+"'";
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
		return rs;
	}
	
	
	
}
