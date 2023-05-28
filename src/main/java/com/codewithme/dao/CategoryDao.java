package com.codewithme.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.model.Category;

public class CategoryDao {
	
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	public static List<Category> getCategories() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "select * from category";
		Statement st = connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		List<Category> categories = new ArrayList();
		while(rs.next()) {
			Category cg = new Category(rs.getInt("category_id"),rs.getString("category_name"));
			categories.add(cg);
		}
		
		st.close();
		return categories;
		
	}

}
