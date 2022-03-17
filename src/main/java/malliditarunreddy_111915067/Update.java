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

@WebServlet("/update")
public class Update extends HttpServlet{
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
		String job_role = req.getParameter("job_role");
		String monthly_salary = req.getParameter("monthly_salary");
		String yearly_bonus = req.getParameter("yearly_bonus");
	   try
	      {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        //registering type4 driver of oracle
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputinglab","root","");  
			Statement stmt=con.createStatement();
			String q1 = "UPDATE `malliditarunreddy_111915067_detail` SET `employee_id_number`='"+employee_id_number+"',`first_name`='"+first_name+"',`last_name`='"+last_name+"',`dob`='"+dob+"',`contact_number`='"+contact_number+"' WHERE employee_id_number = '"+employee_id_number+"';";
			String q2 = "SELECT * FROM `malliditarunreddy_111915067_salary` WHERE `employee_id_number`= '"+employee_id_number+"';";
			ResultSet rs2 = stmt.executeQuery(q2);
			String q3;
			if(rs2.next()) {
				q3="UPDATE `malliditarunreddy_111915067_salary` SET `job_role`='"+job_role+"',`montly_salary`='"+monthly_salary+"',`yearly_bonus`='"+yearly_bonus+"' WHERE employee_id_number='"+employee_id_number+"';";
				
			}else {
				q3 = "INSERT INTO `malliditarunreddy_111915067_salary`(`employee_id_number`, `job_role`, `montly_salary`, `yearly_bonus`) VALUES ('"+employee_id_number+"','"+job_role+"','"+monthly_salary+"','"+yearly_bonus+"');";
				
			}
			System.out.println(q3);
			int rs3 = stmt.executeUpdate(q3);
			int rs=stmt.executeUpdate(q1);
			        if(rs>0 && rs3>0){
			        	res.sendRedirect("report.jsp");
			        }
			       else
			       {
			    	   res.sendRedirect("error.jsp");
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
