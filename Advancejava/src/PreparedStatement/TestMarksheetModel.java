package PreparedStatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	
	public static void main(String[] args) throws Exception {	
	
//	testdelete();
//		testupdate();
		testsearch();
//	testAdd();

}

	private static void testsearch() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = new MarksheetBean();
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" +bean.getName());
			System.out.print("\t" +bean.getPhysics());
			System.out.print("\t" +bean.getChemistry());
			System.out.println("\t" +bean.getMaths());  
			
		}
		
		
	}

	private static void testupdate() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(1);
		bean.setRollno(10);
		bean.setName("pappu");
		bean.setPhysics(80);
		bean.setChemistry(76);
		bean.setMaths(76);
		
		model.update(bean);
		
	}

	private static void testdelete() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		model.delete(10);
		
	}

	private static void testAdd() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(13); 
		bean.setRollno(11);
		bean.setName("raju");
		bean.setPhysics(65);
		bean.setChemistry(98);
		bean.setMaths(4);
	   
		model.add(bean);
	}
}