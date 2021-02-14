package com.dhanraj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReteriveServiceServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		HttpSession ses = req.getSession();
		ArrayList<ServiceBean> sbean = new ArrayList<ServiceBean>();
		//ServiceBean sb = null;
		
		if(ses.isNew()) {
			RequestDispatcher rd1 = req.getRequestDispatcher("home.html");
			rd1.include(req, res);
		}else {
			//String fname= (String)ses.getAttribute("fname");
			Cookie ck[] = req.getCookies();
			String fname = ck[0].getValue();
			pw.println("<br>Welcome Admin:: "+fname+"<br>");
			RequestDispatcher rd2 = req.getRequestDispatcher("link1.html");
			rd2.include(req, res);
			ReteriveServiceDao id = new ReteriveServiceDao();
			sbean = id.getOneRecord(req);
			
//			if(sbean.size()!=0) {
//				sbean.forEach(k->{
//					//ServiceBean serv = (ServiceBean)k;
////					pw.println("<br>servicenumber: "+serv.getSerno()+"<br>servicename: "+serv.getSname()+"<br>To: "+serv.getTo()+"<br>From: "+serv.getFrom()+
////							"<br>Departure: "+serv.getDepature()+"<br>Arrival: "+serv.getArrival()+"<br>Availibility: "+serv.getAvailibity());
//					//pw.println(k);
//					System.out.println(k);
//				});
			while(sbean.size()!=0) {
				sbean.forEach(k->{
					pw.println(k);
				});
			}
		}	
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doGet(req,res);
	}
	
}
