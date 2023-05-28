<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.codewithme.model.Cart"%>
<%@page import="com.codewithme.dao.*"%>
<%@page import="com.codewithme.service.*"%>
<%@page import="java.sql.*" %>
<%
int bb = (Integer)session.getAttribute("branchID");

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

	<header class="masthead text-black text-center">
		<div class="container d-flex align-items-center flex-column">
			<div class="container">
				<div class="d-flex py-3">
				<%
				int oID = 0;
				int price = 0;
				DbConnector connector = new DbConnectorImplMySql();
				Connection connection = connector.getConnection();
				String q2 = "select max(order_id) as oID from order_manage";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(q2);
				while(rs.next()) {
					oID = rs.getInt("oID");
				}
				st.close();
				String q = "select price from order_manage where order_id=?";
				PreparedStatement p = connection.prepareStatement(q);
				p.setInt(1,oID);
				ResultSet rs2 = p.executeQuery();
				if(rs2.next()){
					price = rs2.getInt("price");
				}
				%>
					<h3>Your bill : Rs.<%=price%></h3>
				</div>
			</div>
		</div>
	</header>
	
	
	<div class="mx-auto" style="width:600px;">
	<div class="container">
		<form class="form-inline" action="OrderPage" method="post">
			<div class="mb-2">
				<label for="Name" class="form-label">Full name: </label>
				 <input type="text" name="name" class="form-control" required>
			</div>
			<div class="mb-2">
				<label for="address" class="form-label">Address: </label> <input
					type="text" name="address" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="location" class="form-label">Delivery location:
				</label> 
				<select name="location" class="form-select" required>
				<option value="-1">Select Delivery location</option>
				<%
				try{
					DbConnector connector1 = new DbConnectorImplMySql();
					Connection connection1 = connector1.getConnection();
					String query = "select * from delivery where branch_id=?";
					PreparedStatement pst = connection1.prepareStatement(query);
					pst.setInt(1,bb);
					ResultSet rs1 = pst.executeQuery();
					while(rs1.next()){
						%>
						<option value="<%=rs1.getString("d_location")%>"><%=rs1.getString("d_location") %></option>
						<%
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				%>
				</select>
			</div>
			<div class="mb-4">
			<label class="form-label"> Payment mode: </label>
			<input readonly="readonly" value="Cash on delivery" type="text" class="form-control" required>
			</div>
			<input type="hidden" name="orderID" value="<%=oID %>">
			<button type="submit" class="btn btn-primary">Process my order</button>
		</form>
		
	</div>
	</div>
	
</body>
</html>