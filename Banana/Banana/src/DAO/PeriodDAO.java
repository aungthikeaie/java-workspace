package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.PeriodModel;

public class PeriodDAO 
{
	public static void savePeriod(PeriodModel period) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String savePeriodQuery= "insert into period(start_date,end_date,description) values(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(savePeriodQuery);
		stmt.setString(1, period.getStart_date());
		stmt.setString(2, period.getEnd_date());
		stmt.setString(3, period.getDescription());
		int r = stmt.executeUpdate();
		
		if( r >= 1)
			JOptionPane.showMessageDialog(null,"New period is created.","Save",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"New period is not created.","Error",JOptionPane.ERROR_MESSAGE);
		
		//conn.close();
	}
	
	public static void updatePeriod(PeriodModel period) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String updatePeriodQuery = "update period set description=? where period_id=?";
		PreparedStatement stmt = conn.prepareStatement(updatePeriodQuery);
		stmt.setString(1,period.getDescription());
		stmt.setInt(2,period.getPeriod_id());
		int r = stmt.executeUpdate();
		
		if( r >= 1)
			JOptionPane.showMessageDialog(null,"Period is updated.","Update",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Period is not updated.","Error",JOptionPane.ERROR_MESSAGE);
		
		//conn.close();
		
	}
	
	public static void deletePeriod(PeriodModel period) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String q = "delete from period where period_id=?";
		PreparedStatement stmt = conn.prepareStatement(q);
		stmt.setInt(1, period.getPeriod_id());
		int r = stmt.executeUpdate();
		
		if( r >= 1)
			JOptionPane.showMessageDialog(null,"Period is created.","Delete",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Period is not created.","Error",JOptionPane.ERROR_MESSAGE);
		
		//conn.close();
		
	}
	
	public static Object[]/*List<PeriodModel>*/ getPeriod() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String q ="select * from period";
		Statement sta=conn.createStatement();
		ResultSet rs=sta.executeQuery(q);
		
		List<String> periodList = new ArrayList<>();
		while(rs.next())
		{
			int period_id=rs.getInt(1);
			String start_date=rs.getString(2);
			String end_date=rs.getString(3);
			String description=rs.getString(4);
			
			/*PeriodModel period=new PeriodModel(period_id, start_date, end_date, description);*/
			periodList.add(description);
		}
		return periodList.toArray();
		
		
	}
	

}
