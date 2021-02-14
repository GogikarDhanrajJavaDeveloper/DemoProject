package com.dhanraj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminDao {

	public boolean z;
	private Connection con = null;
	private PreparedStatement ps = null;
	public boolean validate(HttpServletRequest req) {
		
		String name = req.getParameter("uname");
		String password = req.getParameter("pass");
		HttpSession ses = req.getSession(false);
		String sub = (String) ses.getAttribute("sub");
		try {
		con = DBConnection.getCon();	
		if(sub.equals("AdminLogin")) {
		
		ps = con.prepareStatement("select uname, password from busadmin22 where uname=? and password=?");
		ps.setString(1, name);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			z = true;
			ses.setAttribute("fName", rs.getString(1));
		}
		}else {
			ps = con.prepareStatement("select uname, password from userreg22 where uname=? and password=?");
			ps.setString(1,name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				z = true;
				ses.setAttribute("fName", rs.getString(1));
			}
		}
	}catch(SQLException sqle) {
		System.out.println(sqle.getMessage());
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
		return z;
	}
}
