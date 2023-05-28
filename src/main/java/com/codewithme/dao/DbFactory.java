package com.codewithme.dao;

public class DbFactory {

	public DbConnector getDb(String type) {
		if(type=="MySql") {
			return new DbConnectorImplMySql();
		}
		else
		{
			return null;
		}
		
	}
}
