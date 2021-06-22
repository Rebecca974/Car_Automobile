<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container bg-light">
<h1>Payment</h1>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Payment Information</legend>
		<form:form action="addPayment" method="POST" modelAttribute="payment">
			<div>
				<label>Customer Name</label><br>
				<form:input type="text" id="customerName" path="customerName" /><br>
				<form:errors class="text-danger" path="customerName" /><br>
			</div>
			<div>
				<label>Car Name</label><br>
				<form:input type="text" id="carName" path="carName" /><br>
				<form:errors class="text-danger" path="carName" /><br>
			</div>	
			<div>
				<label>Sales Id</label><br>
				<form:input type="text" id="sale" path="saleId" /><br>
				<form:errors class="text-danger" path="saleId" /><br>
			</div>	
			
			<div>
				<label>PaymentMethod</label><br>
				<form:input type="text" id="paymentMethod" path="paymentMethod" /><br>
				<form:errors class="text-danger" path="paymentMethod" /><br>
			</div>	
			<div>
				<label>Tax</label><br>
				<form:input type="text" id="tax" path="tax" /><br>
				<form:errors class="text-danger" path="tax" /><br>
			</div>	
			<div>
				<label>Price</label><br>
				<form:input type="text" id="tax" path="price" /><br>
				<form:errors class="text-danger" path="price" /><br>
			</div>	
			<div>		
				<input type="submit" name="submit" value="Submit" />
			</div>
		</form:form>
	</fieldset>
</div>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Payment Table</legend>
		<table class="table table-striped">
			<tr>
				<td class="font-weight-bold">PaymentID</td>
				<td class="font-weight-bold">CustomerName</td>
				<td class="font-weight-bold">CarName</td>
				<td class="font-weight-bold">SaleId</td>
				<td class="font-weight-bold">PaymentMethod</td>
				<td class="font-weight-bold">Tax</td>
				<td class="font-weight-bold">Price</td>
				<td class="font-weight-bold">TotalPrice</td>
				
				<td></td>
			</tr>
			<c:forEach items="${paym}" var="pa">
				<tr>
					<td>${pa.paymentId }</td>
					<td>${pa.customerName }</td>
					<td>${pa.carName }</td>
					<td>${pa.saleId}</td>
					<td>${pa.paymentMethod }</td>
					<td>${pa.tax}</td>
					<td>${pa.price}</td>
					<td>${pa.totalPrice}</td>
					
					<td><a href="${pageContext.request.contextPath}/deletePayment?id=${pa.paymentId}">Remove Payment</a></td>
				</tr>
			</c:forEach>
			</table>
			</fieldset>
			
			<a href="response/">Thank you</a>
</div>
</body>
</html>