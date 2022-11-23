package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Form.MainFrame;
import Model.CategoryModel;
import Model.ItemModel;

public class ItemDAO 
{
	static int result=0;
	public static int saveItem(ItemModel item) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String saveItemQuery = "insert into item(item_name,unit,bincard_no,category_id) values(?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(saveItemQuery);
		stmt.setString(1, item.getItem_name());
		stmt.setString(2, item.getUnit());
		stmt.setInt(3, item.getBincard_no());
		stmt.setInt(4, item.getCategory_id());
		int r = stmt.executeUpdate();
		
		if(r >= 1)
			result=1;
			//JOptionPane.showMessageDialog(null, "New item is created.","Save",JOptionPane.INFORMATION_MESSAGE);
		else
			//JOptionPane.showMessageDialog(null, "New item is not created.","Error",JOptionPane.ERROR_MESSAGE);
			result=2;
		//conn.close();
		return result;
	}
	
	public static void updateItem(ItemModel item) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String updateItemQuery = "update item set item_name = ? where item_code = ?";
		PreparedStatement stmt = conn.prepareStatement(updateItemQuery);
		stmt.setString(1, item.getItem_name());
		stmt.setInt(2, item.getItem_code());
		int r = stmt.executeUpdate();
		
		if( r >= 1)
			JOptionPane.showMessageDialog(null, "Item is updated.","Update",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Item is not updated.","Error",JOptionPane.ERROR_MESSAGE);
		
		//conn.close();
	}
	
	public static void deleteItem(ItemModel item) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String deleteItemQuery = "delete from item where item_code = ?";
		PreparedStatement stmt = conn.prepareStatement(deleteItemQuery);
		stmt.setInt(1, item.getItem_code());
		int r = stmt.executeUpdate();
		
		if(r >= 1)
			JOptionPane.showMessageDialog(null, "Item is deleted","Delete",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Item is not deleted","Error",JOptionPane.ERROR_MESSAGE);
		
		//conn.close();
	}
	
	public static List<String> getItem(CategoryModel category) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String getItemQuery = "select * from item where category_id = ?";
		PreparedStatement stmt = conn.prepareStatement(getItemQuery);
		stmt.setInt(1, category.getCategory_id());
		ResultSet res = stmt.executeQuery();
		
		List<String> itemList = new ArrayList<>();
		while(res.next())
		{
			int itemCode = res.getInt(1);
			String itemName = res.getString(2);
			String Unit = res.getString(3);
			int bincardNo = res.getInt(4);
			int categoryId = res.getInt(5);
			
			ItemModel item = new ItemModel(itemCode, itemName, Unit, bincardNo, categoryId);
			itemList.add(item.toString());
		}
		return itemList;
	}
	public static int idofselectedCategory() throws SQLException
	{
		Connection cnn = Database.getInstance().getConnection();
		
		String categoryIdQuery = "select * from category where category_name = '"+ MainFrame.categorycombobox.getSelectedItem() +"'";
		
		Statement sta = cnn.createStatement();
		ResultSet res = sta.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
	
		return i;
	}
}
