package com.codewithme.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.model.Brand;


public class BrandDao {

	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	public static List<Brand> getAllBrands() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "Select * from brand";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Brand> brands = new ArrayList();
		while(rs.next()) {
			Brand br = new Brand(rs.getInt("brand_id"),rs.getString("brand_name"));
			brands.add(br);
		}
		st.close();
		return brands;
		
	}
}
