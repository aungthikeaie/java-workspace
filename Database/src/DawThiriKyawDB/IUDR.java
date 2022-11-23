package DawThiriKyawDB;

import java.sql.DriverManager;

import java.sql.*;

public class IUDR 
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
			
			String s = "insert into emp1 values(?,?)";
			
			PreparedStatement stmt = cnn.prepareStatement(s);
			
			stmt.setInt(1, 101);
			stmt.setString(2, "Ratan");
			
			stmt.executeUpdate();
			
			PreparedStatement stmtR = cnn.prepareStatement("select * from Emp1");
			
			res = stmtR.executeQuery();
			
			while(res.next())
			{
				System.out.println(res.getInt(1)+" "+res.getString(2));
			}
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
	}
}
