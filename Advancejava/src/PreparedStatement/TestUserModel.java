package PreparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		
		testadd();
		
		
		
	}

		private static void testadd() throws Exception {
		
		
	

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
		
		bean.setId(4);
		bean.setFirstname("goutam");
	    bean.setLastname("prajapati");
	    bean.setLoginid("goutam@gmail.com");
	    bean.setPassword("pass123");
	    bean.setAddress("bhopal");
	    bean.setDob(sdf.parse("2003-02-02"));

		model.add(bean);

	
	}

}
