<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container bg-light">
<h1>Car Selection</h1>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Add Car</legend>
		<form:form action="addCar" method="POST" modelAttribute="car">
			<div>
				<label>CarName</label><br>
				<form:input type="text" id="carName" path="carName" /><br>
				<form:errors class="text-danger" path="carName" /><br>
			</div>
			<div>
				<label>Color</label><br>
				<form:input type="text" id="color" path="color" /><br>
				<form:errors class="text-danger" path="color" /><br>
			</div>	
			<div>
				<label>Price</label><br>
				<form:input type="text" id="price" path="price" /><br>
				<form:errors class="text-danger" path="price" /><br>
			</div>	
			
			<div>		
				<input type="submit" name="submit" value="AddCar" />
			</div>
		</form:form>
	</fieldset>
</div>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">List of Car</legend>
		<table class="table table-striped">
			<tr>
				<td class="font-weight-bold">Car ID</td>
				<td class="font-weight-bold">CarName</td>
				<td class="font-weight-bold">Color</td>
				<td class="font-weight-bold">Price</td>
				<td></td>
			</tr>
			<c:forEach items="${cas}" var="cs">
				<tr>
					<td>${cs.carId }</td>
					<td>${cs.carName }</td>
					<td>${cs.color }</td>
					<td>${cs.price }</td>
					<td><a href="${pageContext.request.contextPath}/deleteCar?id=${cs.carId}">Remove Car</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</div>
</body>
</html>