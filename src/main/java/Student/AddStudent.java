package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<h1><center>Registration Succesfully</center> <h1>");
		 
		 String name =request.getParameter("name");
		 String rollnumber= request.getParameter("rollnumber");
		 String grade = request.getParameter("grade");
		 
		 
		 Connection connection = null;
		 Statement statemnet = null;
		 ResultSet resultset = null;
		 String url = "jdbc:mysql://localhost:3306/testdb";
		 
		   try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Root@123");
			   statemnet = connection.createStatement();
			   String insert = "insert into Stud1 values(?,?,?)";
			   
			  statemnet.executeUpdate(insert);
			  response.sendRedirect("display_student.jsp");
			  connection.close();
			  
		   }catch (Exception e) {
			   System.out.println("Connection not created Succesfully..");
			   System.out.println("e.getMessage");
		   }	}

}
