<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.automobile.model.Signup" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
Signup s =(Signup)request.getAttribute("signup");
%>
</head>
<body>
<h3>Email: <%= s.getEmail() %>
<br>
Password: <%= s.getPassword() %>
<br>
Repeat Password: <%= s.getPswRepeat() %>
<br>
</h3>
</body>
</html>