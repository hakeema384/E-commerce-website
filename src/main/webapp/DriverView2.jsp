<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="java.util.*"%>
	<%@page import="com.codewithme.model.*"%>
<%@page import="com.codewithme.dao.*"%>
<%@page import="com.codewithme.service.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
    <!--  All snippets are MIT license http://bootdey.com/license -->
    <title>order details - Bootdey.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("oID"));
session.setAttribute("orderID",id);
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Driver">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid">

<div class="container">
  <!-- Title -->
  <div class="d-flex justify-content-between align-items-center py-3">
    <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Order #<%=id %></h2>
  </div>

  <!-- Main content -->
  <div class="row">
    <div class="col-lg-8">
      <!-- Details -->
      <div class="card mb-4">
        <div class="card-body">
          <div class="mb-3 d-flex justify-content-between">
            <div>
              
              <span class="badge rounded-pill bg-info">PRODUCTS</span>
            </div>
            
          </div>
          

          <table class="table table-borderless">
            <tbody>
             <%
try{
	DbConnector connector = new DbConnectorImplMySql();
	Connection connection = connector.getConnection();
	ArrayList<OrderLogs> od = new ArrayList<OrderLogs>();
	String query = "select product_name,price,product_img,order_quantity from products p INNER JOIN orders o ON p.product_id = o.p_id where o.order_id=?";
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setInt(1,id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
	int price = rs.getInt("price");
	%>
              <tr>
                <td>
                  <div class="d-flex mb-2">
                    <div class="flex-shrink-0">
                      <img src="images/<%=rs.getString("product_img")%>" alt="" width="35" class="img-fluid">
                    </div>
                    <div class="flex-lg-grow-1 ms-3">
                      <h6 class="small mb-0"><a href="#" class="text-reset"><%=rs.getString("product_name") %></a></h6>
                    </div>
                  </div>
                </td>
                <td><%=rs.getInt("order_quantity") %></td>
                <td class="text-end"><%=price %></td>
              </tr>
              
             <%
	}
}
	catch(Exception e){
		e.printStackTrace();
		
	}
             %>
            </tbody>
          </table>
        </div>
      </div>
      <!-- Payment -->
      <%
try{
	DbConnector connector1 = new DbConnectorImplMySql();
	Connection connection1 = connector1.getConnection();
	ArrayList<OrderLogs> od = new ArrayList<OrderLogs>();
	String query = "select u_id,name,address,d_location,price,delivered from order_manage a INNER JOIN order_logs b ON a.order_id = b.order_id where a.order_id=?";
	PreparedStatement pst = connection1.prepareStatement(query);
	pst.setInt(1,id);
	ResultSet rs1 = pst.executeQuery();
	while(rs1.next()){
		boolean b = rs1.getBoolean("delivered");
	%>
      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-6">
              <h3 class="h6">Payment Method</h3>
              <p>Cash on delivery <br>
             <strong> Total: </strong><%=rs1.getInt("price") %></p>
            </div>
            <div class="col-lg-6">
              <h3 class="h6">Billing address</h3>
              <address>
                <strong><%=rs1.getString("name") %></strong><br>
                <p>
                <%=rs1.getString("address") %>
                </p>
              </address>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4">
      <!-- Customer Notes -->
      <div class="card mb-4">
        <div class="card-body">
          <h3 class="h6">Customer Notes</h3>
          <p>User ID: <%=rs1.getInt("u_id") %><br/> Delivery location: <%=rs1.getString("d_location") %></p>
        </div>
      </div>
      <div class="card mb-4">
        <!-- Shipping information -->
        <div class="card-body">
          
          <h3 class="h6">Status of the order</h3>
          
              <form action="OrderDelivered" method="get">
					        <input type="hidden" name="orderID" value="<%=session.getAttribute("orderID") %>">
					        <input type="submit" value="Delivered" class="btn btn-primary active">
					        </form>
					        
          
        </div>
      </div>
    </div>
    <%
    }
    }
    catch(Exception e){
    	e.printStackTrace();
    }
    %>
  </div>
</div>
  </div>

<style type="text/css">
body{
    background:#eee;
}
.card {
    box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
}
.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid rgba(0,0,0,.125);
    border-radius: 1rem;
}
.text-reset {
    --bs-text-opacity: 1;
    color: inherit!important;
}
a {
    color: #5465ff;
    text-decoration: none;
}
</style>

<script type="text/javascript">

</script>
</body>
</html>