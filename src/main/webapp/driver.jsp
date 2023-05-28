<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="java.util.*"%>
	<%@page import="com.codewithme.model.*"%>
<%@page import="com.codewithme.dao.*"%>
<%@page import="com.codewithme.service.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Table 03</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="CSS4/style.css">

	</head>
	<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Orders to be delivered</h2>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
						<table class="table">
					    <thead class="thead-primary">
					      <tr>
					        <th>ID</th>
					        <th>Order ID</th>
					        <th>Sales Agent ID</th>
					        <th>Driver Name</th>
					        <th>Delivered</th>
					      </tr>
					    </thead>
					    <tbody>
					<tag:forEach var="logs" items="${logs}">   
					      <tr>
					        <th scope="row" class="scope" >${logs.getId()}</th>
					        <td>${logs.getOrderID()}</td>
					        <td>${logs.getSa_ID()}</td>
					        <td>${logs.getDriver()}</td>
					        <td>
					        <tag:choose>
					       <tag:when test="${logs.isDelivered()==true}">
                             
					        <a href="" class="btn btn-secondary disabled">See details</a>
					         </tag:when>    
                            <tag:otherwise>
                            <form action="DriverView2.jsp" method="post">
					       <input type="hidden" name="oID" value="${logs.getOrderID()}">
					        <button type="submit" class="btn btn-primary active"> See details </button>
					        </form>
					        </tag:otherwise>
					        </tag:choose>
					        </td>
					      </tr>
					      
					</tag:forEach>
					    </tbody>
					  </table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="JS4/jquery.min.js"></script>
  <script src="JS4/popper.js"></script>
  <script src="JS4/bootstrap.min.js"></script>
  <script src="JS4/main.js"></script>

	</body>
</html>

