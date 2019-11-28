package com.dao;

import java.sql.ResultSet;
import java.util.List;

import com.jdbc.Template;
import com.models.Admin;
import com.models.SuperMarket;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AdminDaoImpl implements AdminDao{
	Template template=new Template();	

	public Boolean login(Admin admin) throws Exception {
			
		String sql="select * from admin where AdminID='"+admin.getAdminId()+"'"+"AND Password='"+admin.getPassword()+"'";
		Connection con=template.getTemplate();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
		return rs.next();
		
	}

		

}
