package Input;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DataAccess.ItemDataAccess;
import Model.ItemModel;

public class ItemInput 
{
	static ItemModel item = null;
	
	public static void save()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Item Name, Unit, BinCard no. and Category_id : ");
			
			int item_code = 0;
			String item_name = sc.next();
			String unit = sc.next();
			int bincard_no = Integer.parseInt(sc.next());
			int category_id = Integer.parseInt(sc.next());
		
			item = new ItemModel(item_code, item_name, unit, bincard_no, category_id);
			
			ItemDataAccess itemData = new ItemDataAccess();
			
			try 
			{
				boolean condition = itemData.saveItem(item);
				if(condition)
					System.out.println("Item is created.");
				else	 
					System.out.println("Item is not created.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to input another item?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void update()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Item Code and Item Name : ");
			
			int item_code = Integer.parseInt(sc.next());
			String item_name = sc.next();
			String unit = "";
			int bincard_no = 0;
			int category_id = 0;
		
			item = new ItemModel(item_code, item_name, unit, bincard_no, category_id);
			
			ItemDataAccess itemData = new ItemDataAccess();
			
			try 
			{
				boolean condition = itemData.updateItem(item);
				if(condition)
					System.out.println("Item is updated.");
				else	 
					System.out.println("Item is not updated.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to update another item?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void delete()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Item Code for deletion : ");
			
			int item_code = Integer.parseInt(sc.next());
			String item_name = "";
			String unit = "";
			int bincard_no = 0;
			int category_id = 0;
		
			item = new ItemModel(item_code, item_name, unit, bincard_no, category_id);
			
			ItemDataAccess itemData = new ItemDataAccess();
			
			try 
			{
				boolean condition = itemData.deleteItem(item);
				if(condition)
					System.out.println("Item is deleted.");
				else	 
					System.out.println("Item is not deleted.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to delete another item?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void main(String args[]) throws SQLException
	{
		ItemInput it = new ItemInput();
		/*it.save();
		it.update();
		it.delete();*/
		
		System.out.println("Enter Category ID for item");
		Scanner sc = new Scanner(System.in);
		int categoryID = Integer.parseInt(sc.next());
		
		System.out.println("Items in table\n-----------------------------------");
		ArrayList<ItemModel> itemList = ItemDataAccess.getItem(categoryID);
		Iterator<ItemModel> iterator = itemList.iterator();
		while(iterator.hasNext())
		{
			ItemModel item = iterator.next();
			System.out.println(item.getItem_code()+"\t"+item.getItem_name()+"\t"+item.getUnit()+"\t"+item.getBincard_no()+"\t"+item.getCategory_id());
		}
	}
}
