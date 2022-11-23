package DataAccess;

import java.sql.*;

import javax.swing.*;

import Form.*;

public class ItemDAO
{
	static Connection cnn;
	static Statement sta;
	static ResultSet res;
	static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static int idofselectedCategory() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String categoryIdQuery = "select * from category where category_name = '"+ MainFrame.categorycombobox.getSelectedItem() +"'";
		
		sta = cnn.createStatement();
		res = sta.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
	
		return i;
	}

	public static void createItemFunction() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String createItemQuery = "insert into item(item_name,unit,bincard_no,category_id) values('"+Item.item_textfField.getText()+
									"','"+Item.unit_textfField.getText()+"',"+Item.bincard_no_textfField.getText()+","+idofselectedCategory()+")";
		sta = cnn.createStatement();
		int	r = sta.executeUpdate(createItemQuery);
		if(r>=1)
		{
			JOptionPane.showMessageDialog(null,"New item is inserted.");	
		}
		else
		{
			JOptionPane.showMessageDialog(null, "New item is not inserted.");
		}
		cnn.close();
	}
	
	public static void deleteItem() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String deleteQuery = "delete from item where item_name = '"+MainFrame.itemcombobox.getSelectedItem().toString()+"'";
		
		sta = cnn.createStatement();
		int r = sta.executeUpdate(deleteQuery);
		if(r >= 1)
			JOptionPane.showMessageDialog(null, "Item is deleted.");
		else
			JOptionPane.showMessageDialog(null, "Item is not deleted.");
	
		cnn.close();
	}
	
	/*public static void postnewitemToCombo() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String postnewitemToComboQuery="select * from item";
		sta = cnn.createStatement();
		res = sta.executeQuery(postnewitemToComboQuery);
		while(res.next())
		{
			ItemSec.itemcombobox.addItem(res.getString(2).toString());
		}
	}*/
	
	/*public static void itemDelete() throws SQLException 
	{
		cnn = DriverManager.getConnection(url);
		String itemDeleteQuery="delete from item where item_name='"+ItemSec.itemcombobox.getSelectedItem()+"'";
		sta = cnn.createStatement();
		int r= sta.executeUpdate(itemDeleteQuery);
		if(r>=1)
		{
			JOptionPane.showMessageDialog(null,"Delete Successful");
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Delete Failed");
		}*/
}
