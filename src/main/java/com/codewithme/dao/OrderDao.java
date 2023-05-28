package com.codewithme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.codewithme.model.Order;
import com.codewithme.model.OrderLogs;
import com.codewithme.model.OrderManage;
import com.codewithme.model.Product;


public class OrderDao {
	static DbFactory factory = new DbFactory();
	static DbConnector connector = factory.getDb("MySql");

	public static boolean insertOrder(Order order) throws SQLException, ClassNotFoundException {
  
		boolean result = false;
		int oID = 0;
		Connection connection = connector.getConnection();
		String q = "insert into order_manage(u_id,price,branch_id) values(?,?,?)";
		PreparedStatement p = connection.prepareStatement(q);
		p.setInt(1, order.getUid());
		p.setInt(2, order.getPrice());
		p.setInt(3, order.getBranchID());
		result=p.executeUpdate()>0;
		String q2 = "select max(order_id) as oID from order_manage";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(q2);
		while(rs.next()) {
			oID = rs.getInt("oID");
		}
		st.close();
		
		String query = "insert into orders (order_id, p_id,u_id,order_quantity,o_date) values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, oID);
		ps.setInt(2, order.getProductID());
		ps.setInt(3, order.getUid());
		ps.setInt(4, order.getQuantity());
		ps.setString(5, order.getDate());
		result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean insertMultiple(ArrayList<Order> checkout, int userID, int price, int brID) throws SQLException, ClassNotFoundException{
		boolean result = false;
		int uID = userID;
		int oID = 0;
		Connection connection = connector.getConnection();
		String q = "insert into order_manage(u_id,price,branch_id) values (?,?,?)";
		PreparedStatement p = connection.prepareStatement(q);
		p.setInt(1, uID);
		p.setInt(2, price);
		p.setInt(3, brID);
		result = p.executeUpdate()>0;
		String q2 = "select max(order_id) as oID from order_manage";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(q2);
		while(rs.next()) {
			oID = rs.getInt("oID");
		}
		st.close();
		
		for(Order o:checkout) {
			String query = "insert into orders(order_id,p_id,u_id,order_quantity,o_date) values(?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, oID);
			ps.setInt(2, o.getProductID());
			ps.setInt(3, o.getUid());
			ps.setInt(4, o.getQuantity());
			ps.setString(5, o.getDate());
			result = ps.executeUpdate() > 0;
			ps.close();
		}
		
		connection.close();
		return result;
		
		
	}
	
	public static boolean addOrder(OrderManage order, int oID) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "update order_manage SET name =?, address=?, d_location=? where order_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, order.getName());
		ps.setString(2, order.getAddress());
		ps.setString(3, order.getD_location());
		ps.setInt(4, oID);
		boolean result = ps.executeUpdate()>0;
		ps.close();
		connection.close();
		return result;
		
	}
	
	public static List<OrderManage> viewAllOrders(int id) throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "select * from order_manage where branch_id=?";
        PreparedStatement ps=connection.prepareStatement(query);
		ps.setInt(1, id);
		//Execute query
		ResultSet rs = ps.executeQuery();
		List<OrderManage> od = new ArrayList();
		while(rs.next()) {
			OrderManage manage = new OrderManage(rs.getInt("order_id"),rs.getInt("u_id"),rs.getString("name"),rs.getString("address"),rs.getInt("branch_id"),rs.getString("d_location"),rs.getInt("price"),rs.getString("status"),rs.getString("driver_name"),rs.getString("vehicle"));
			od.add(manage);
		}
		return od;
		
	}
	
	public static boolean updateOrder(OrderManage og,int branchID, int slsID) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "update order_manage SET status=?,driver_name=?,vehicle=? where order_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, og.getStatus());
		ps.setString(2, og.getDriver());
		ps.setString(3, og.getVehicle());
		ps.setInt(4, og.getOrderID());
		boolean result = ps.executeUpdate() >0;
		ps.close();
		
		String q = "update order_logs SET sls_id=?,branch_id=?,driver_name=? where order_id=?";
		PreparedStatement p = connection.prepareStatement(q);
		p.setInt(1, slsID);
		p.setInt(2, branchID);
		p.setString(3, og.getDriver());
		p.setInt(4, og.getOrderID());
		result = p.executeUpdate() > 0;
		connection.close();
		return result;
	}
	
	public static boolean updateDelivered(int orderID) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "update order_logs SET delivered=true where order_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, orderID);
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		return result;
	}
	
	public static List<OrderManage> viewOrdersAdmin() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "select a.order_id,u_id,name,a.branch_id,d_location,price,status,a.driver_name,sls_id from order_manage a inner join order_logs b ON a.order_id = b.order_id";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<OrderManage> orders = new ArrayList<OrderManage>();
		while(rs.next()) {
			OrderManage order = new OrderManage(rs.getInt("order_id"),rs.getInt("u_id"),rs.getString("name"),rs.getInt("branch_id"),rs.getString("d_location"),rs.getInt("price"),rs.getString("status"),rs.getString("driver_name"),rs.getInt("sls_id"));
			orders.add(order);
		}
		return orders;
	}
	
	public static List<Order> orderDeets(int id) throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "select p_id,product_name,product_img,order_quantity,o_date from orders a INNER JOIN products b ON a.p_id = b.product_id where order_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		List<Order> od = new ArrayList();
		while(rs.next()) {
			Order order = new Order(rs.getInt("p_id"),rs.getString("product_name"),rs.getString("product_img"),rs.getInt("order_quantity"),rs.getString("o_date"));
			od.add(order);
		}
		return od;
		
	}

}
