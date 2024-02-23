package com.AccountactServlet;

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
import com.details.AccountantDetails;

@WebServlet("/ViewAccountant")
public class ViewAccountantServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        Connection con = null;
        con = DataBaseConnection.getcon();
        List<AccountantDetails> list = AccountantDao.getAllRecords();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Accountants</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"ViewAccountantStyle.css\">"); // Link to external CSS file
        out.println("</head>");
        out.println("<body>");

        // Navbar at the top right
        out.println("<nav class=\"navbar\">");
        out.println("<a href=\"AdminHomePage.html\">Home</a>");
        out.println("</nav>");

        out.println("<div class='container'>");
        out.print("<h1>View Accountants</h1>");
        out.println("<table>");
        out.print("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Password</th><th>Address</th><th>Phone Number</th><th>Gender</th><th>Delete</th></tr>");
        for (AccountantDetails r : list) {
            out.println("<tr>");
            out.println("<td>" + r.getFirstname() + "</td>");
            out.println("<td>" + r.getLastname() + "</td>");
            out.println("<td>" + r.getEmail() + "</td>");
            out.println("<td>" + r.getPassword() + "</td>");
            out.println("<td>" + r.getAddress() + "</td>");
            out.println("<td>" + r.getPhonenumber() + "</td>");
            out.println("<td>" + r.getGender() + "</td>");
			/*
			 * out.println("<td><a href='editScreen?email=" + r.getEmail() +
			 * "'>Edit</a></td>");
			 */
            out.println("<td><a href='deleteurl?email=" + r.getEmail() + "'>Delete</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
