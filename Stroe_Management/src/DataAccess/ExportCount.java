package DataAccess;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportCount 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url="jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static int ExportRowCount() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String firstOrNot = "select count(*) from ledger where item_code = "+ ImportDAO.idofselectedItem();
		sta = cnn.createStatement();
		res = sta.executeQuery(firstOrNot);
		
		res.next();
		int i = res.getInt(1);
		System.out.println("Export Row Count = " + i);
		return i;
	}
}
