<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My app | reports</title>
</head>
<body>
<style>
table,tr,td{
border:1px solid black;
}
form{
margin:30px;
display:grid;
grid-template-columns:1fr 1fr;
}
#update{
	 grid-column-end: span 2;
}
</style>
<% 
		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
	
	%>
	
	<h1>Hello </h1><form action="logout" method="post"><input type="submit" value="logout"/></form>
			        <Table>
	<%
	try
    {
		Class.forName("com.mysql.cj.jdbc.Driver");
      //registering type4 driver of oracle
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputinglab","root","");   
		Statement stmt=con.createStatement();
		 String q1="select * from malliditarunreddy_111915067_detail;";
		  System.out.println(q1);
		        ResultSet rs=stmt.executeQuery(q1);
		        while(rs.next()){%>

		        	<tr>
		        	<td><%=rs.getInt(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td>
		        	</tr>

		        	<%}
		      
		     con.close();
    }
   catch(Exception e){ 
      System.out.println(e);
   }%>
   		       </Table>
   		       
		        <Table>
		        <thead>
		        	<th>Employee id</th>
		        	<th>Job Role</th>
		        	<th>Monthly Salary</th>
		        	<th>Yearly Salary</th>
		        	<th>Total Salary</th>
		        </thead>>
	<%
	try
    {
		Class.forName("com.mysql.cj.jdbc.Driver");
      //registering type4 driver of oracle
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputinglab","root","");   
		Statement stmt=con.createStatement();
		 String q1="select * from malliditarunreddy_111915067_salary;";
		  System.out.println(q1);
		        ResultSet rs=stmt.executeQuery(q1);
		        while(rs.next()){%>

		        	<tr>
		        	<td><%=rs.getInt(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=Integer.parseInt(rs.getString(3))*12+Integer.parseInt(rs.getString(4))%></td>
		        	</tr>

		        	<%}
		      
		     con.close();
    }
   catch(Exception e){ 
      System.out.println(e);
   }%>
   		       </Table>
	
	<form action="update" method="POST">
    employee id:<input type="text" name="employee_id_number" /><br/>
    firstname<input type="text" name="first_name" /><br/>
    lastname<input type="text" name="last_name" /><br/>
    dob<input type="text" name="dob" /><br/>
    contactnmumber: <input type="text" name="contact_number" /><br/>
    jobrole<input type="text" name="job_role" /><br/>
    monthly salary<input type="text" name="monthly_salary" /><br/>
    yearlybonus<input type="text" name="yearly_bonus" /><br/>
    <input type="submit" value="update" id = 'update'>
	
</body>
</html>