package DataAccess;

import java.sql.*;

import javax.swing.JOptionPane;

import Form.MainFrame;
import Form.Period;

public class PeriodDAO 
{
	static Connection cnn;
	static Statement sta;
	static ResultSet res;
	static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static void createPeriod() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String createQuery = "insert into period(start_date,end_date,description) values('"
							+DateFunction.dateReturn(Period.start_date_calendar.getDate().toString())+"','"
							+DateFunction.dateReturn(Period.end_date_calendar.getDate().toString())+"','"
							+Period.desc_textfield.getText()+"')";
		
		sta = cnn.createStatement();
		int r = sta.executeUpdate(createQuery);
		if(r >= 1)
			JOptionPane.showMessageDialog(null, "Period is created");
		else
			JOptionPane.showMessageDialog(null, "Period is not created");
		
		cnn.close();
							
	}
	public static void deletePeriod() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String deleteQuery = "delete from period where description = '"+MainFrame.periodcombobox.getSelectedItem().toString()+"'";
		
		sta = cnn.createStatement();
		int r = sta.executeUpdate(deleteQuery);
		if(r >= 1)
			JOptionPane.showMessageDialog(null, "Period is deleted.");
		else
			JOptionPane.showMessageDialog(null, "Period is not deleted.");
		
		cnn.close();
	}
}
