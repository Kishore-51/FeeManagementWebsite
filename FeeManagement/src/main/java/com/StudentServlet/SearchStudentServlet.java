package com.StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.StudentDao;
import com.details.StudentDetails;

@WebServlet("/SerachStudentPage")
public class SearchStudentServlet extends HttpServlet {

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
        out.println("<form action=\"SerachStudentPage\" method=\"get\">");
        out.println("<input type=\"text\" placeholder=\"Search by Roll No\" name=\"rollno\">");
        out.println("<button type=\"submit\">Search</button>");
        out.println("</form>");
        out.println("</div>");
        
        // Retrieve rollno parameter from request
        int rollno = Integer.parseInt(req.getParameter("rollno"));

        // Retrieve student details from database based on rollno
        StudentDetails student = StudentDao.getRecordByRollno(rollno);


        out.println("<div class='container'>");
        out.println("<h1>Search Students</h1>");
        out.println("<table>");
        out.println("<tr><th>Roll NO</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>CourseFee</th><th>Paid</th><th>Due</th><th>Address</th><th>Phone Number</th></tr>");
        
        // Display student details
        out.println("<tr>");
        out.println("<td>" + student.getRollno() + "</td>");
        out.println("<td>" + student.getName() + "</td>");
        out.println("<td>" + student.getEmail() + "</td>");
        out.println("<td>" + student.getSex() + "</td>");
        out.println("<td>" + student.getCourse() + "</td>");
        out.println("<td>" + student.getCoursefee() + "</td>");
        out.println("<td>" + student.getPaid() + "</td>");
        out.println("<td>" + student.getDue() + "</td>");
        out.println("<td>" + student.getAddress() + "</td>");
        out.println("<td>" + student.getPhonenumber() + "</td>");
        out.println("</tr>");
        
        out.println("</table>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
