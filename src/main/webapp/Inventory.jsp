<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="headerSA.jsp" />  
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
  </symbol>
  <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
  </symbol>
  <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </symbol>
</svg>

<p>${message}</p>
<p>${deleteMessage}</p>


<div class="container">
<table class="table table-hover">
<thead>
    <tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Price</th>
      <th>Brand ID</th>
      <th>Category ID</th>
      <th>Quantity</th>
      <th>Status</th>
    </tr>
</thead>

    <tbody>
     <tag:forEach var="product" items= "${prdList}">
    <tr>
         <td>${product.getProductID()}</td>
         <td>${product.getProductName()}</td>
         <td>${product.getPrice()}</td>
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
          <td>
         <form action="" method="post">
         <input type="hidden" name="brandID" value="${product.getProductID()}">
         <button type="submit" class="btn btn-success"> Edit</button>
         </form>
         </td>
          <td>
         <form action="Requests.jsp" method="post">
         <input type="hidden" name="productID" value="${product.getProductID()}">
         <input type="hidden" name="productName" value="${product.getProductName()}">
         <input type="hidden" name="brandID" value="${product.getBrandID()}">
         <input type="hidden" name="categoryID" value="${product.getCategoryID()}">
         <button type="submit" class="btn btn-warning">Send request</button>
         </form>
         </td>
        
    </tr>
    </tag:forEach>
    </tbody>
</table>
</div>



<jsp:include page="footerSA.jsp" />  