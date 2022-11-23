package DataAccess;

import java.sql.*;


import javax.swing.JOptionPane;

import Form.Import;
import Form.MainFrame;
import Form.Period;

public class ImportDAO 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url = "jdbc:mysql://localhost/storetest?user=root&password=root";
	
	public static int idofselectedItem() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String itemIdQuery = "select * from item where item_name = '"+ MainFrame.itemcombobox.getSelectedItem() +"'";
		
		sta = cnn.createStatement();
		res = sta.executeQuery(itemIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	public static int idofselectedPeriod() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String periodIdQuery = "select * from period where description= '"+ MainFrame.periodcombobox.getSelectedItem() +"'";
		
		sta = cnn.createStatement();
		res = sta.executeQuery(periodIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	/*public static String notNullFunction(String notNull)
	{
		if(notNull == null)
			return "0";
		else
		{
			return notNull;
		}
	}*/
	
	public static void confirmImportFunction() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		String confirmQuery = "insert into ledger(transaction_date,source,iinvoice_no,iinvoice_date,count,unit_price,total_cost,used,stock_in_hand,sign,remark,item_code,period_id) values('"
				+DateFunction.dateReturn(Import.transaction_date_chooser.getDate().toString())+"','"
				+Import.sourcetextfield.getText()+"',"
				+Import.invoicenumbertextfield.getText()+",'"
				+DateFunction.dateReturn(Import.iinvoice_date_chooser.getDate().toString())+"',"
				+Import.importcounttextfield.getText()+","
				+Import.unitpricetextfield.getText()+","
				+Import.totalprice+",0,"
				+First_Or_Not_Import.firstOrNot()+",'"
				+Import.signtextfield.getText()+"','"
				+Import.optiontextarea.getText()+"',"
				+idofselectedItem()+","
				+idofselectedPeriod()+")";
		
		System.out.println(confirmQuery);

		sta=cnn.createStatement();
		int r=sta.executeUpdate(confirmQuery);
		if(r>=1)
		{
			JOptionPane.showMessageDialog(null, "Insertion Successful");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insertion Falied");
		}
		
		cnn.close();
	}
}
