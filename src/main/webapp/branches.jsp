<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />  


<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					
					<th>Branch ID</th>
					<th>Branch Name</th>
					<th>Total sales</th>
				</tr>
			</thead>

			<tbody>
				<tag:forEach var="branches" items="${branches}">
					<tr>
						<td>${branches.getBranchID()}</td>
						<td>${branches.getBranchName()}</td>
						<td>${branches.getTotalSales()}</td>
						
					</tr>
				</tag:forEach>
			</tbody>
		</table>
	</div>


<jsp:include page="footer.jsp" />  