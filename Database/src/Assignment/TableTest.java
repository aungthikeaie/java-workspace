package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TableTest 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static void main(String args[]) throws SQLException
	{
		new TableTest();
		createTable();
	}
	public static void createTable() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String s = "create table Meme(id varchar(5),Name varchar(5))";
		
		sta = cnn.createStatement();
		
		int r = sta.executeUpdate(s);
		if(r>=1)
			System.out.println("Table created");
		else
			System.out.println("Table is not created");
	}
}
