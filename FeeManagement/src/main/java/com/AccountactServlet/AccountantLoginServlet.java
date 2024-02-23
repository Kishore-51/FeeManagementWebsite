package com.AccountactServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.AccountantDao;
@WebServlet("/accountant-login")
public class AccountantLoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String email=req.getParameter("emailid");
		String password=req.getParameter("password");
		
		
		boolean status=AccountantDao.validate(email, password);
		if(status == true)
		{
			res.sendRedirect("AccountantHomePage.html");
		}
		else
		{
			req.setAttribute("error", "Incorrect username or password. Try again.");
            req.getRequestDispatcher("AccountantLoginPage.jsp").forward(req, res);
			//res.sendRedirect("AccountantLoginPage.jsp");
		}
		
	}

}
