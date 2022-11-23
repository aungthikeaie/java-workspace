package DataAccess;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.PeriodModel;

public class PeriodDataAccess 
{
	public static boolean saveCategory(PeriodModel period) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		
		String savePeriodQuery = "INSERT INTO period(start_date,end_date,description) VALUES(?,?,?)";
		PreparedStatement stmt = cnn.prepareStatement(savePeriodQuery);
		stmt.setString(1,period.getStart_date());
		stmt.setString(2,period.getEnd_date());
		stmt.setString(3,period.getDescription());
		int r = stmt.executeUpdate();
		
		if( r >= 1 )
		{
			DataConnection.closeConnection();
			return true;
		}
		else
		{
			DataConnection.closeConnection();
			return false;
		}
	}
	
	public static boolean updatePeriod(PeriodModel period) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		String updatePeriodQuery = "UPDATE period SET description = ? WHERE period_id = ?";
		PreparedStatement stmt = cnn.prepareStatement(updatePeriodQuery);
		stmt.setString(1, period.getDescription());
		stmt.setInt(2, period.getPeriod_id());
		int r = stmt.executeUpdate();
		
		if( r >= 1 )
		{
			DataConnection.closeConnection();
			return true;
		}
		else
		{
			DataConnection.closeConnection();
			return false;
		}
	}
	
	public static boolean deletePeriod(PeriodModel period) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		
		String deletePeriodQuery = "DELETE FROM period WHERE period_id = ?";
		PreparedStatement stmt = cnn.prepareStatement(deletePeriodQuery);
		stmt.setInt(1, period.getPeriod_id());
		int r = stmt.executeUpdate();
		
		if( r >= 1 )
		{
			DataConnection.closeConnection();
			return true;
		}
		else
		{
			DataConnection.closeConnection();
			return false;
		}
	}
	
	public static ArrayList<PeriodModel> getPeriod() throws SQLException
	{
		Connection cnn = DataConnection.connect();
		
		String getPeriodQuery = "SELECT * FROM period";
		PreparedStatement stmt = cnn.prepareStatement(getPeriodQuery);
		ResultSet res = stmt.executeQuery();
		
		ArrayList<PeriodModel> periodList = new ArrayList<>();
		while(res.next())
		{
			int period_id = res.getInt("period_id");
			String start_date = res.getString("start_date");
			String end_date = res.getString("end_date");
			String description = res.getString("description");
			
			PeriodModel period = new PeriodModel(period_id, start_date, end_date, description);
			
			periodList.add(period);
		}
		return periodList;
	}
}
