package com.codewithme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImplMySql implements DbConnector {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//2.Load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//3.Establish the connection
				String url = "jdbc:mysql://localhost:3306/mobileshop?allowPublicKeyRetrieval=true&useSSL=false";
				String userName = "root";
				String password = "Hakeema#123"; 
				return DriverManager.getConnection(url, userName, password);
	}

}
