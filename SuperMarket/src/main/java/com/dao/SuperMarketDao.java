package com.dao;
import java.sql.ResultSet;
import java.util.List;

import com.models.SuperMarket;
public interface SuperMarketDao {
	public ResultSet viewSupermarket() throws Exception;
	public int register(SuperMarket market) throws Exception;
	public ResultSet login(SuperMarket market) throws Exception;
	
}
