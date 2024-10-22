package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws Exception {

//	    Step 1 = Load mysql driver (Clas loader)
		Class.forName("com.mysql.cj.jdbc.Driver");

//		Step 2 = create connection 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

//		Step 3 = create statement object
		Statement stnt = conn.createStatement();

//		Step 4 = create querry
		ResultSet sr = stnt.executeQuery("select * from marksheet");
		
		System.out.println("id\tname\trollno\tmarks\tresult");
		System.out.println("\t");

		while (sr.next()) {

			System.out.print(sr.getInt(1));
			System.out.print("\t" + sr.getString(2));
			System.out.print("\t" + sr.getInt(3));
			System.out.print("\t" + sr.getInt(4));
			System.out.println("\t" + sr.getString(5));
		}

	}

}
