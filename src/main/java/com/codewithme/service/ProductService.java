package com.codewithme.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codewithme.dao.ProductDao;
import com.codewithme.model.Cart;
import com.codewithme.model.OrderManage;
import com.codewithme.model.Product;

public class ProductService {

	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		return ProductDao.addProduct(product);
	}
	
	public List<Product> viewProducts() throws ClassNotFoundException, SQLException {
		return ProductDao.getAllProducts();
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		return ProductDao.updateProduct(product);
	}
	
	public List<Product> getProductsSA() throws ClassNotFoundException, SQLException{
		return ProductDao.getProductsSA();
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		return ProductDao.getCartProducts(cartList);
	}
	
	public int getTotalCartPrice(ArrayList<Cart> cartList) {
		return ProductDao.getTotalCartPrice(cartList);
	}
	
	public List<OrderManage> getOrderDetails() throws ClassNotFoundException, SQLException{
		return ProductDao.getOrderDetails();
	}
	
	public List<Product> viewInventory() throws ClassNotFoundException, SQLException{
		return ProductDao.viewInventory();
	}
	
	public boolean sendRequest(Product product) throws ClassNotFoundException, SQLException {
		return ProductDao.sendRequest(product);
	}
	
	public List<Product> viewRequests(int id) throws ClassNotFoundException, SQLException{
		return ProductDao.viewRequests(id);
	}
}
