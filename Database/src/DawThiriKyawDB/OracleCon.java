package DawThiriKyawDB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import com.mysql.jdbc.Connection;

public class OracleCon 
{
	public static void main(String[] args)
	{
		java.sql.Connection cnn;
		Statement sta;
		ResultSet res;
		String url = "jdbc:mysql://localhost/egdatabase?user=root&password=root";
		
		try 
		{
			cnn = DriverManager.getConnection(url);
			
			
			String s = "select * from emp";
			sta = cnn.createStatement();
			res = sta.executeQuery(s);
			while(res.next())
			{
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
			}
			cnn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}
}
