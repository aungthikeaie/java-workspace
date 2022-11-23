package dao;

import java.sql.Connection;


import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Item;

public class ItemDAO {
	
	public void saveItem(Item item) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String sql = "insert into item (item_code,item_name,unit,bincard_no,category_id) value (?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, item.getItemCode());
		stmt.setString(2, item.getItemName());
		stmt.setString(3, item.getUnit());
		stmt.setInt(4, item.getBincardNo());
		stmt.setInt(5,item.getCategoryId());
		stmt.executeUpdate();
		System.out.println("Item Inserted");
	}
	
	public Item getItem(int itemCode) throws SQLException 
	{
		Connection conn = Database.getInstance().getConnection();
		String sql = "select * from item where item_code=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, itemCode);
		ResultSet result = stmt.executeQuery();
		Item item =null;
		if(result.next()) 
		{
			String itemName = result.getString("item_name");
			String unit = result.getString("unit");
			int bincardNo = result.getInt("bincard_no");
			int categoryId = result.getInt("category_id");
			item = new Item(itemCode, itemName, unit, bincardNo, categoryId);
		}
		return item;
	}
	
}

