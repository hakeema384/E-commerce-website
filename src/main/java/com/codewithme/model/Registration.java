package com.codewithme.model;

public class Registration {
	private int id;
	private int branchID;
	private String username;
	private String password;
	private String email;
	private String user_role;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Registration(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
	}

	public Registration(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Registration(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Registration(int id, int branchID, String username, String password, String email, String user_role) {
		super();
		this.id = id;
		this.branchID = branchID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_role = user_role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	
	

}
