package Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Database;
import Form.Item;

public class IDFuntion 
{
	public static int idofselectedCategory(String name) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String categoryIdQuery = "select * from category where category_name = '"+ Item.catecomboinitem.getSelectedItem() +"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	
	/*public static int idofselectedItem() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		
		String itemIdQuery = "select * from item where item_name = '"+ MainFrame.itemcombobox.getSelectedItem() +"'";
		
		Statement sta = conn.createStatement();
		ResultSet res = sta.executeQuery(itemIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	
	public static int idofselectedPeriod() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		
		String periodIdQuery = "select * from period where description= '"+ MainFrame.periodcombobox.getSelectedItem() +"'";
		
		Statement sta = conn.createStatement();
		ResultSet res = sta.executeQuery(periodIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}*/
}
