package com.codewithme.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.dao.DriverDao;
import com.codewithme.dao.OrderDao;
import com.codewithme.model.Order;
import com.codewithme.model.OrderLogs;
import com.codewithme.model.OrderManage;

public class OrderService {
	
	public boolean insertOrder(Order order) throws ClassNotFoundException, SQLException {
		return OrderDao.insertOrder(order);
	}
	
	public boolean insertMultiple(ArrayList<Order> checkout, int userID, int price, int brID) throws ClassNotFoundException, SQLException {
		return OrderDao.insertMultiple(checkout, userID, price,brID);
	}
	
	public boolean addOrder(OrderManage order, int oID) throws ClassNotFoundException, SQLException {
		return OrderDao.addOrder(order, oID);
	}
	
	public List<OrderManage> viewAllOrders(int id) throws ClassNotFoundException, SQLException{
		return OrderDao.viewAllOrders(id);
	}
	
	public boolean updateOrder(OrderManage og,int branchID, int slsID) throws ClassNotFoundException, SQLException {
		return OrderDao.updateOrder(og,branchID,slsID);
	}
	
	public List<OrderLogs> getOrderLogs(String name) throws ClassNotFoundException, SQLException{
		return DriverDao.getOrderLogs(name);
	}
	
	public boolean updateDelivered(int orderID) throws ClassNotFoundException, SQLException {
		return OrderDao.updateDelivered(orderID);
	}
	
	public List<OrderManage> viewOrdersAdmin() throws ClassNotFoundException, SQLException{
		return OrderDao.viewOrdersAdmin();
	}
	
	public List<Order> orderDeets(int id) throws ClassNotFoundException, SQLException{
		return OrderDao.orderDeets(id);
	}
}
