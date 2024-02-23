package com.StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.AccountantDao;
import com.databasedao.DataBaseConnection;
import com.databasedao.StudentDao;
import com.details.AccountantDetails;
import com.details.StudentDetails;
@WebServlet("/ViewStudents")
public class ViewStudentServlet extends HttpServlet {
	 public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	        PrintWriter out = res.getWriter();
	        res.setContentType("text/html");

	        
	        List<StudentDetails> list = StudentDao.getAllRecords();

	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>View Students</title>");
	        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"ViewAccountantStyle.css\">"); // Link to external CSS file
	        out.println("</head>");
	        out.println("<body>");

	        // Navbar at the top right
	        out.println("<nav class=\"navbar\">");
	        out.println("<a href=\"AccountantHomePage.html\">Home</a>");
	        out.println("</nav>");

	        out.println("<div class='container'>");
	        out.print("<h1>View Students</h1>");
	        out.println("<table>");
	        out.print("<tr><th>Roll NO</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>CourseFee</th><th>Paid</th><th>Due</th><th>Address</th><th>Phone Number</th></tr>");
	        for (StudentDetails r : list) {
	            out.println("<tr>");
	            out.println("<td>" + r.getRollno() + "</td>");
	            out.println("<td>" + r.getName() + "</td>");
	            out.println("<td>" + r.getEmail() + "</td>");
	            out.println("<td>" + r.getSex() + "</td>");
	            out.println("<td>" + r.getCourse() + "</td>");
	            out.println("<td>" + r.getCoursefee() + "</td>");
	            out.println("<td>" + r.getPaid() + "</td>");
	            out.println("<td>" + r.getDue() + "</td>");
	            out.println("<td>" + r.getAddress() + "</td>");
	            out.println("<td>" + r.getPhonenumber() + "</td>");
	           
//	            out.println("<td><a href='editScreen?email=" + r.getEmail() + "'>Edit</a></td>");
//	            out.println("<td><a href='deleteurl?email=" + r.getEmail() + "'>Delete</a></td>");
	            out.println("</tr>");
	        }
	        out.println("</table>");
	        out.println("</div>");

	        out.println("</body>");
	        out.println("</html>");
	    }

}
