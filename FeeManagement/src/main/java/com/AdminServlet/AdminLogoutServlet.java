package com.AdminServlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogout")
public class AdminLogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		HttpSession session=req.getSession();
		session.invalidate();
		res.sendRedirect("AdminLoginPage.jsp");
	}

}
