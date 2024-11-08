package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateQuerry {  
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
		
		Statement stmt = coon.createStatement();
		
		int i = stmt.executeUpdate("update marksheet set name = 'raju' where sno  = 6 ;");
		
		System.out.println("Upadate marksheet successufully" + i);
		
		
		
	}

}
