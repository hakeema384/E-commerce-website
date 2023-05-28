<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*"%>
<%@page import="com.codewithme.model.*"%>
<%@page import="com.codewithme.dao.*"%>
<%@page import="com.codewithme.service.*"%>
<%@page import="java.sql.*" %>
<%
int id = (Integer)session.getAttribute("SAbranchID");

%>
<jsp:include page="headerSA.jsp" />
<p>${message}</p>
<br/>  
<div class="container">
<form action="updateStatusSA" method="post">
<div class="mb-3">
<label for="orderID">Order ID: </label>
<input id="orderID" readonly="readonly" name="orderID" type="number" class="form-control" value="<%=request.getParameter("orderID")%>">
</div>
<div class="mb-3">
<label for="Status">Status:  </label>
<select name="status" class="form-select">
<option>Processing</option>
<option>Confirmed</option>
<option>Out of delivery</option>
<option>Delivered</option>
</select>
</div>
<div class="mb-3">
<label for="driverName">Driver Name:  </label>
<select name="driverName" class="form-select">
<option value="<%=request.getParameter("dName")%>"><%=request.getParameter("dName")%></option>
<%
try{
	DbConnector connector = new DbConnectorImplMySql();
	Connection connection = connector.getConnection();
	String query = "select * from driver where branch_id=?";
	PreparedStatement pst = connection.prepareStatement(query);
	pst.setInt(1,id);
	ResultSet rs = pst.executeQuery();
	while(rs.next()){
		%>
		<option value="<%=rs.getString("driver_name")%>"><%=rs.getString("driver_name") %></option>
		<%
	}
}
catch(Exception e){
	e.printStackTrace();
}

%>
</select>
</div>
<div class="mb-3">
<label for="vehicle">Vehicle: </label>
<select name="vehicle" class="form-select">
<option value="<%=request.getParameter("vcl")%>"><%=request.getParameter("vcl")%> </option>
<%
try{
	DbConnector connector1 = new DbConnectorImplMySql();
	Connection connection1 = connector1.getConnection();
	String q = "select * from vehicle where branch_id=?";
	PreparedStatement ps = connection1.prepareStatement(q);
	ps.setInt(1,id);
	ResultSet rs1 = ps.executeQuery();
	while(rs1.next()){
		%>
		<option value="<%=rs1.getString("vehicle")%>"><%=rs1.getString("vehicle") %></option>
		<%
	}
}
catch(Exception e){
	e.printStackTrace();
}

%>
</select>
</div>

<br/>
<button type="submit" class="btn btn-warning"> Update Information</button>
</form>
</div>
<jsp:include page="footerSA.jsp" />  