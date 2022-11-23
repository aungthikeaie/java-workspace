package Input;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;

import DataAccess.CategoryDataAccess;
import Model.CategoryModel;

public class CategoryInput 
{
	static CategoryModel category = null;
	
	public static void save()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Category Name : ");
			
			int category_id = 0;
			String category_name = sc.next();
		
			category = new CategoryModel(category_id, category_name);
			
			CategoryDataAccess categoryData = new CategoryDataAccess();
			
			try 
			{
				boolean condition = categoryData.saveCategory(category);
				if(condition)
					System.out.println("Category is created.");
				else	 
					System.out.println("Category is not created.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to input another category?(1/0)");
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
			System.out.print("Enter Category ID and Category Name : ");
			
			int category_id = Integer.parseInt(sc.next());
			String category_name = sc.next();
		
			category = new CategoryModel(category_id, category_name);
			
			CategoryDataAccess categoryData = new CategoryDataAccess();
			
			try 
			{
				boolean condition = categoryData.updateCategory(category);
				if(condition)
					System.out.println("Category is updated.");
				else	 
					System.out.println("Category is not updated.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to update another category?(1/0)");
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
			System.out.print("Enter Category ID for deletion : ");
		
			int category_id = Integer.parseInt(sc.next());
			String category_name = "";
		
			category = new CategoryModel(category_id, category_name);
			
			CategoryDataAccess categoryData = new CategoryDataAccess();
			
			try 
			{
				boolean condition = categoryData.deleteCategory(category);
				if(condition)
					System.out.println("Category is deleted.");
				else 
					System.out.println("Category is not deleted.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to delete another category?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void comboAdding() throws SQLException
	{
		ArrayList<CategoryModel> categoryList = CategoryDataAccess.getCategory();
		//Testing.cb.setModel(new DefaultComboBoxModel<CategoryModel>(categoryList.toArray(new CategoryModel[0])));
		Iterator<CategoryModel> iterator = categoryList.iterator();
		int i=0;
		System.out.println(categoryList.get(1).toString());
		while(iterator.hasNext())
		{
			CategoryModel model = iterator.next();
			System.out.println(model.getCategory_id()+"\t"+model.getCategory_name());
			//Testing.cb.addItem(model.getCategory_name());
			//Testing.cb.addItem(String.valueOf(categoryList.get(i++)));
		}
		
	}
	
	public static void main(String args[]) throws SQLException
	{
		CategoryInput ci = new CategoryInput();
		/*ci.save();
		ci.update();
		ci.delete();*/
		System.out.println("Category List");
		System.out.println("-------------");
		
		ArrayList<CategoryModel> categoryList = CategoryDataAccess.getCategory();
		
		Iterator<CategoryModel> iterator = categoryList.iterator();
		while(iterator.hasNext())
		{
			CategoryModel model = iterator.next();
			System.out.println(model.getCategory_id()+"\t"+model.getCategory_name());
		}
	}
}
