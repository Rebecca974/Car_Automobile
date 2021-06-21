<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>




<body class="container bg-light">
<h1>Login </h1>
${error}
${success}
<div>
	<fieldset class="border border-dark p-1">
		<legend class="w-auto">Login Form</legend>
		<form:form action="addLogin" method="POST" modelAttribute="login">
			<div>
				<label>UserName</label><br>
				<form:input type="text" id="userName" path="userName" /><br>
				<form:errors class="text" path="userName" /><br>
			</div>
			<div>
				<label>Email</label><br>
				<form:input type="email" id="email" path="email" /><br>
				<form:errors class="text" path="email" /><br>
			</div>	
			<div>
				<label>Password</label><br>
				<form:input type="password" id="pass" path="password" /><br>
				<form:errors class="text" path="password" /><br>
			</div>	
			<div>		
				<input type="submit" name="submit" value="Login" />
			</div>
		</form:form>
	</fieldset>
</div>

</body>
</html>

