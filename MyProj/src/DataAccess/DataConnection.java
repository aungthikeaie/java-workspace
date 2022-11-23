package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection 
{
	static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	static Connection cnn;
	public static Connection connect() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		return cnn;
	}
	
	public static void closeConnection() throws SQLException
	{
		cnn.close();
		System.out.println("Connection is closed.");
	}
}
