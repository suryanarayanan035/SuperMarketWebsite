package com.dao;

import java.sql.ResultSet;

import com.models.Customers;

public interface CustomerDao {
	public int registration(Customers customer) throws Exception;
	public ResultSet login(Customers customer) throws Exception;
	public ResultSet viewCustomers() throws Exception;
	
}
