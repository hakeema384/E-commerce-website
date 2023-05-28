<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />  
<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
<div class="container">
<form action="ProductEdit" method="post" enctype="multipart/form-data">
<label for="productID">Product ID: </label>
<input id="productID" readonly="readonly" name="productID" type="number" class="form-control" value="<%=request.getParameter("productID") %>">
<label for="productName">Product Name:  </label>
<input id="name" name="productName" type="text" class="form-control" value="<%=request.getParameter("productName") %>">
<label for="price">Price:  </label>
<input id="price" name="price" type="number" class="form-control" value="<%=request.getParameter("price") %>">
<label for="productImage">Product Image: </label>
<br/>
<br/>
<input id="productImage" name="productImage" type="file">
<br/>
<br/>
<input type="hidden" name="action" value="updateProduct">
<br/>
<button type="submit" class="btn btn-warning"> Update Information</button>
</form>
</div>


<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "failed") {
			swal("Oops", "Product not updated", "error");
		} else if (status == "updated") {
			swal("Success", "Product updated successfully", "success");
		} 
		else if (status == "error"){
			swal("Oops", "There has been an error in updating", "error");
		}
	</script>
	
<jsp:include page="footer.jsp" />  