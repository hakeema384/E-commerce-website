<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="headerSA.jsp" />  
<p>${message}</p>
<h2> Requests made by you</h2>
<div class="container bootstrap snippets bootdey mt-5">
    <div class="table-responsive">
    	<!-- PROJECT TABLE -->
    	<table class="table colored-header datatable project-list">
    		<thead>
    			<tr>
    				
    				<th>Product ID</th>
    				<th>Product Name</th>
    				<th>Brand ID</th>
    				<th>Category ID</th>
    				<th>Request Date </th>
    			</tr>
    		</thead>
    		<tbody>
    		<tag:forEach var="product" items= "${requests}">
    			<tr>
    			    
    				<td>${product.getProductID()}</td>
    				<td>${product.getProductName()}</td>
    				<td>${product.getBrandID()}</td>
    				<td>
    					${product.getCategoryID()}
    				</td>
    				<td>${product.getDate()}</td>
    				
    			</tr>
    			</tag:forEach>
    		</tbody>
    	</table>
    	<!-- END PROJECT TABLE -->
    </div>
</div>

<style type="text/css">


.project-list > tbody > tr > td {
  padding: 12px 8px;
}

.project-list > tbody > tr > td .avatar {
  width: 22px;
  border: 1px solid #CCC;
}
</style>

<script type="text/javascript">

</script>

<jsp:include page="footerSA.jsp" /> 