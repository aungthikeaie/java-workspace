package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Form.Export;
import Form.Import;

public class StockInHandFunctionExport 
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
		
		int den = Integer.parseInt(Export.exportcounttextfield.getText());
		int counting = 0;
		while(res.next())
		{
			
			//System.out.println(res.getInt(6)+res.getInt(6));
			if(res.getInt(6) != 0 )
				counting =counting+res.getInt(6);
			else	
				counting = counting-res.getInt(9);

		}
		System.out.println("Counting = "+counting);
		counting = counting - den;
		return counting;
	}
	

}
