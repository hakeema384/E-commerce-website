package com.codewithme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.dao.DbConnectorImplMySql;
import com.codewithme.dao.DbConnector;
import com.codewithme.model.Cart;
import com.codewithme.model.OrderManage;
import com.codewithme.model.Product;

public class ProductDao {
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");
	
	
	public static boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "INSERT into products(product_name,price,product_img) values(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getProductName());
		ps.setInt(2, product.getPrice());
		ps.setString(3, product.getProductImg());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
		//Establish the connection
		Connection connection = connector.getConnection();
		//Create the statement
		String query = "SELECT * from products";
		Statement st = connection.createStatement();
		
		//Execute query
		ResultSet rs = st.executeQuery(query);
		List<Product> products = new ArrayList();
		while(rs.next()) {
			Product product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("price"),rs.getString("product_img"));
			products.add(product);	
		}
		st.close();
		return products;
	}
	
	public static boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		
		String query = "UPDATE products SET product_name=?,price=?,product_img=? WHERE product_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getProductName());
		ps.setInt(2, product.getPrice());
		ps.setString(3, product.getProductImg());
		ps.setInt(4, product.getProductID());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products = new ArrayList<Cart>();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					Connection connection = connector.getConnection();
					String query = "Select * from products where product_id=?";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setInt(1, item.getProductID());
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Cart cart = new Cart();
						cart.setProductID(rs.getInt("product_id"));
						cart.setProductName(rs.getString("product_name"));
						cart.setPrice(rs.getInt("price")*item.getQuantity());
						cart.setQuantity(item.getQuantity());
						products.add(cart);
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public static int getTotalCartPrice(ArrayList<Cart> cartList) {
		int sum = 0;
		try {
			if(cartList != null) {
				for(Cart c:cartList) {
					Connection connection = connector.getConnection();
					String query = "Select price from products where product_id=?";
					PreparedStatement ps= connection.prepareStatement(query);
					ps.setInt(1, c.getProductID());
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						sum += rs.getInt("price")* c.getQuantity();
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	public static List<Product> getProductsSA() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query="Select * from products";
		Statement st= connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Product> products = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("price"),rs.getInt("brand_id"),rs.getInt("category_id"),rs.getInt("quantity"),rs.getBoolean("status"));
			products.add(product);
		}
		st.close();
		return products;
	}
	
	public static List<OrderManage> getOrderDetails() throws ClassNotFoundException, SQLException{
		int oID = 0;
		Connection connection = connector.getConnection();
		String q2 = "select max(order_id) as oID from order_manage";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(q2);
		while(rs.next()) {
			oID = rs.getInt("oID");
		}
		st.close();
		String query = "Select * order_manage where order_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,oID);
		ResultSet r = ps.executeQuery();
		List<OrderManage> deets = new ArrayList<OrderManage>();
		while(r.next()) {
			OrderManage manage = new OrderManage(rs.getInt("branch_id"),rs.getInt("price"));
			deets.add(manage);
		}
		return deets;
		
	}
	
	
	public static List<Product> viewInventory() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "Select product_id,brand_id,category_id,quantity,status from products";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Product> products = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product(rs.getInt("product_id"),rs.getInt("brand_id"),rs.getInt("category_id"),rs.getInt("quantity"),rs.getBoolean("status"));
			products.add(product);
		}
		return products;
	}
	
	public static boolean sendRequest(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "insert into requests(product_ID,productName,brandID,categoryID,sa_ID,branch_ID,date) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, product.getProductID());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getBrandID());
		ps.setInt(4, product.getCategoryID());
		ps.setInt(5, product.getSa_ID());
		ps.setInt(6, product.getBranch_ID());
		ps.setString(7, product.getDate());
		boolean result = ps.executeUpdate() >0;
		ps.close();
		connection.close();
		return result;
		
	}
	
	public static List<Product> viewRequests(int id) throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "Select * from requests where sa_ID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Product> requests = new ArrayList<Product>();
		while(rs.next()) {
			Product p = new Product(rs.getInt("product_ID"),rs.getString("productName"),rs.getInt("brandID"),rs.getInt("categoryID"),rs.getString("date"));
			requests.add(p);
		}
		return requests;
		}

}
