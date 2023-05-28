<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<jsp:include page="header.jsp" />  
<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
<br/>
  <p>${message}</p>
<br/>

<div class="container">
<form action="SA_add" method="post">
<label for="branchID">Enter Sales Agent ID: </label>
<input type="number" id="branchID" name="agentID" class="form-control" required>
<label for="branchID">Enter branch ID: </label>
<input type="number" id="branchID" name="branchID" class="form-control" required>
<label for="agentName">Enter Sales Agent Name: </label>
<input type="text" id="agentName" name="agentName" class="form-control" required>
<label for="agentID">Enter Sales Agent username: </label>
<input type="text" id="agentUname" name="agentUname" class="form-control" required>
<label for="agentID">Enter Sales Agent password: </label>
<input type="text" id="agentPassword" name="agentPassword" class="form-control" required>
<label for="agentID">Enter Sales Agent email: </label>
<input type="text" id="agentEmail" name="agentEmail" class="form-control" required>
<input type="hidden" name="action" value="add">
<br/>
<button type="submit" class="btn btn-primary"> Add</button>
</form>
</div>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "success") {
			swal("Success", "Details added successfully", "success");
		} else if (status == "error") {
			swal("Oops", "Please check your inputs again", "error");
		} else if (status == "failed") {
			swal("Oops", "Details were not added", "error");
		}
	</script>

<jsp:include page="footer.jsp" />  