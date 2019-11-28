package com.dao;

import java.util.List;

import com.models.Admin;
import com.models.SuperMarket;

public interface AdminDao {
	public Boolean login(Admin admin) throws Exception;
	
}
