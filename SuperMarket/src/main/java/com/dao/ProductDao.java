package com.dao;

import java.sql.ResultSet;

import com.models.Products;

public interface ProductDao {
	public int registerProducts(Products product) throws Exception;
	public ResultSet viewProducts(String id) throws Exception;
	public ResultSet viewAllProducts() throws Exception;
}
