package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Form.Import;

public class First_Or_Not_Import 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url="jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static int firstOrNot() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String firstOrNot = "select count(*) from ledger where item_code = "+ ImportDAO.idofselectedItem();
		sta = cnn.createStatement();
		res = sta.executeQuery(firstOrNot);
		
		res.next();
		int i = res.getInt(1);
		if(i != 0)
		{
			int count = 0;
			count = StockInHandFunctionImport.sumFunction();
			System.out.println("Count for others = "+count);
			return count;
		}
		else
		{
			int count = 0;
			System.out.println("Count for first= "+count);
			return count = Integer.parseInt(Import.importcounttextfield.getText());
		}
	
	}
}
