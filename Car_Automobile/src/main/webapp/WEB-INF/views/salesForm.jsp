<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container bg-light">
<h1>Sales</h1>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Sales Information</legend>
		<form:form action="addSales" method="POST" modelAttribute="sale">
			<div>
				<label>Sales Name</label><br>
				<form:input type="text" id="saleName" path="saleName" /><br>
				<form:errors class="text-danger" path="saleName" /><br>
			</div>
			<div>
				<label>Sales Email</label><br>
				<form:input type="text" id="email" path="email" /><br>
				<form:errors class="text-danger" path="email" /><br>
			</div>	
			<div>
				<label>Sales Role</label><br>
				<form:input type="text" id="saleRole" path="saleRole" /><br>
				<form:errors class="text-danger" path="saleRole" /><br>
			</div>	
			
			
			<div>		
				<input type="submit" name="submit" value="Submit" />
			</div>
		</form:form>
	</fieldset>
</div>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Sale Table</legend>
		<table class="table table-striped">
			<tr>
				<td class="font-weight-bold">Sales ID</td>
				<td class="font-weight-bold">Sales Name</td>
				<td class="font-weight-bold">Email</td>
				<td class="font-weight-bold">Sales Role</td>
				
				<td></td>
			</tr>
			<c:forEach items="${sal}" var="sa">
				<tr>
					<td>${sa.saleId }</td>
					<td>${sa.saleName }</td>
					<td>${sa.email }</td>
					<td>${sa.saleRole }</td>
					
					<td><a href="${pageContext.request.contextPath}/deleteSales?id=${sa.saleId}">Remove Sales</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</div>
</body>
</html>