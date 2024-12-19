package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {
	
	public int nextPK() throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.Bundle.system");

		int pk=0;
		Class.forName(rb.getString("driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
		PreparedStatement pstmt=conn.prepareStatement("select max(id) from st_user");
		
		ResultSet rs=pstmt.executeQuery();
		
		while (rs.next()) {
			
			pk=rs.getInt(1);
			System.out.println("Max id="+pk);
		}
		return pk+1;
	}

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement prst = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?)");

		prst.setInt(1, bean.getId());
		prst.setString(2, bean.getFirstname());
		prst.setString(3, bean.getLastname());
		prst.setString(4, bean.getLoginid());
		prst.setString(5, bean.getPassword());
		prst.setString(6, bean.getAddress());
		prst.setDate(7, new java.sql.Date(bean.getDob().getTime()));

//		int i = prst.executeUpdate();

//		System.out.println("data added successfully" + i);
		
		UserBean existsbean = new UserBean();
		
		System.out.println("login id = " + bean.getLoginid());
		
		existsbean = findByLoginId(bean.getLoginid());
		
		if (existsbean != null) {

			System.out.println("loginId already exists");

		} else {
			prst.setInt(1, nextPK());
			prst.setString(2, bean.getFirstname());
			prst.setString(3, bean.getLastname());
			prst.setString(4, bean.getLoginid());
			prst.setString(5, bean.getPassword());
			prst.setString(6, bean.getAddress());
			prst.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = prst.executeUpdate();

			System.out.println("data added successfully " + i);
		}

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement prst = conn.prepareStatement("delete from st_user where id = ?");

		prst.setInt(1, id);

		int i = prst.executeUpdate();

		System.out.println("data delete successfully" + i);

	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement prst = conn.prepareStatement(
				"update st_user set firstname = ?, lastname = ?, loginid = ?, password = ?, address = ?,dob = ? where id = ?");

		prst.setString(1, bean.getFirstname());
		prst.setString(2, bean.getLastname());
		prst.setString(3, bean.getLoginid());
		prst.setString(4, bean.getPassword());
		prst.setString(5, bean.getAddress());
		prst.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		prst.setInt(7, bean.getId());

		int i = prst.executeUpdate();

		System.out.println("data updated successfully = " + i);
 
	}

	public List search (UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");
		
		if (bean != null) {

			if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {

				sql.append(" and firstname like '" + bean.getFirstname() + "'");
				
			}
			
			if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				
				sql.append(" and lastname like '" + bean.getLastname() + "'");
				
			}
			
			if (bean.getLoginid() != null && bean.getLoginid().length() > 0) {
				
				sql.append(" and loginid like '" + bean.getLoginid() + "'");
				
			}
			
			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				
				sql.append(" and address like '" + bean.getAddress() + "'"); 
				
			}
			
			
		}
		
		PreparedStatement prst = conn.prepareStatement(sql.toString());
		
		System.out.println("sql = " + sql.toString());

		ResultSet rs = prst.executeQuery();

//		UserBean bean = null;

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

			list.add(bean);

		}
		return list;
	}

	public UserBean authenticate(String loginid, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement prst = conn.prepareStatement("select * from st_user where loginid = ? and password = ?");

		prst.setString(1, loginid);  
		prst.setString(2, password);

		ResultSet rs = prst.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

		}

		return bean;

	}

	public UserBean findByLoginId(String loginId) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement prst = conn.prepareStatement("select * from st_user where loginId = ?");

		prst.setString(1, loginId);

		ResultSet rs = prst.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

		}

		return bean;

	}

}
