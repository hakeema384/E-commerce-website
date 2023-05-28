<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />  

  <p>${message}</p>

<br/>

<div class="container">
<form action="SA_edit" method="post">
<label for="agentID">Sales Agent ID: </label>
<input id="agentID" readonly="readonly" name="agentID" type="number" class="form-control" value="<%=request.getParameter("agentID") %>">
<label for="Branch ID">Branch ID: </label>
<input id="branchID" name="branchID" type="number" class="form-control" value="<%=request.getParameter("branchID") %>">
<label for="Name">Name:  </label>
<input id="name" name="name" type="text" class="form-control" value="<%=request.getParameter("fullname") %>">
<label for="username">Username:  </label>
<input id="username" name="username" type="text" class="form-control" value="<%=request.getParameter("uname") %>">
<label for="password">Password</label>
<input id="password" name="password" type="text" class="form-control" value="<%=request.getParameter("pass") %>">
<label for="email">Email:  </label>
<input id="email" name="email" type="email" class="form-control" value="<%=request.getParameter("email") %>">
<input type="hidden" name="action" value="edit">
<br/>
<button type="submit" class="btn btn-warning"> Update Information</button>
</form>
</div>
<jsp:include page="footer.jsp" />  