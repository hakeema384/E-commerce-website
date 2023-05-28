package com.codewithme.model;

public class OrderLogs extends OrderManage {
	private int id;
//	private int orderID;
//	private int SA_id;
//	private int branchID;
//	private String driverName;
	private boolean delivered;
	
	
	public OrderLogs() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public OrderLogs(int id, int OrderID,int sa_ID, String driver, boolean delivered) {
		super(OrderID,driver,sa_ID);
		this.id = id;
		this.delivered = delivered;
	}


//	public OrderLogs(int id, int orderID, int sA_id, String driverName, boolean delivered) {
//		super();
//		this.id = id;
//		this.orderID = orderID;
//		SA_id = sA_id;
//		this.driverName = driverName;
//		this.delivered = delivered;
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


//	public int getOrderID() {
//		return orderID;
//	}
//
//	public void setOrderID(int orderID) {
//		this.orderID = orderID;
//	}
//
//	public int getSA_id() {
//		return SA_id;
//	}
//
//	public void setSA_id(int sA_id) {
//		SA_id = sA_id;
//	}
//
//	public int getBranchID() {
//		return branchID;
//	}
//
//	public void setBranchID(int branchID) {
//		this.branchID = branchID;
//	}
//
//	public String getDriverName() {
//		return driverName;
//	}
//
//	public void setDriverName(String driverName) {
//		this.driverName = driverName;
//	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	

}
