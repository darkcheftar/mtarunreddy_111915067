<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My App | Login</title>
</head>
<body>
<style>
body{
text-align:center;}
form{
position:relative;
margin:0 auto;
width:500px;
display:grid;
grid-template-columns:1fr 1fr;
}
#login{
	grid-column-end:span 2;
}
</style>
Login
<form action="login" method="post">
employeeid<input type="Text" name="username"/>
password<input type="password" name="password"/>
<input id="login" type="submit" value="Login" />
</form>
</body>
</html>
