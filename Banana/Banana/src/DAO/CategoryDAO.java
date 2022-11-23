package DAO;


import java.io.Console;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sun.org.mozilla.javascript.internal.json.JsonParser;
import Form.Category;
import Form.MainFrame;
import Model.CategoryModel;

public class CategoryDAO 
{
	public static void saveCategory(CategoryModel category) throws SQLException
	{
		Connection conn =Database.getInstance().getConnection();
		String saveCategoryQuery = "insert into category(category_name) value(?)";
		PreparedStatement stmt = conn.prepareStatement(saveCategoryQuery);
		stmt.setString(1,category.getCategory_name());
		int r = stmt.executeUpdate();
		if( r >= 1)
			
			JOptionPane.showMessageDialog(null,"New category is created.","Save",JOptionPane.INFORMATION_MESSAGE);
		else
			
			JOptionPane.showMessageDialog(null,"New category is not created.","Error",JOptionPane.ERROR_MESSAGE);
		
		//Database.getInstance().closeConnection();
	}
	
	public static void updateCategory(CategoryModel category) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String updateCategoryQuery = "update category set category_name = ? where category_id = ?";
		PreparedStatement stmt = conn.prepareStatement(updateCategoryQuery);
		stmt.setString(1, category.getCategory_name());
		stmt.setInt(2, category.getCategory_id());
		int r = stmt.executeUpdate();
		if( r >= 1)
			JOptionPane.showMessageDialog(null,"Category is updated.","Update",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Category is not updated.","Error",JOptionPane.ERROR_MESSAGE);
		
		//Database.getInstance().closeConnection();
		//conn.close();
	}
	
	public static void deleteCategory(CategoryModel category) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String deleteCategoryQuery = "delete from category where category_id = ?";
		PreparedStatement stmt = conn.prepareStatement(deleteCategoryQuery);
		stmt.setInt(1, category.getCategory_id());
		int r = stmt.executeUpdate();
		if(r >= 1)
			JOptionPane.showMessageDialog(null,"Category is deleted.","Delete",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Category is not deleted.","Error",JOptionPane.ERROR_MESSAGE);
		
		//Database.getInstance().closeConnection();
		//conn.close();
	}
	
	/*public static Object[] List<CategoryModel> getCategory() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String getCategoryQuery = "select * from category";
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(getCategoryQuery);
		
		List<String> categoryList = new ArrayList<>();
		
		while(res.next())
		{
			int categoryId = res.getInt(1);
			String categoryName = res.getString(2);
			
			CategoryModel category = new CategoryModel(categoryId, categoryName);
			
			categoryList.add(categoryName);
			
		}
		return categoryList.toArray();
	}*/
 }

	

