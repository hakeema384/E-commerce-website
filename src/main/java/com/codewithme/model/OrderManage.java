package com.codewithme.model;

public class OrderManage {
	private int orderID;
	private int userID;
	private String name;
	private String address;
	private int branchID;
	private String d_location;
	private int price;
	private String status;
	private String driver;
	private String vehicle;
	private int sa_ID;
	public OrderManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderManage(int orderID, int userID) {
		super();
		this.orderID = orderID;
		this.userID = userID;
	}
	public OrderManage(int orderID, int userID, String name, String address, int branchID, String d_location) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.name = name;
		this.address = address;
		this.branchID = branchID;
		this.d_location = d_location;
	}
	
	
	public OrderManage(int orderID, int userID, String name, String address, int branchID, String d_location, int price,
			String status, String driver, String vehicle) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.name = name;
		this.address = address;
		this.branchID = branchID;
		this.d_location = d_location;
		this.price = price;
		this.status = status;
		this.driver = driver;
		this.vehicle = vehicle;
	}
	
	
	public OrderManage(int orderID, String name, String address, int price, String status, String driver,
			String vehicle) {
		super();
		this.orderID = orderID;
		this.name = name;
		this.address = address;
		this.price = price;
		this.status = status;
		this.driver = driver;
		this.vehicle = vehicle;
	}
	
	public OrderManage(int orderID, int userID, String name, int branchID, String d_location, int price, String status,
			String driver, int sa_ID) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.name = name;
		this.branchID = branchID;
		this.d_location = d_location;
		this.price = price;
		this.status = status;
		this.driver = driver;
		this.sa_ID = sa_ID;
	}
	
	
	public OrderManage(int orderID, String driver, int sa_ID) {
		super();
		this.orderID = orderID;
		this.driver = driver;
		this.sa_ID = sa_ID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getD_location() {
		return d_location;
	}
	public void setD_location(String d_location) {
		this.d_location = d_location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public int getSa_ID() {
		return sa_ID;
	}
	public void setSa_ID(int sa_ID) {
		this.sa_ID = sa_ID;
	}
	
	

}
