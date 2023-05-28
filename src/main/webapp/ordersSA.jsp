<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="headerSA.jsp" />  
   <p>${message}</p> 
  <br/>  
    <div class="container">
<table class="table table-hover">
<thead>
    <tr>
      <th>Order ID</th>
      <th>User ID</th>
      <th>Name</th>
      <th>Address</th>
      <th>Branch ID</th>
      <th>Delivery location</th>
      <th>Price</th>
      <th>status</th>
      <th>Driver Name</th>
      <th>Vehicle</th>
    </tr>
</thead>

    <tbody>
     <tag:forEach var="orders" items= "${orderList}">
    <tr>
         <td>${orders.getOrderID()}</td>
         <td>${orders.getUserID()}</td>
         <td>${orders.getName()}</td>
         <td>${orders.getAddress()}</td>
         <td>${orders.getBranchID()}</td>
         <td>${orders.getD_location()}</td>
         <td>${orders.getPrice()}</td>
         <td>${orders.getStatus()}</td>
         <td>${orders.getDriver()}</td>
         <td>${orders.getVehicle()}</td>
          <td>
         <form action="UpdateStatus.jsp" method="post">
         <input type="hidden" name="orderID" value="${orders.getOrderID()}">
         <input type="hidden" name="dName" value="${orders.getDriver()}">
         <input type="hidden" name="vcl" value="${orders.getVehicle()}">
         <button type="submit" class="btn btn-info">Update</button>
         </form>
         </td>
         
    </tr>
    </tag:forEach>
    </tbody>
</table>
</div>

<jsp:include page="footerSA.jsp" />  