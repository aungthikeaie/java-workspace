package Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Database;
import DAO.PeriodDAO;
import Form.EditPeriod;
import Form.MainFrame;
import Form.Period;
import Model.PeriodModel;

public class PeriodTesting
{
	static PeriodModel period =null;
	public static void saveTest()
	{
		int period_id=0;
		String start_date=DateFunction.dateReturn(Period.start_date.getDate().toString());
		String end_date=DateFunction.dateReturn(Period.end_date.getDate().toString());
		String description=Period.descriptiontextarea.getText();
		
		period =new PeriodModel(period_id, start_date, end_date, description);
		
		PeriodDAO periodDao = new PeriodDAO();
		try 
		{
			periodDao.savePeriod(period);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void updateTest() throws SQLException
	{
		int period_id = idofselectedPeriod();
		String start_date = null;
		String end_date = null;
		String description = EditPeriod.new_name_textfield.getText();
		
		period =new PeriodModel(period_id, start_date, end_date, description);
		
		PeriodDAO periodDao = new PeriodDAO();
		try 
		{
			periodDao.updatePeriod(period);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void deleteTest() throws SQLException
	{
		int period_id= idofselectedPeriod();
		String start_date="";
		String end_date="";
		String description="";
		
		period =new PeriodModel(period_id, start_date, end_date, description);
		
		PeriodDAO periodDao = new PeriodDAO();
		try 
		{
			periodDao.deletePeriod(period);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public static int idofselectedPeriod() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String Query = "select * from period where description='"+ MainFrame.periodcombobox.getSelectedItem().toString()+"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(Query);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}

}
