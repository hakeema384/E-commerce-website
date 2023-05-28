package com.codewithme.model;

public class Product {
	private int productID;
	private String productName;
	private int price;
	private String productImg;
	private int brandID;
	private int categoryID;
	private int quantity;
	private boolean status;
	private int sa_ID;
	private int branch_ID;
	private String date;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, int price, String productImg) {
		super();
		this.productName = productName;
		this.price = price;
		this.productImg = productImg;
	}
	
	public Product(int productID, String productName, int price, String productImg) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.productImg = productImg;
	}
	
	public Product(int productID, String productName, int price, int brandID, int categoryID, int quantity,
			boolean status) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.brandID = brandID;
		this.categoryID = categoryID;
		this.quantity = quantity;
		this.status = status;
	}
	
	public Product(int productID, int brandID, int categoryID, int quantity, boolean status) {
		super();
		this.productID = productID;
		this.brandID = brandID;
		this.categoryID = categoryID;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public Product(int productID, String productName, int brandID, int categoryID, int sa_ID, int branch_ID,
			String date) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.brandID = brandID;
		this.categoryID = categoryID;
		this.sa_ID = sa_ID;
		this.branch_ID = branch_ID;
		this.date = date;
	}
	
	public Product(int productID, String productName, int brandID, int categoryID, String date) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.brandID = brandID;
		this.categoryID = categoryID;
		this.date = date;
	}
	
	public Product(int productID, String productName, String productImg) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productImg = productImg;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getSa_ID() {
		return sa_ID;
	}
	public void setSa_ID(int sa_ID) {
		this.sa_ID = sa_ID;
	}
	public int getBranch_ID() {
		return branch_ID;
	}
	public void setBranch_ID(int branch_ID) {
		this.branch_ID = branch_ID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
