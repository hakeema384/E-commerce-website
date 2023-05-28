package com.codewithme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.codewithme.dao.DbConnector;
import com.codewithme.dao.DbConnectorImplMySql;

import com.codewithme.model.Login;
import com.codewithme.model.Registration;

public class LoginDao {
	
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	public static String validateUser(Login login) throws ClassNotFoundException, SQLException {	
		Connection connection = connector.getConnection();
		String query = "Select * from register where username =? and password=?";
        PreparedStatement ps = connection.prepareStatement(query);
       ps.setString(1, login.getUsername());
       ps.setString(2, login.getPassword());
       String message = "";
		//Execute query
        ResultSet rs = ps.executeQuery();
        
		if(rs.next()) {
			String usernameDB = rs.getString("username");
			String passwordDB = rs.getString("password");
			String roleDB = rs.getString("user_role");
			
			if(login.getUsername().equals(usernameDB) && login.getPassword().equals(passwordDB) && roleDB.equals("admin")) {
	            message = "admin_Role";
	            }
	        else if(login.getUsername().equals(usernameDB) && login.getPassword().equals(passwordDB) && roleDB.equals("sales_agent")) {
	            message ="SA_Role";
	            }
	        else if(login.getUsername().equals(usernameDB) && login.getPassword().equals(passwordDB) && roleDB.equals("customer")) {
	            message ="customer_Role";
	            }	
	        else if(login.getUsername().equals(usernameDB) && login.getPassword().equals(passwordDB) && roleDB.equals("driver")) {
	        	message = "driver_Role";
	        }
		} 
		ps.close();
		connection.close();
		return message;
	}
	
	public static int getID(Login login) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "Select id from register where username=? and password=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		int id=0;
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		 id = rs.getInt("id");
		}
		return id;
		
	}
	
	public static int getBranchID(Login login) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "Select branch_id from register where username=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, login.getUsername());
		int id=0;
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		 id = rs.getInt("branch_id");
		}
		return id;
	}
}
