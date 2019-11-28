package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;

import com.jdbc.Template;
import com.models.Products;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProductDaoImpl implements ProductDao {

	public int registerProducts(Products product) throws Exception {
		Template template=new Template();
		InputStream image=product.getImage();
		Connection con=template.getTemplate();
		String sql="insert into products(Name,Description,Price,Image,SupermarketID) values(?,?,?,?,?)";
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1,product.getName());
		ps.setString(2, product.getDescription());
		ps.setInt(3, product.getPrice());
		ps.setBinaryStream(4,image, image.available());
		ps.setString(5, product.getMarketId());
		int i=ps.executeUpdate();
		return i;
		
	}

	public ResultSet viewProducts(String id) throws Exception {
		String sql="select * from products where SupermarketID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		return rs;
	}

	public ResultSet viewAllProducts() throws Exception {
		String sql="select * from products";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	public ResultSet viewProducts(int id) throws Exception {
		String sql="select * from products where ProductID=?";
		Template template=new Template();
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		return rs;
	}

}
