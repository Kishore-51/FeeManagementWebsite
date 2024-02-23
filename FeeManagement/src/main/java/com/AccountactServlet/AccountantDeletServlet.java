package com.AccountactServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasedao.AccountantDao;
@WebServlet("/deleteurl")
public class AccountantDeletServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		res.setContentType("html/text");
		String email=req.getParameter("email");
		int status=AccountantDao.delete(email);
		if(status>0)
		{
			res.sendRedirect("ViewAccountant");
		}
		else
		{
			out.println("<h1>not deleted</h1>");
		}
		
	}

}
