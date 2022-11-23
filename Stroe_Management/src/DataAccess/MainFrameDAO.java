package DataAccess;

import java.sql.*;

import Form.MainFrame;

public class MainFrameDAO
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static void periodCombo() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String periodQuery = "select * from period";
		sta = cnn.createStatement();
		res = sta.executeQuery(periodQuery);
		while(res.next())
		{
			MainFrame.periodcombobox.addItem(res.getString(4));
		}
		
		//cnn.close();
	}
	public static void categoryCombo() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String categoryQuery = "select * from category";
		sta = cnn.createStatement();
		res = sta.executeQuery(categoryQuery);
		while(res.next())
		{
			MainFrame.categorycombobox.addItem(res.getString(2));
		}
		
		
	}
	/*public static void itemCombo() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String categoryQuery = "select * from item where category_id = "+ItemDAO.idofselectedCategory();
		sta = cnn.createStatement();
		res = sta.executeQuery(categoryQuery);
		while(res.next())
		{
			MainFrame.itemcombobox.addItem(res.getString(2));
		}
		//cnn.close();
	}*/
}
