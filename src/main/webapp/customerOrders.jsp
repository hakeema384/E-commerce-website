<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="java.util.*"%>
	<%@page import="com.codewithme.model.*"%>
<%@page import="com.codewithme.dao.*"%>
<%@page import="com.codewithme.service.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*"%>
<%
Login user = (Login) request.getSession().getAttribute("name");
user.setUsername(user.getUsername());
user.setPassword(user.getPassword());
RegisterService lg = new RegisterService();
int id = lg.getID(user);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Freelancer - Start Bootstrap Theme</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index-styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">TechMart</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="CustomerView">Home</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="cart.jsp">Cart</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="customerOrders.jsp">All orders</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</nav>

	<header class="masthead text-black text-center"><h2>Your Orders</h2> </header>
<%
try{
	DbConnector connector = new DbConnectorImplMySql();
	Connection connection = connector.getConnection();
	ArrayList<OrderManage> od = new ArrayList<OrderManage>();
	String query = "Select * from order_manage where u_id=?";
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setInt(1,id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){%>
	
	<div class="container mt-2 border border-success">
		<div class="container mt-3 py-4">
			<h5>Order Id:&nbsp;&nbsp;<%=rs.getInt("order_id") %> </h5>
			<p>Name:&nbsp;&nbsp;<%=rs.getString("name") %> </p>
			<p>Address:&nbsp;&nbsp;<%=rs.getString("address") %> </p>
			<p>Total price: Rs.&nbsp;<%=rs.getString("price") %> </p>
			<p>Status of the order:&nbsp;&nbsp;<span class="badge rounded-pill bg-info"><%=rs.getString("status") %></span></p>
			<input type="hidden" name="status" value="<%=rs.getString("status") %>">
			<p>Driver Name:&nbsp;<%=rs.getString("driver_name") %></p>
			<p>Vehicle:&nbsp;<%=rs.getString("vehicle") %></p>
			
			 
        <a href="feedback.jsp" class="btn btn-primary btn-sm active" role="button" aria-pressed="true">Leave feedback</a>
        
		</div>
		
	</div>
		
	<%}
	
	
}
catch(Exception e){
	e.printStackTrace();
	
}
%>

</body>
</html>