package com.dhanraj;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import java.sql.*;
public class ReteriveServiceDao {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ArrayList<ServiceBean> sbean = new ArrayList<ServiceBean>();
	public boolean z;
	
	public ArrayList<ServiceBean> getOneRecord(HttpServletRequest req) {
		
		ServiceBean sb = new ServiceBean();
		try {
			con = DBConnection.getCon();
			ps = con.prepareStatement("select * from services22");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				sb.setSerno(rs.getString(1));
				sb.setSname(rs.getString(2));
				sb.setTo(rs.getString(3));
				sb.setFrom(rs.getString(4));
				sb.setDepature(rs.getString(5));
				sb.setArrival(rs.getString(6));
				sb.setAvailibity(rs.getString(7));
				
				sbean.add(sb);
			}
		}catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return sbean;
	}
}
