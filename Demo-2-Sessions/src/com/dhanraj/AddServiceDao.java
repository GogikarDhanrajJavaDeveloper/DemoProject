package com.dhanraj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddServiceDao  extends HttpServlet{

	private Connection con=null ;
	private PreparedStatement ps=null;
	public boolean k;
	
	public boolean insertOneRecord(HttpServletRequest req) {
		
		String sno = req.getParameter("sno");
		String sname = req.getParameter("sname");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String departure = req.getParameter("dep");
		String arrival = req.getParameter("arr");
		String availibity = req.getParameter("avl");
		
		try {
		con = DBConnection.getCon();
		ps = con.prepareStatement("insert into services22 values(?,?,?,?,?,?)");
		ps.setString(1, sno);
		ps.setString(2,sname);
		ps.setString(3, from);
		ps.setString(4,to);
		ps.setString(5,departure);
		ps.setString(6, arrival);
		ps.setString(7,availibity);
		
		int z = ps.executeUpdate();
		
		if(z>0) {
			k = true;
		}
		
		}catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return k;
	}
	
}
