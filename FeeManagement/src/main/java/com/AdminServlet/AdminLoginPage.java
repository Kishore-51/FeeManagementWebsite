package com.AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//
//@WebServlet("/admin-login")
//public class AdminLoginPage extends HttpServlet {
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
//	{
//		PrintWriter out=res.getWriter();
//		res.setContentType("text/html");
//		String username=req.getParameter("username");
//		String password=req.getParameter("password");
//		if(username.equals("adminlogin")&&password.equals("admin123"))
//		{
//			res.sendRedirect("AdminHomePage.html");
//			
//		}else{
//			HttpSession session=req.getSession();
//			session.setAttribute("admin","1");
//			req.getRequestDispatcher("AdminLoginPage.html").include(req, res);
//			
//		}
//		out.close();
//		
//	}
//
//}
@WebServlet("/admin-login")
public class AdminLoginPage extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        
        if(username.equals("adminlogin") && password.equals("admin123")) {
            res.sendRedirect("AdminHomePage.html");
        } else {
            req.setAttribute("error", "Incorrect username or password. Try again.");
            req.getRequestDispatcher("AdminLoginPage.jsp").forward(req, res);
        }
        out.close();
    }
}

