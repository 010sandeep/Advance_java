package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
	
	public void add(UserBean bean) throws Exception  {

     Class.forName("com.mysql.cj.jdbc.Driver");
     
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
     
     PreparedStatement prst = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?)");
     
     prst.setInt(1, bean.getId());
	 prst.setString(2, bean.getFirstname());	
     prst.setString(3, bean.getLastname());
	 prst.setString(4, bean.getLoginid());
	 prst.setString(5, bean.getPassword());
	 prst.setString(6, bean.getAddress());
	 prst.setDate(7,new java.sql.Date(bean.getDob().getTime()));
	 
	 int i = prst.executeUpdate();
	 
	 System.out.println("data added successfully" + i);
	}
	
	public void delete() {
		
	}
	
	public void update() {
		
	}
	
	public void search() {
		
	}
	
	
	
}