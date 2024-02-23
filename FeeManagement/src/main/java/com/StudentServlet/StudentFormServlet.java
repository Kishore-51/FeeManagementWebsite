package com.StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.DataBaseConnection;
import com.databasedao.StudentDao;
import com.details.StudentDetails;
@WebServlet("/Studentdetails")
public class StudentFormServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String sex = req.getParameter("sex");
		String course = req.getParameter("course");
		 int coursefee =Integer.parseInt(req.getParameter("coursefee"));
		 int paid =Integer.parseInt(req.getParameter("paid"));
//		 int due =Integer.parseInt(req.getParameter("due"));
		 String address = req.getParameter("address");
		 long phonenumber = Long.parseLong(req.getParameter("phonenumber"));
		 
		 StudentDetails SD=new StudentDetails(name,email,sex,course,coursefee,paid,address,phonenumber);
		 int status=StudentDao.save(SD);
		 if(status > 0)
		 {
			 res.sendRedirect("AccountantHomePage.html");
		 }
		 else
		 {
			 res.sendRedirect("StudentFormPage.html");
		 }
		 
			
		
		
	}
	

}
