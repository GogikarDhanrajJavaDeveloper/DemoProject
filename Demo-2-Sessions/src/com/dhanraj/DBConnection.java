package com.dhanraj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con; 
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "dhanraj2");
			
		}catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getCon() {
		return con;
	}
}
