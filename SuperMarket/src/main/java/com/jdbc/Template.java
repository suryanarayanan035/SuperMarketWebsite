package com.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Template {
	
	String username="root";
	String password="";
	String url="jdbc:mysql://localhost:3306/supermarket";
	
	public Connection getTemplate() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection(url,username,password);
		return con;
	}

}
