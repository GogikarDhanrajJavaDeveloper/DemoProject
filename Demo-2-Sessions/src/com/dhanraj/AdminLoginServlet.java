package com.dhanraj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		HttpSession ses = req.getSession(false);
		
		AdminDao id = new AdminDao();
		
		if(id.validate(req)) {
			String fname = (String)ses.getAttribute("fName");
			Cookie ck = new Cookie("fname", fname);
			pw.println("Welcome Admin: "+fname+"<br>");
			res.addCookie(ck);
			RequestDispatcher rd1 = req.getRequestDispatcher("link1.html");
			rd1.include(req,res);
		}else {
			pw.println("Please enter valid input details...");
			RequestDispatcher rd2 = req.getRequestDispatcher("home.html");
			rd2.include(req,res);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doGet(req,res);
	}
}
