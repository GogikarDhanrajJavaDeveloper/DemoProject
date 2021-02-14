package com.dhanraj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomeServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
	
		res.setContentType("text/html");
		String sub = req.getParameter("sub");
		HttpSession ses = req.getSession(true);
		ses.setAttribute("sub", sub);
		
		if(sub.equals("AdminLogin")) {
			RequestDispatcher rd1 = req.getRequestDispatcher("AdminLogin.html");
			rd1.forward(req,res);
		}else {
			RequestDispatcher rd2 = req.getRequestDispatcher("HrLogin.html");
			rd2.forward(req, res);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doGet(req,res);
	}
}
