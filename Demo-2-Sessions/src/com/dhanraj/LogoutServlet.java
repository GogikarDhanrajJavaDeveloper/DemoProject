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

public class LogoutServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		HttpSession ses = req.getSession();
		Cookie ck[] = req.getCookies();
		ck[0].setValue("");
		ck[0].setMaxAge(0);
		
		ses.invalidate();
		pw.println("Logout Successfully...");
		RequestDispatcher rd = req.getRequestDispatcher("home.html");
		rd.include(req,res);
		
	}
}
