package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Form.MainFrame;

public class ConnectionComboboxs
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static void itemCombo() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String categoryQuery = "select * from item where category_id = "+ItemDAO.idofselectedCategory();
		sta = cnn.createStatement();
		res = sta.executeQuery(categoryQuery);
		MainFrame.itemcombobox.removeAllItems();
		while(res.next())
		{
			MainFrame.itemcombobox.addItem(res.getString(2));
		}
		
	}

}
