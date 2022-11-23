package DataAccess;

import java.sql.*;

import javax.swing.JOptionPane;

public class TemporaryTable 
{
	public static Connection cnn;
	public static Statement sta;
	public static String url="jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static void createTempTable() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String createTempTableQuery = "create table Totup select item_name,unit,stock_in_hand,ledger_id from item,ledger";
		sta=cnn.createStatement();
		int r=sta.executeUpdate(createTempTableQuery);
		if(r>=1)
		{
			JOptionPane.showMessageDialog(null,"Table Created");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No Table");
		}
		//cnn.close();
		
	}
		
	

}
