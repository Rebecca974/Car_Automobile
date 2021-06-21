<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container bg-light">
<h1>Sign Up </h1>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">SignUp Form</legend>
		<form:form action="signup/addSignUp" method="POST" modelAttribute="signup">
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
				<label>Repeat Password</label><br>
				<form:input type="password" id="pswRepeat" path="pswRepeat" /><br>
				<form:errors class="text" path="pswRepeat" /><br>
			</div>	
			<label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
           </label>
             <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
             
             <div class="clearfix">
           <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign Up</button>
            </div>

		</form:form>
	</fieldset>
</div>



</body>
</html>