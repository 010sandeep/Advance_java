package StudentModule;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import PreparedStatement.MarksheetBean;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

		testadd();
//        testupdate();
// 	testsearch();
//		testdelete();
	}

	private static void testsearch() throws Exception {
		
		StudentBean bean = new StudentBean();
		
		StudentModel model = new StudentModel();
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {

			bean = (StudentBean) it.next();
			
			System.out.print (bean.getId());
			System.out.print( "\t" + bean.getFirstname());
			System.out.print( "\t" + bean.getLastname());
			System.out.print( "\t" + bean.getCollageName());
			System.out.print( "\t" + bean.getEmail());
			System.out.print( "\t" + bean.getCollageName());
			System.out.println( "\t" + bean.getDob());
			
		}
	}

	private static void testdelete() throws Exception {
		
		StudentModel model = new StudentModel();
		
		StudentBean bean = new StudentBean();
		
		model.delete(2);
		
	}

	private static void testupdate() throws Exception {
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
		StudentModel model = new StudentModel();
		StudentBean bean =  new StudentBean();	
		
		bean.setId(2);
		bean.setFirstname("goutam");
		bean.setLastname("patel");
		bean.setCollageName("prestige");
		bean.setEmail("goutamq1@gmail.dom");
		bean.setMobileNo("3984348873");
		bean.setDob(simple.parse("2003-03-02"));
		
		model.update(bean);
		
	}

	private static void testadd() throws Exception {

		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");

		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();

//		bean.setId(4);
		bean.setFirstname("ram");
		bean.setLastname("patel");
		bean.setCollageName("rajisthan");
		bean.setEmail("ram@123gmail.com");
		bean.setMobileNo("3313478872");
		bean.setDob(simple.parse("2009-02-02"));
		
		
		model.add(bean);

	}

	}
