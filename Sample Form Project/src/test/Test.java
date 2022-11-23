package test;

import java.sql.SQLException;

import dao.ItemDAO;
import model.Item;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Fake Data
		
		int itemCode = 2;
		String itemName = "Pen";
		String  unit = "Chaung";
		int bincardNo = 2;
		int categoryId = 2;
		
		Item item = new Item(itemCode,itemName,unit,bincardNo,categoryId);
		
		ItemDAO itemDAO = new ItemDAO();
		
		/*try 
		{
			System.out.println("new item inserted.");
			itemDAO.saveItem(item);
		} 
		catch (SQLException e)
		{
			System.out.println("Failed.");
			e.printStackTrace();
		}*/
		try {
			Item i = itemDAO.getItem(32);
			if(i!=null) {
				System.out.println("Name:"+i.getItemName());
				System.out.println("Unit:"+i.getUnit());
				System.out.println("Bincard No:"+i.getBincardNo());
			}
			else {
				System.out.println("Cannot retrieve data for this item code.");
			}
		} catch (SQLException e) {
			System.out.println("Cannot save this item.");
			e.printStackTrace();
		}
		
	}

}
