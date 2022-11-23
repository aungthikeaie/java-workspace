package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Form.Item;
import Form.MainFrame;

public class MainDAO 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	
	public static void categoryCombo() throws SQLException
	{
		cnn = Database.getInstance().getConnection();
		
		String categoryQuery = "select * from category";
		sta = cnn.createStatement();
		res = sta.executeQuery(categoryQuery);
		MainFrame.categorycombobox.removeAllItems();
		
		while(res.next())
		{
			MainFrame.categorycombobox.addItem(res.getString(2));
		}
		
		//cnn.close();
	}

	
	public static void periodCombo() throws SQLException
	{
		cnn = Database.getInstance().getConnection();
		
		String periodQuery = "select * from period";
		sta = cnn.createStatement();
		res = sta.executeQuery(periodQuery);
		while(res.next())
		{
			MainFrame.periodcombobox.addItem(res.getString(4));
		}
		
		//cnn.close();
	}
}
