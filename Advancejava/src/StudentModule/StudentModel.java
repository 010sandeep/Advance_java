package StudentModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {

	public void add(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_student values(?, ?, ?, ?, ?, ?, ?)");

//		pstmt.setInt(1, bean.getId());
//		pstmt.setString(2, bean.getFirstname());
//		pstmt.setString(3, bean.getLastname());
//		pstmt.setString(4, bean.getCollageName());
//		pstmt.setString(5, bean.getEmail());
//		pstmt.setString(6, bean.getMobileNo());
//		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

		SimpleDateFormat simple = new SimpleDateFormat();

		StudentBean existbean = new StudentBean();

		System.out.println("email = " + bean.getEmail());

		existbean = findByemail(bean.getEmail());

//		System.out.println("id = " + bean.getId());
//
//		existbean = findByid(bean.getId());
//
		if (existbean != null) {

			System.out.println("email already exists");
		} else {

			pstmt.setInt(1, nextpk());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getCollageName());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("Data Added Successfully " + i);
		}
	}

	public void update(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_student set firstname = ?, lastname = ?, collageName = ?, email = ?, mobileNo = ?, Dob = ? where id = ? ");

		pstmt.setString(1, bean.getFirstname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getCollageName());
		pstmt.setString(4, bean.getEmail());
		pstmt.setString(5, bean.getMobileNo());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(7, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Updated Sucessefully   " + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_student where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted Successfully  " + i);

	}

	public List search(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_student");

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCollageName(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setDob(rs.getDate(7));

			list.add(bean);

		}
		return list;

	}

	public StudentBean findByid(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_student where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCollageName(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		}
		return bean;
	}

	public StudentBean findByemail(String email) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_student where email = ?");

		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCollageName(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setDob(rs.getDate(7));

		}

		return bean;
	}

	public int nextpk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_student");

		ResultSet rs = pstmt.executeQuery(); 

		while (rs.next()) {

			pk = rs.getInt(1);
			System.out.println("maximum id = " + pk);
		}

		return pk + 1;

	}

}
