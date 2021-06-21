<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Confirm Your Info</h1>
	<div class="container">
		<form action="Info_confirm" method="POST">
			<div class="sub_field">
				<label>User Name</label> 
				<input type="text" id="login" name="username" value=${userName}/>
			</div>
			<div class="sub_field">
				<label>Email</label> 
				<input type="text" id="email" name="email" value=${email} />
			</div>
			<div class="sub_field">
				<label>Password</label>
				 <input type="password" id="pass" name="password" value=${password} />
			</div>
			
			<div class="btn">
				<input type="submit" name="submit" value="Submit Info" />
			</div>
		</form>
	</div>
</body>
</html>