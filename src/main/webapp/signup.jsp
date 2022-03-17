<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My App | Signup</title>
</head>
<body>
<style>
form{
position:relative;
margin:0 auto;
width:500px;
display:grid;
grid-template-columns:1fr 1fr;
}
#signup{
	grid-column-end:span 2;
}
</style>
	<form action="signup" method="POST">
    employee id number<input type="text" name="employee_id_number" />
    firstname<input type="text" name="first_name" />
    lastname<input type="text" name="last_name" />
    dob<input type="text" name="dob" />
    contactnumber<input type="text" name="contact_number" />
    <input type="submit" value="signup" id="signup">
</form>
</body>
</html>