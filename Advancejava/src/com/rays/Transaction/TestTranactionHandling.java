package com.rays.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTranactionHandling {
	
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");	
		
//		Step 1
		conn.setAutoCommit(false);
		
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into st_user values(7, 'Aman', 'gupta', 'aman@gmail.com', 'aman123', 'karnataka', '2004-04-08')");
			
		 i = stmt.executeUpdate("insert into st_user values , 'Aman', 'gupta', 'aman@gmail.com', 'aman123', 'karnataka', '2004-04-08')");
		
		 i = stmt.executeUpdate("insert into st_user values(7, 'Aman', 'gupta', 'aman@gmail.com', 'aman123', 'karnataka', '2004-04-08')");
		
		 i = stmt.executeUpdate("insert into st_user values(7, 'Aman', 'gupta', 'aman@gmail.com', 'aman123', 'karnataka', '2004-04-08')");
		
//		Step  2
		
		conn.commit();
		
		} catch (Exception e) {
			
//			Step 3
			
			conn.rollback();
			
			System.out.println(e.getMessage());
			
			
		}
		
		
		
		
	}

}
