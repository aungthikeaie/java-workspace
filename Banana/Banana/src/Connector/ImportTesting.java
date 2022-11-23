package Connector;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import DAO.Database;
import DAO.ImportDAO;
import Form.Import;
import Form.MainFrame;
import Model.LedgerModel;

public class ImportTesting 
{
	public static LedgerModel ledger=null;
	public static void savetest() throws SQLException
	{
		 int ledger_id = 0;
		 String transaction_date = DateFunction.dateReturn((Import.transaction_date_chooser.getDate().toString()));
		 String source = Import.sourcetextfield.getText();
		 int iinvoice_no = Integer.parseInt(Import.invoicenumbertextfield.getText());
		 String iinvoice_date = DateFunction.dateReturn((Import.iinvoice_date_chooser.getDate().toString()));
		 int count = Integer.parseInt(Import.importcounttextfield.getText());
		 double unit_price = Double.parseDouble(Import.unitpricetextfield.getText());
		 double total_cost = count*unit_price;
		 int used = 0;
		 int stock_in_hand = sumFunction();
		 String sign = Import.signtextfield.getText();
		 String remark = Import.optiontextarea.getText();
		 int item_code = idofselectedItem();
		 int period_id = idofselectedPeriod();
		 
		 
		 
		 ledger = new LedgerModel(ledger_id, transaction_date, source, iinvoice_no, iinvoice_date, count, unit_price, total_cost, used, stock_in_hand, sign, remark, item_code, period_id);
		 ImportDAO importDao=new ImportDAO();
		 importDao.saveImport(ledger);
	
	}
	public static int sumFunction() throws SQLException
	{
		Connection cnn = Database.getInstance().getConnection();
		
		String stockinhandQuery = "select * from ledger where item_code = "+idofselectedItem();
		
		Statement sta = cnn.createStatement();
	    ResultSet res = sta.executeQuery(stockinhandQuery);
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
				
				counting = counting+res.getInt(6)+den;
			}
			else
				counting -= res.getInt(9);
			
			looping++;
		}
		return counting;
	}
	
	public static int idofselectedItem() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String Query = "select * from item where item_name='"+ MainFrame.itemcombobox.getSelectedItem()+"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(Query);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
	
	public static int idofselectedPeriod() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String Query = "select * from period where description='"+ MainFrame.periodcombobox.getSelectedItem()+"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(Query);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}

}
