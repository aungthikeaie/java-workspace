package Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.CategoryDAO;
import DAO.Database;
import Form.Category;
import Form.EditCategory;
import Form.Item;
import Form.MainFrame;
import Model.CategoryModel;

public class CategoryTesting 
{
	static CategoryModel category = null;
	static int categoryId=0;
	public static void saveTest()
	{
		int categoryId = 0;
		String categoryName = Category.categorytextfield.getText();
		
		category = new CategoryModel(categoryId,categoryName);
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		try 
		{
			categoryDao.saveCategory(category);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void updateTest() throws SQLException
	{
		categoryId= idofselectedCategory();
		String categoryName = EditCategory.new_name_textfield.getText();
		
		category = new CategoryModel(categoryId,categoryName);
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		try 
		{
			categoryDao.updateCategory(category);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void deleteTest() throws SQLException
	{
		
		String categoryName = MainFrame.categorycombobox.getSelectedItem().toString();
		int categoryId = idofselectedCategory();
		category = new CategoryModel(categoryId,categoryName);
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		try 
		{
			categoryDao.deleteCategory(category);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static int idofselectedCategory() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String categoryIdQuery = "select * from category where category_name ='"+ MainFrame.categorycombobox.getSelectedItem().toString() +"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
}
