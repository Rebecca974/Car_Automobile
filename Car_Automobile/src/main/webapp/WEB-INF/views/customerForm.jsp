<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container bg-light">
<h1>Customer</h1>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Customer Information</legend>
		<form:form action="addCustomer" method="POST" modelAttribute="customer">
			<div>
				<label>Customer Name</label><br>
				<form:input type="text" id="customerName" path="customerName" /><br>
				<form:errors class="text-danger" path="customerName" /><br>
			</div>
			<div>
				<label>Customer Email</label><br>
				<form:input type="text" id="customerEmail" path="customerEmail" /><br>
				<form:errors class="text-danger" path="customerEmail" /><br>
			</div>	
			<div>
				<label>PhoneNumber</label><br>
				<form:input type="text" id="phoneNumber" path="phoneNumber" /><br>
				<form:errors class="text-danger" path="phoneNumber" /><br>
			</div>	
			<div>
				<label>Customer Address</label><br>
				<form:input type="text" id="customerAddress" path="customerAddress" /><br>
				<form:errors class="text-danger" path="customerAddress" /><br>
			</div>	
			<div>
				<label>Sales</label><br>
				<form:input type="text" id="sales" path="sales.saleId" /><br>
				<form:errors class="text-danger" path="sales.saleId" /><br>
			</div>	
			
			<div>		
				<input type="submit" name="submit" value="Submit" />
			</div>
		</form:form>
	</fieldset>
</div>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Customer Table</legend>
		<table class="table table-striped">
			<tr>
				<td class="font-weight-bold">Customer ID</td>
				<td class="font-weight-bold">CustomerName</td>
				<td class="font-weight-bold">CustomerEmail</td>
				<td class="font-weight-bold">PhoneNumber</td>
				<td class="font-weight-bold">CustomerAddress</td>
				<td class="font-weight-bold">Sales</td>
				<td></td>
			</tr>
			<c:forEach items="${custom}" var="ct">
				<tr>
					<td>${ct.customerId }</td>
					<td>${ct.customerName }</td>
					<td>${ct.customerEmail }</td>
					<td>${ct.phoneNumber }</td>
					<td>${ct.customerAddress}</td>
					<td>${ct.sales.saleId}</td>
					<td>
					<a href="${pageContext.request.contextPath}/deleteCustomer?id=${ct.customerId}">Remove Customer</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</div>
</body>
</html>