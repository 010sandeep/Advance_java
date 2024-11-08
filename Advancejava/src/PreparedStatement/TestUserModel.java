package PreparedStatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

//		   testadd();
//		   testDelete();
//		   testUpdate();
	   	   testsearch();
//		   testAuthenticate();
	}

	private static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.authenticate("Udaydab7@gmail.com", "pass123");

		if (bean != null) {
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testsearch() throws Exception {

		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
//		bean.setFirstname("tarun");
//		bean.setLoginid("goutam@gmail.com");
//		bean.setAddress("bhopal");
//		bean.setLastname("Tarun");
		
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();


		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstname());
			System.out.print("\t" + bean.getLastname());
			System.out.print("\t" + bean.getLoginid());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getAddress());
			System.out.println("\t" + bean.getDob());
		}

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(3);
		bean.setFirstname("Tarun");
		bean.setLastname("Sharma");
		bean.setLoginid("tarun@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("Bhopal");
		bean.setDob(sdf.parse("2003-02-02"));

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();
		model.delete(9);

	}

	private static void testadd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstname("Uday");
		bean.setLastname("Dabi");
		bean.setLoginid("Udaydabi7648246@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2003-02-02"));

		model.add(bean);

	}

}
