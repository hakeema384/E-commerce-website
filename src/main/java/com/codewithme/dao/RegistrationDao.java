package com.codewithme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codewithme.dao.DbConnector;
import com.codewithme.dao.DbConnectorImplMySql;
import com.codewithme.model.Login;
import com.codewithme.model.Registration;

public class RegistrationDao {
	
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");

	public static boolean addUser(Registration reg) throws ClassNotFoundException, SQLException {
		
		Connection connection = connector.getConnection();
		
		String query = "INSERT into register(username, password,email,branch_id) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, reg.getUsername());
		ps.setString(2, reg.getPassword());
		ps.setString(3, reg.getEmail());
		ps.setInt(4,reg.getBranchID());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
		
		
	}
	
	
}
