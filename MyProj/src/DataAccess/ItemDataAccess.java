package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ItemModel;

public class ItemDataAccess 
{
	public static boolean saveItem(ItemModel item) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		String saveItemQuery = "INSERT INTO item(item_name,unit,bincard_no,category_id) VALUES(?,?,?,?)";
		PreparedStatement stmt = cnn.prepareStatement(saveItemQuery);
		stmt.setString(1, item.getItem_name());
		stmt.setString(2, item.getUnit());
		stmt.setInt(3, item.getBincard_no());
		stmt.setInt(4, item.getCategory_id());
		int r = stmt.executeUpdate();
		
		if(r >= 1)
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
	
	public static boolean updateItem(ItemModel item) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		String updateItemQuery = "UPDATE item SET item_name = ? WHERE item_code = ?";
		PreparedStatement stmt = cnn.prepareStatement(updateItemQuery);
		stmt.setString(1, item.getItem_name());
		stmt.setInt(2, item.getItem_code());
		int r = stmt.executeUpdate();
		
		if( r >= 1)
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
	
	public static boolean deleteItem(ItemModel item) throws SQLException
	{
		Connection conn = DataConnection.connect();
		String deleteItemQuery = "DELETE FROM item WHERE item_code = ?";
		PreparedStatement stmt = conn.prepareStatement(deleteItemQuery);
		stmt.setInt(1, item.getItem_code());
		int r = stmt.executeUpdate();
		
		if(r >= 1)
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
	
	public static ArrayList<ItemModel> getItem(int categoryId) throws SQLException
	{
		Connection cnn = DataConnection.connect(); 
		String getItemQuery = "select * from item where category_id = ?";
		PreparedStatement stmt = cnn.prepareStatement(getItemQuery);
		stmt.setInt(1, categoryId);
		ResultSet res = stmt.executeQuery();
		
		ArrayList<ItemModel> itemList = new ArrayList<>();
		while(res.next())
		{
			int item_code = res.getInt("item_code");
			String item_name = res.getString("item_name");
			String unit = res.getString("unit");
			int bincard_no = res.getInt("bincard_no");
			int category_id = res.getInt("category_id");
			
			ItemModel items = new ItemModel(item_code, item_name, unit, bincard_no, category_id);
			itemList.add(items);
		}
		return itemList;
	}
	/*public static int idofselectedCategory() throws SQLException
	{
		Connection cnn = Database.getInstance().getConnection();
		
		String categoryIdQuery = "select * from category where category_name = '"+ MainFrame.categorycombobox.getSelectedItem() +"'";
		
		Statement sta = cnn.createStatement();
		ResultSet res = sta.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
	
		return i;
	}*/
}
