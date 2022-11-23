package DataAccess;

import java.sql.*;

import javax.swing.JOptionPane;

import Form.*;

public class CategoryDAO 
{
	static Connection cnn;
	static Statement sta;
	static ResultSet res;
	static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	

	//For creating new category in database
	
	public static void createCategory() throws SQLException
	{
			cnn = DriverManager.getConnection(url);
			String newCategoryQuery = "insert into category(category_name) values('"
										+Category.category_textfield.getText()+"')";
			sta = cnn.createStatement();
			int r = sta.executeUpdate(newCategoryQuery);
			
			if(r >= 1)
				JOptionPane.showMessageDialog(null, "New category is created.");
			else
				JOptionPane.showMessageDialog(null, "New category is not created.");
			
			cnn.close();
	}
	
	//For adding new category to combobox
	
	/*public static void addingCategory() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String newCategoryInCombobox ="select * from category";
		sta = cnn.createStatement();
		res = sta.executeQuery(newCategoryInCombobox);
		
		while(res.next())
		{
			CategorySec.category_combobox.addItem(res.getString(2));
		}
	}*/
	//For deleting selected Category from combobox
	public static void deleteCategory() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String deleteQuery = "delete from category where category_name = '"+MainFrame.categorycombobox.getSelectedItem().toString()+"'";
		
		sta = cnn.createStatement();
		int r = sta.executeUpdate(deleteQuery);
		if(r >= 1)
			JOptionPane.showMessageDialog(null, "Category is deleted.");
		else
			JOptionPane.showMessageDialog(null, "Category is not deleted.");
		
		cnn.close();
	}
}
