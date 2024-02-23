package com.AccountactServlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.AccountantDao;
import com.databasedao.DataBaseConnection;
import com.details.AccountantDetails;

@WebServlet("/accountant-registration")
public class AccountantRegistrationServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		long phonenumber=Long.parseLong(req.getParameter("phonenumber"));
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		
		
		
			
			AccountantDetails AD=new AccountantDetails(firstname, lastname, email, phonenumber, address, password, gender);
			int status=AccountantDao.save(AD);
			if(status > 0)
			{
				res.sendRedirect("AdminHomePage.html");
				
			}
			else
			{
				res.sendRedirect("AccountantRegistrationPage.html");
				out.println("datanot connected");
			}
			
		
	}

}

