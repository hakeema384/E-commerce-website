<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headerSA.jsp" />  
 <%@page import="com.codewithme.model.*" %>
     <%@page import="com.codewithme.dao.*" %>

<%
if (session.getAttribute("SA") == null) {
	response.sendRedirect("login.jsp");
}

Login user = (Login) request.getSession().getAttribute("SA");
user.setUsername(user.getUsername());
user.setPassword(user.getPassword());
LoginDao lg = new LoginDao();
int brnID = lg.getBranchID(user);
int sID = lg.getID(user);
request.setAttribute("brID", brnID);
request.setAttribute("sID", sID);
%>

<p>${message}</p>
<br/>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
<div class="container">
<h4>Restock Request details </h4>
<form action="SA_view" method="get">
<label for="productID">Product ID: </label>
<input id="productID" readonly="readonly" name="productID" type="number" class="form-control" value="<%=request.getParameter("productID") %>">
<label for="productName">Product Name:</label>
<input id="productName" readonly="readonly" name="productName" type="text" class="form-control" value="<%=request.getParameter("productName") %>" >
<label for="Brand ID">Brand ID:  </label>
<input id="brandID" readonly="readonly" name="brandID" type="number" class="form-control" value="<%=request.getParameter("brandID") %>" >
<label for="Category ID">Category ID:  </label>
<input id="categoryID" readonly="readonly" name="categoryID" type="number" class="form-control" value="<%=request.getParameter("categoryID") %>">
<br/><h5>Request made by: </h5> <br/>
<label for="SA ID">Sales Agent ID:  </label>
<input id="saID" readonly="readonly" name="saID" type="number" class="form-control" value="<%=request.getAttribute("sID") %>" >
<label for="Branch ID">Branch ID:  </label>
<input id="brID" readonly="readonly" name="brID" type="number" class="form-control" value="<%=request.getAttribute("brID") %>">
<input type="hidden" name="action" value="request">
<br/>
<button type="submit" class="btn btn-warning">Send Request</button>
</form>
</div>

 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
    <script type="text/javascript">
    var status = document.getElementById("status").value;
    if(status == "success" ){
    	swal("Done", "Request sent!", "success");
    }
    else if(status == "failed"){
    	swal("Oops", "The request wasn't sent", "error");
    }
    else if(status == "error"){
    	swal("Failed", "There has been a problem!", "error");
    }
    
    </script>

<jsp:include page="footerSA.jsp" />  