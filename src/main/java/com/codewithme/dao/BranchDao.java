package com.codewithme.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.model.Branch;


public class BranchDao {
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	public static List<Branch> viewBranches() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "Select * from branches";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Branch> branch = new ArrayList();
		while(rs.next()) {
			Branch br = new Branch(rs.getInt("branch_id"),rs.getString("branch_name"),rs.getInt("tot_sales"));
			branch.add(br);
		}
		st.close();
		return branch;
		
	}
}

