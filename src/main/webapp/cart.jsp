<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" %>
<%@page import="com.codewithme.model.Cart" %>
<%@page import="com.codewithme.dao.*" %>
<%@page import="com.codewithme.service.*" %>

<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
List<Cart> cartProduct = null;
if(cart_list != null){
	ProductService pd = new ProductService();
	cartProduct = pd.getCartProducts(cart_list);
	int total = pd.getTotalCartPrice(cart_list);
	request.setAttribute("cart_list",cart_list);
	request.setAttribute("total",total);	
}
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
				<form action="CheckOut" method="post">
					<h3>Total price: Rs. <%=request.getAttribute("total") %></h3>
         <input type="hidden" name="total" value="<%=request.getAttribute("total")%>">
         <button type="submit" class="btn btn-primary"> Checkout</button>
         </form>
				</div>
			</div>
		</div>
	</header>
	<table class="table table-light">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Buy now</th>
				<th scope="col">Cancel</th>
			</tr>
		</thead>
		<tbody>
		<%if(cart_list != null){
			for(Cart c:cartProduct){%>
				<tr>
				<td><%=c.getProductName() %></td>
				<td>Rs. <%=c.getPrice() %></td>
				<td>
					<form action="OrderNow" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%=c.getProductID() %>" class="form-input">
						<input type="hidden" name="price" value="<%=c.getPrice() %>" class="form-input">
						<div class="form-group d-flex justify-content-between w-50">
							<a class="btn btn-sm btn-incre" href="QuantityIncDec?action=inc&id=<%= c.getProductID() %>"><i class="fas fa-plus-circle"></i></a>
							<input type="text" name="quantity" class="form-control w-50" value="<%=c.getQuantity() %>" readonly> 
							<a class="btn btn-sm btn-decre" href="QuantityIncDec?action=dec&id=<%= c.getProductID() %>">
							<i class="fas fa-minus-circle"></i></a>
							<button type="submit" class="btn btn-primary btn-sm">Buy now</button>
						</div>
						
					</form>
				</td>
				
				<td>
				<a class="btn btn-sm btn-danger" href="RemoveFromCart?id=<%= c.getProductID() %>">Remove</a>
				</td>
				
			</tr>
			<%}
		}
		
		
		%>
			
		</tbody>
	</table>



</body>
</html>