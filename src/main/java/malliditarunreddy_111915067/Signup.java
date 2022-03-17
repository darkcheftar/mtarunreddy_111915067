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
		
	   
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	   try
	      {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        //registering type4 driver of oracle
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");  
			Statement stmt=con.createStatement();
			  String q1="select id,password from login where uname='"+username+"';";
			  System.out.println(q1);
			        ResultSet rs=stmt.executeQuery(q1);
			        if(rs.next()){
			        	if(password.equals(rs.getString(2))) {
			        		HttpSession session = req.getSession();
			        		session.setAttribute("username", username);
			        		session.setAttribute("id", rs.getInt(1));
			        		res.sendRedirect("shop.jsp");
			        	}else {
			        		res.sendRedirect("login.jsp");
			        	}
			        }
			       else
			       {
			    	   res.sendRedirect("login.jsp");
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
