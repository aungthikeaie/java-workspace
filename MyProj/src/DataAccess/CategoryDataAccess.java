package DataAccess;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.CategoryModel;

public class CategoryDataAccess 
{
	public static boolean saveCategory(CategoryModel category) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		
		String saveCategoryQuery = "INSERT INTO category(category_name) VALUES(?)";
		PreparedStatement stmt = cnn.prepareStatement(saveCategoryQuery);
		stmt.setString(1,category.getCategory_name());
		int r = stmt.executeUpdate();
		
		if( r >= 1 )
		{
			DataConnection.closeConnection();
			return true;
		}
		else
		{
			DataConnection.closeConnection();
			return false;
		}
	}
	
	public static boolean updateCategory(CategoryModel category) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		String updateCategoryQuery = "UPDATE category SET category_name = ? WHERE category_id = ?";
		PreparedStatement stmt = cnn.prepareStatement(updateCategoryQuery);
		stmt.setString(1, category.getCategory_name());
		stmt.setInt(2, category.getCategory_id());
		int r = stmt.executeUpdate();
		
		if( r >= 1 )
		{
			DataConnection.closeConnection();
			return true;
		}
		else
		{
			DataConnection.closeConnection();
			return false;
		}
	}
	
	public static boolean deleteCategory(CategoryModel category) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		
		String deleteCategoryQuery = "DELETE FROM category WHERE category_id = ?";
		PreparedStatement stmt = cnn.prepareStatement(deleteCategoryQuery);
		stmt.setInt(1,category.getCategory_id());
		int r = stmt.executeUpdate();
		
		if( r >= 1 )
		{
			DataConnection.closeConnection();
			return true;
		}
		else
		{
			DataConnection.closeConnection();
			return false;
		}
	}
	
	public static ArrayList<CategoryModel> getCategory() throws SQLException
	{
		Connection cnn = DataConnection.connect();
		
		String getCategoryQuery = "SELECT * FROM category";
		PreparedStatement stmt = cnn.prepareStatement(getCategoryQuery);
		ResultSet res = stmt.executeQuery();
		
		ArrayList<CategoryModel> categoryList = new ArrayList<>();
		while(res.next())
		{
			int category_id = res.getInt("category_id");
			String category_name = res.getString("category_name");
			CategoryModel category = new CategoryModel(category_id, category_name);
			
			categoryList.add(category);
		}
		return categoryList;
	}
}
