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
<% 
		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
	
	%>
	
	<h1>Hello <%=session.getAttribute("username")%></h1>
	<%
	try
    {
		Class.forName("com.mysql.cj.jdbc.Driver");
      //registering type4 driver of oracle
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputinglab","root","");   
		Statement stmt=con.createStatement();
		 String q1="select * from malliditarunreddy_111915067_detail where employee_id_number='"+session.getAttribute("id")+"';";
		  System.out.println(q1);
		        ResultSet rs=stmt.executeQuery(q1);
		        while(rs.next()){%>
		        	<p>
		        	<%=rs.getString(2)%>
		        	</p>
		        	
		        	<%}
		      
		     con.close();
    }
   catch(Exception e){ 
      System.out.println(e);
   }%>
	<form action="logout" method="post"><input type="submit"/></form>
</body>
</html>