package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private String url = "jdbc:mysql://localhost/storetest?user=root&password=root";

	private Connection conn;
	private static Database db;

	private Database() throws SQLException 
	{
		createConnection();
	}

	public static Database getInstance() throws SQLException 
	{
		if (db == null) 
		{
			db = new Database();
		}
		return db;
	}

	public void createConnection() throws SQLException 
	{
		conn = DriverManager.getConnection(url);
	}

	public Connection getConnection() 
	{
		return conn;
	}
/*	public void closeConnection() throws SQLException
	{
		this.conn.close();
	}
*/
}
