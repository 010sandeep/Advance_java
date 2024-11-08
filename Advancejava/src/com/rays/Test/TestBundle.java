package com.rays.Test;

import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) {
		
		
		ResourceBundle rs = ResourceBundle.getBundle("com.rays.bundle.system");
		
		System.out.println("Driver = " + rs.getString("driver"));
		
		System.out.println("url = " + rs.getString("url"));
		
		System.out.println("username = " + rs.getString("username"));
		
		System.out.println("password = " + rs.getString("password"));
		
		System.out.println("greeting = " + rs.getString("greeting"));
		
		
		
		
		
		
	}

}
