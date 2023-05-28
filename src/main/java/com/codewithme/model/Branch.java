package com.codewithme.model;

public class Branch {
	private int branchID;
	private String branchName;
	private int totalSales;
	public Branch(int branchID, String branchName, int totalSales) {
		super();
		this.branchID = branchID;
		this.branchName = branchName;
		this.totalSales = totalSales;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	

}
