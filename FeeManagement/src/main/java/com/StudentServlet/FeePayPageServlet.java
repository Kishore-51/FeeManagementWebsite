package com.StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.StudentDao;
import com.details.StudentDetails;
@WebServlet("/FeePayPage")
public class FeePayPageServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

     
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Students</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"ViewAccountantStyle.css\">"); // Link to external CSS file
        out.println("</head>");
        out.println("<body>");

        // Navbar at the top right
        out.println("<nav class=\"navbar\">");
        out.println("<a href=\"AccountantHomePage.html\">Home</a>");
        out.println("<a href=\"ViewStudents\">View Students</a>"); // Add View Students link
        out.println("</nav>");

        // Search bar at the top right
        out.println("<div class=\"search-bar\">");
        out.println("<form action=\"FeePayPage\" method=\"get\">");
        out.println("<input type=\"text\" placeholder=\"Search by Roll No\" name=\"rollno\">");
        out.println("<button type=\"submit\">Search</button>");
        out.println("</form>");
        out.println("</div>");
        
        // Retrieve rollno parameter from request
        int rollno = Integer.parseInt(req.getParameter("rollno"));

        // Retrieve student details from database based on rollno
        StudentDetails student = StudentDao.getRecordByRollno(rollno);


        
        
        out.println("<form action='FeePay?rollno="+rollno+" ' method='post'>");
		out.println("<table  align='center'>");
		out.println("<tr>");
		out.println("<td>RollNo</td>");
		out.println("<td> "+student.getRollno()+ " </td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Name</td>");
		out.println("<td> "+student.getName()+ "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Course</td>");
		out.println("<td> "+student.getCourse()+ "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>CourseFee</td>");
		out.println("<td>"+student.getCoursefee()+ "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Due</td>");
		out.println("<td>"+student.getDue()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Fee Paying</td>");
		out.println("<td><input type='number' name ='feepay' ></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='Pay'></td>");
		out.println("<td><input type='reset' value='Clear'></td>");
		out.println("</tr>");


		
		out.println("</table>");
		out.println("</form>");
        
        
       

        out.println("</body>");
        out.println("</html>");
    }

}
