package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Form.Export;
import Form.Import;
import Form.MainFrame;

public class StockInHandFunctionImport 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url="jdbc:mysql://localhost/storetest?user=root&password=root";
	
	
	public static int sumFunction() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String stockinhandQuery = "select * from ledger where item_code = "+ ImportDAO.idofselectedItem();
		
		sta = cnn.createStatement();
		res = sta.executeQuery(stockinhandQuery);
		int looping = 0;
		int den = 0;
		int counting = 0;
		while(res.next())
		{
			
			//System.out.println(res.getInt(6)+res.getInt(6));
			if(res.getInt(6) != 0 )
			{
				if(looping == 0)
					den = Integer.parseInt(Import.importcounttextfield.getText());
				else
					den = 0;
				
				counting =counting+res.getInt(6)+den;
			}
			else
				counting -= res.getInt(9);
			
			looping++;
			System.out.println("Looping  = " + looping);
		}
		System.out.println("Counting = "+counting);
		
		return counting;
	}
	public static void main(String arg[]) throws SQLException
	{
		StockInHandFunctionImport sihf = new StockInHandFunctionImport();
		sumFunction();
	
	}
}
