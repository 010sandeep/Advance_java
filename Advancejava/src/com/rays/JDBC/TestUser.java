package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUser {
	
	public static void main(String[] args) throws Exception  {
		
//		adduser();
//		delete();
//		update();
		search();
		
	}

	private static void adduser() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into st_user values(1, 'sandeep','gurjar', 'sandeep@gmail.com', 'pass123','indore', '2001-02-02')");
		
		System.out.println("successfully");
		
	}
	
private static void delete() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from st_user where id = 1;");
		
		System.out.println("successfully");
		
	}

private static void update() throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
	Statement stmt = conn.createStatement();
	
	int i = stmt.executeUpdate("update st_user set firstname = 'mohit' where id = 1;");
	
	System.out.println("successfully");
	
}
private static void search() throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
	Statement stmt = conn.createStatement();
	
	ResultSet sr = stmt.executeQuery("select * from st_user");
	
	System.out.println("successfully");
	
	while(sr.next()) {
		
		System.out.print(sr.getInt(1));
		System.out.print("\t" + sr.getString(2));
	    System.out.print("\t" +sr.getString(3));
	    System.out.print("\t" +sr.getString(4));
	    System.out.print("\t" +sr.getString(5));
	    System.out.print("\t" +sr.getString(6));
	    System.out.println("\t" +sr.getDate(7));
	
	}
	
}


}
