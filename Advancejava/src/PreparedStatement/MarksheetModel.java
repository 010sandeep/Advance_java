package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class MarksheetModel {
	
	public void add(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheets values(?, ?, ?, ?, ?, ?)");
		
	
//	pstmt.setInt(1, bean.getId());
//	pstmt.setInt(2, bean.getRollno());
//	pstmt.setString(3, bean.getName());
//	pstmt.setInt(4, bean.getPhysics());
//	pstmt.setInt(5, bean.getChemistry());
//	pstmt.setInt(6, bean.getMaths());
		
	MarksheetBean existbean = new MarksheetBean();
	
	System.out.println("rollno = " + bean.getRollno());
	
	existbean = findByRollno(bean.getRollno());
	
	if (existbean != null) {
		System.out.println("rollno already exists");
	}else {
		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollno());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());
		
	int i = pstmt.executeUpdate();
	System.out.println("data added successfully " + i);
	}
	}
	
	public MarksheetBean findByRollno(int rollno) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheets where rollno = ?");
		
		pstmt.setInt(1, rollno);
		
		ResultSet sr = pstmt.executeQuery();
		
		MarksheetBean bean = null;
		
		while (sr.next()) {
			
			bean = new MarksheetBean();
			
			bean.setId(sr.getInt(1));
			bean.setRollno(sr.getInt(2));
			bean.setName(sr.getString(3));
			bean.setPhysics(sr.getInt(4));
			bean.setChemistry(sr.getInt(5));
			bean.setMaths(sr.getInt(6));
		}
		
		
		return bean;
		
		
	}
	
	public void delete(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheets where id = ?" );
				
		pstmt.setInt(1, id);
		
		int i = pstmt.executeUpdate();
		
		System.out.println("Data deleted successfully=" + i);
		
	}
	
	public void update(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("update marksheets set rollno = ?, name = ?, physics = ?, chemisrty = ?, maths = ? where id = ?" );
		
		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());
		
		int i = pstmt.executeUpdate();
		System.out.println("data updated successfully =" + i);
		
		
		
		
	}
	
	public List search(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheets" );
		
		ResultSet rs = pstmt.executeQuery();
		
		List list = new ArrayList();
		
		while (rs.next()) {
			
			bean = new  MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			list.add(bean);
			
			
		}
		return list;
		
	}
	

}
