package com.codewithme.model;

public class SalesAgent {
	private int id;
	private int SA_id;
	private int branch_id;
	private String username;
	private String password;
	private String SA_name;
	private String SA_email;
	private int sales;
	public SalesAgent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesAgent(int branch_id, String username, String password, String sA_name, String sA_email) {
		super();
		this.branch_id = branch_id;
		this.username = username;
		this.password = password;
		this.SA_name = sA_name;
		this.SA_email = sA_email;
	}
	
	public SalesAgent(int sA_id, int branch_id, String username, String password, String sA_name, String sA_email,
			int sales) {
		super();
		SA_id = sA_id;
		this.branch_id = branch_id;
		this.username = username;
		this.password = password;
		SA_name = sA_name;
		SA_email = sA_email;
		this.sales = sales;
	}
	public SalesAgent(int id, int sA_id, int branch_id, String username, String password, String sA_name,
			String sA_email, int sales) {
		super();
		this.id = id;
		this.SA_id = sA_id;
		this.branch_id = branch_id;
		this.username = username;
		this.password = password;
		this.SA_name = sA_name;
		this.SA_email = sA_email;
		this.sales = sales;
	}
	public SalesAgent(int sA_id, int branch_id, String sA_name, String sA_email) {
		super();
		this.SA_id = sA_id;
		this.branch_id = branch_id;
		this.SA_name = sA_name;
		this.SA_email = sA_email;
	}
	public int getSA_id() {
		return SA_id;
	}
	public void setSA_id(int sA_id) {
		this.SA_id = sA_id;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSA_name() {
		return SA_name;
	}
	public void setSA_name(String sA_name) {
		this.SA_name = sA_name;
	}
	public String getSA_email() {
		return SA_email;
	}
	public void setSA_email(String sA_email) {
		this.SA_email = sA_email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	

}
