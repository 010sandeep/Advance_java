package PreparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

//		testadd();
//		testDelete();
//		testUpdate();
		testsearch();

	}

	private static void testsearch() throws Exception {

		UserModel model = new UserModel();
		List list = model.search();
		Iterator it = list.iterator();

		UserBean bean = new UserBean();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstname());

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
		model.delete(1);

	}

	private static void testadd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(1);
		bean.setFirstname("sandeep");
		bean.setLastname("gurjar");
		bean.setLoginid("sandeep@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("bhopal");
		bean.setDob(sdf.parse("2003-02-02"));

		model.add(bean);

	}

}
