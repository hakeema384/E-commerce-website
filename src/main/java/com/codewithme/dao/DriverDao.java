package com.codewithme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.model.OrderLogs;
import com.codewithme.model.Product;

public class DriverDao {
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	public static boolean updateDelivered(OrderLogs logs) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "UPDATE order_logs SET delivered=true where order_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, 0);
		return false;
		
	}
	
	public static List<OrderLogs> getOrderLogs(String name) throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "SELECT * from order_logs where driver_name=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		List<OrderLogs> log = new ArrayList<OrderLogs>();
		while(rs.next()) {
			OrderLogs logs = new OrderLogs(rs.getInt("id"),rs.getInt("order_id"),rs.getInt("sls_id"),rs.getString("driver_name"),rs.getBoolean("delivered"));
			log.add(logs);
		}
		
		return log;
		
	}

}
