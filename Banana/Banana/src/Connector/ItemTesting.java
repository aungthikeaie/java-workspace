package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DAO.CategoryDAO;
import DAO.Database;
import DAO.ItemDAO;
import Form.EditCategory;
import Form.EditItem;
import Form.Item;
import Form.MainFrame;
import Model.CategoryModel;
import Model.ItemModel;

public class ItemTesting 
{
	static ItemModel item = null;
	public static void saveTest() throws SQLException
	{
		int itemCode = 0;
		String itemName = Item.itemtextfield.getText();
		String itemUnit = Item.unittextfield.getText();
		int bincardNo = Integer.parseInt(Item.bincardtextfield.getText());
		String categoryName = Item.catecomboinitem.getSelectedItem().toString();
		
		int categoryId = idofselectedCategory();
		
		item = new ItemModel(itemCode, itemName, itemUnit, bincardNo, categoryId);
		
		ItemDAO itemDao = new ItemDAO();
		
		int result=itemDao.saveItem(item);
		if(result==1)
			JOptionPane.showMessageDialog(null, "Insert Successful");
		else
			JOptionPane.showMessageDialog(null, "Insert Failure");
	}
	
	public static void updateTest() throws SQLException
	{
		int itemCode = idofselectedItem();
		String itemName = EditItem.new_name_textfield.getText();
		String itemUnit = null;
		int bincardNo = 0;
		int categoryId = 0;
		
		item = new ItemModel(itemCode, itemName, itemUnit, bincardNo, categoryId);
		
		ItemDAO itemDao = new ItemDAO();
		
		itemDao.updateItem(item);
	}
	
	public static void deleteTest() throws SQLException
	{
		int itemCode = idofselectedItem();
		String itemName = "";
		String itemUnit = "";
		int bincardNo = 0;
		int categoryId = 0;
		
		item = new ItemModel(itemCode, itemName, itemUnit, bincardNo, categoryId);
		
		ItemDAO itemDao = new ItemDAO();
		itemDao.deleteItem(item);
	}
	
	public static int idofselectedCategory() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String categoryIdQuery = "select * from category where category_name ='"+ Item.catecomboinitem.getSelectedItem().toString() +"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	public static int idofselectedItem() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String categoryIdQuery = "select * from item where item_name ='"+ MainFrame.itemcombobox.getSelectedItem().toString()+"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	public static void categoryComboinItem() throws SQLException
	{
		Connection cnn = Database.getInstance().getConnection();
		
		String categoryQuery = "select * from category";
		Statement sta = cnn.createStatement();
		ResultSet res = sta.executeQuery(categoryQuery);
		Item.catecomboinitem.removeAllItems();
		while(res.next())
		{
			Item.catecomboinitem.addItem(res.getString(2));
		}
		
		//cnn.close();
	}
}
