<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headerSA.jsp" />  

<p>${message}</p>
<p>${deleteMessage}</p>
<br/>
<div class="container">
<div>
<a href="AddProduct.jsp"><button type="submit" class="btn btn-primary"> Add new brand</button></a>
</div>
</div>
<br/>

<div class="container">
<table class="table table-hover">
<thead>
    <tr>
      <th>Brand ID</th>
      <th>Brand Name</th>
    </tr>
</thead>

    <tbody>
     <tag:forEach var="brand" items= "${brandList}">
    <tr>
         <td>${brand.getBrandID()}</td>
         <td>${brand.getBrandName()}</td>
          <td>
         <form action="editProduct.jsp" method="post">
         <input type="hidden" name="brandID" value="${brand.getBrandID()}">
         <button type="submit" class="btn btn-success"> Edit</button>
         </form>
         </td>
         <td>
         <form action="ProductDelete" method="post">
         <input type= "hidden" name="action" value="deleteProduct">
         <input type="hidden" name="agentID" value="${brand.getBrandID()}">
         <button type="submit" class="btn btn-danger"> Delete</button>
         </form>
         </td>
        
    </tr>
    </tag:forEach>
    </tbody>
</table>
</div>



<jsp:include page="footerSA.jsp" />  