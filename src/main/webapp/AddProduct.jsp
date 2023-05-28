<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <jsp:include page="header.jsp" />  


<p>${message}</p>
<br/>

<div class="container">
<form name="myForm" action="ProductAdd" method="post" enctype="multipart/form-data">
<label for="productName">Enter product Name: </label>
<input type="text" id="productName" name="productName" class="form-control" required>
<label for="productPrice">Enter product price: </label>
<input type="number" id="productPrice" name="productPrice" class="form-control" required>
<label for="productImg">Enter product image: </label>
<br/>
<br/>
<input type="file" id="productImg" name="productImg" required>
<br/>
<input type="hidden" name="action" value="addProduct">
<br/>
<br/>
<button type="submit" class="btn btn-primary" onClick="return onValidate();"> Add</button>
</form>
</div>


	


 <jsp:include page="footer.jsp" />  