<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />  



<br/>
<div class="container">
<div>
<a href="AddProduct.jsp"><button type="submit" class="btn btn-primary"> Add new product</button></a>
</div>
</div>
<br/>

<div class="container">
<table class="table table-hover">
<thead>
    <tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Price</th>
      <th>Image</th>
    </tr>
</thead>

    <tbody>
     <tag:forEach var="product" items= "${productList}">
    <tr>
         <td>${product.getProductID()}</td>
         <td>${product.getProductName()}</td>
         <td>${product.getPrice()}</td>
         <td><img src="images/${product.getProductImg()}" width="150px;" height="150px;"></td>
          <td>
         <form action="editProduct.jsp" method="post">
         <input type="hidden" name="productID" value="${product.getProductID()}">
         <input type="hidden" name="productName" value="${product.getProductName()}">
         <input type="hidden" name="price" value="${product.getPrice()}">
         <button type="submit" class="btn btn-success"> Edit</button>
         </form>
         </td>
         <td>
         <form action="ProductDelete" method="post">
         <input type= "hidden" name="action" value="deleteProduct">
         <input type="hidden" name="agentID" value="${product.getProductID()}">
         <button type="submit" class="btn btn-danger"> Delete</button>
         </form>
         </td>
        
    </tr>
    </tag:forEach>
    </tbody>
</table>
</div>

	

<jsp:include page="footer.jsp" />  