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


public class AddServiceServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		HttpSession ses = req.getSession();
		
		if(ses.isNew()) {
			//newly created session 
			RequestDispatcher rd1 = req.getRequestDispatcher("home.html");
			rd1.include(req, res);
		}else {
			//already existed session.
			Cookie ck[] = req.getCookies();
			String fname = ck[0].getValue();
			pw.println("<br>Welcome Admin:: "+fname+"<br>");
			RequestDispatcher rd2 = req.getRequestDispatcher("link1.html");
			rd2.include(req, res);
			AddServiceDao id = new AddServiceDao();
			if(id.insertOneRecord(req)) {
				pw.println("Record Inserted Successfully...");
			}else {
				pw.println("failure in insertion of record...");
			}
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doGet(req,res);
	}
}
