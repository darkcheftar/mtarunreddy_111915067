package malliditarunreddy_111915067;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/signup")
public class Signup extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
	   
		String employee_id_number = req.getParameter("employee_id_number");
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String dob = req.getParameter("dob");
		String contact_number = req.getParameter("contact_number");
	   try
	      {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	        //registering type4 driver of oracle
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputinglab","root","");  
			Statement stmt=con.createStatement();
			  String q1="INSERT INTO `malliditarunreddy_111915067_detail` (`employee_id_number`, `first_name`, `last_name`, `dob`, `contact_number`) VALUES ('0', '"+first_name+"', '"+last_name+"', '"+dob+"', '"+contact_number+"');";
			  
			        int rs=stmt.executeUpdate(q1);
			       
			        if(rs>0)
			        {
			           System.out.println("Insert success");
			           res.sendRedirect("login.jsp");  
			       }
			       else
			       {
			         System.out.println("Insert unsuccess");   
			     }
			        con.close();
	      }
	     catch(Exception e){ 
	        System.out.println(e);
	     }
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.sendRedirect("login.jsp");
	}
	
}
