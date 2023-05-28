<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="header.jsp" /> 
    
    
    <div class="container">
<table class="table table-hover">
<thead>
    <tr>
      <th>Order ID</th>
      <th>User ID</th>
      <th>Name</th>
      <th>Branch ID</th>
      <th>Delivery Location</th>
      <th>Price</th>
      <th>Status of the order</th>
      <th>Driver Name</th>
      <th>Sales Agent ID</th>
      <th>View More</th>
    </tr>
</thead>

    <tbody>
     <tag:forEach var="order" items= "${ordersAdmin}">
    <tr>
         <td>${order.getOrderID()}</td>
         <td>${order.getUserID()}</td>
         <td>${order.getName()}</td>
         <td>${order.getBranchID()}</td>
         <td>${order.getD_location()}</td>
         <td>${order.getPrice()}</td>
         <td>${order.getStatus()}</td>
         <td>${order.getDriver()}</td>
         <td>${order.getSa_ID()}</td>
          <td>
         <form action="OrderDeets" method="get">
         <input type="hidden" name="orderID" value="${order.getOrderID()}">
         <input type="hidden" name="orderStatus" value="${order.getStatus()}">
          <input type="hidden" name="action" value="all">
         <button type="submit" class="btn btn-info">View More</button>
         </form>
         </td>
    </tr>
    </tag:forEach>
    </tbody>
</table>
</div>
    
     
<jsp:include page="footer.jsp" />  