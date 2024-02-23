package com.StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.StudentDao;
import com.details.StudentDetails;
@WebServlet("/ViewDues")
public class ViewDuesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

     
        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Students Dues</title>");
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
        out.println("<form action=\"ViewDues\" method=\"get\">");
        out.println("<input type=\"text\" placeholder=\"Search Dues\" name=\"due\">");
        out.println("<button type=\"submit\">Search</button>");
        out.println("</form>");
        out.println("</div>");
        
        // Retrieve due parameter from request
        int due = Integer.parseInt(req.getParameter("due"));
        List<StudentDetails> list  = StudentDao.getAllRecordsByDue(due);
        


        out.println("<div class='container'>");
        out.println("<h1>Search Students</h1>");
        out.println("<table>");
        out.println("<tr><th>Rollno</th><th>Name</th><th>Course</th><th>Coursefee</th><th>Paid</th><th>Phonenumber</th><th>Due</th></tr>");
        
        // Display student details
        
        for(StudentDetails student:list)
        {
        out.println("<tr>");
        out.println("<td>" + student.getRollno() + "</td>");
        out.println("<td>" + student.getName() + "</td>");
        
        out.println("<td>" + student.getCourse() + "</td>");
        out.println("<td>" + student.getCoursefee() + "</td>");
        out.println("<td>" + student.getPaid() + "</td>");
        out.println("<td>" + student.getPhonenumber() + "</td>");
        out.println("<td>" + student.getDue() + "</td>");
        
        out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
   }
}
