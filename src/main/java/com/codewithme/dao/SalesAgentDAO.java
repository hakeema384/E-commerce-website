package com.codewithme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.dao.DbConnector;
import com.codewithme.dao.DbConnectorImplMySql;
import com.codewithme.model.SalesAgent;

public class SalesAgentDAO {
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	public static List<SalesAgent> getAllSA() throws ClassNotFoundException, SQLException{	
		Connection connection = connector.getConnection();
		String query = "SELECT * from s_agent";
		Statement st = connection.createStatement();
		
		//Execute query
		ResultSet rs = st.executeQuery(query);
		List<SalesAgent> sa = new ArrayList();
		while(rs.next()) {
			SalesAgent agent = new SalesAgent(rs.getInt("SA_id"),rs.getInt("branch_id"),rs.getString("username"),rs.getString("password"),rs.getString("SA_name"),rs.getString("SA_email"),rs.getInt("sales"));
			sa.add(agent);	
		}
		st.close();
		return sa;
		}
	
	public static boolean addSA(SalesAgent ag) throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "INSERT into s_agent(SA_id,branch_id,username, password,SA_name,SA_email) values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, ag.getSA_id());
		ps.setInt(2, ag.getBranch_id());
		ps.setString(3,ag.getUsername());
		ps.setString(4, ag.getPassword());
		ps.setString(5, ag.getSA_name());
		ps.setString(6, ag.getSA_email());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;	
	}
	
	public static boolean updateSA(SalesAgent ag) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "UPDATE s_agent SET branch_id=?,username=?,password=?,SA_name=?,SA_email=? WHERE SA_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, ag.getBranch_id());
		ps.setString(2, ag.getUsername());
		ps.setString(3, ag.getPassword());
		ps.setString(4, ag.getSA_name());
		ps.setString(5, ag.getSA_email());
		ps.setInt(6, ag.getSA_id());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;	
	}
	
	public static boolean deleteSA(int SA_id) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "DELETE from s_agent WHERE SA_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, SA_id);
		 boolean result = ps.executeUpdate() > 0;
		 ps.close();
		 connection.close();
		 return result;	
	}
	

	
}
