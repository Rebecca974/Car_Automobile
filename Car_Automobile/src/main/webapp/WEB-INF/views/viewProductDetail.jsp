<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="global">
		<h4>The product has been saved.</h4>
		<h5>Details:</h5>
		Product Name: ${product.name}<br>
		Description: ${product.description}<br>
		<p>Following files are uploaded successfully.</p>
		
		<ol>
			<c:forEach items="${product.images}" var="image">
				<li>
					${image.originalFilename}
					<img width="100" src="${pageContext.request.contextPath}/fileuploads/${image.originalFilename}">
				</li>
			</c:forEach>
		</ol>
	<a href= "paymentform">Payment Information</a>
	</div>
	<div>
	 	
	 </div>
</body>
</html>