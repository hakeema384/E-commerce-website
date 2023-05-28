<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />  


<div class="container">
<table class="table table-hover">
<thead>
    <tr>
      <th>Product ID</th>
      <th>Brand ID</th>
      <th>Category ID</th>
      <th>Quantity</th>
      <th>Status</th>
    </tr>
</thead>

    <tbody>
     <tag:forEach var="product" items= "${invnList}">
    <tr>
         <td>${product.getProductID()}</td>
         <td>${product.getBrandID()}</td>
         <td>${product.getCategoryID()}</td>
         <td>${product.getQuantity()}</td>
         <td>
         <tag:choose>
    <tag:when test="${product.isStatus()==true}">
        <div class="alert alert-success d-flex align-items-center" role="alert">
  <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
  <div>
    Available
  </div>
</div>
        <br />
    </tag:when>    
    <tag:otherwise>
        <div class="alert alert-danger d-flex align-items-center" role="alert">
  <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
  <div>
    Not available
  </div>
</div> 
        <br />
    </tag:otherwise>
</tag:choose>
         </td>
    </tr>
    </tag:forEach>
    </tbody>
</table>
</div>

<jsp:include page="footer.jsp" />  
