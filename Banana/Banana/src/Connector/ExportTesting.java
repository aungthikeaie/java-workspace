package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Database;
import DAO.ExportDAO;
import DAO.ImportDAO;
import Form.Export;
import Form.Import;
import Form.MainFrame;
import Model.LedgerModel;

public class ExportTesting 
{
	public static LedgerModel ledger=null;
	public static void savetest() throws SQLException
	{
		 int ledger_id = 0;
		 String transaction_date = DateFunction.dateReturn((Export.etranscation_date_chooser.getDate().toString()));
		 String source = Export.receiver_textfield.getText();
		 int iinvoice_no = Integer.parseInt(Export.invoicenumbertextfield.getText());
		 String iinvoice_date = DateFunction.dateReturn((Export.invoice_date_chooser.getDate().toString()));
		 int count = 0;
		 double unit_price = 0.0;
		 double total_cost = 0.0;
		 int used = Integer.parseInt(Export.exportcounttextfield.getText());
		 int stock_in_hand = subFunction();
		 String sign = Export.signtextfield.getText();
		 String remark = Export.optiontextarea.getText();
		 int item_code = idofselectedItem();
		 int period_id = idofselectedPeriod();
		 
		 ledger = new LedgerModel(ledger_id, transaction_date, source, iinvoice_no, iinvoice_date, count, unit_price, total_cost, used, stock_in_hand, sign, remark, item_code, period_id);
		 ExportDAO exportDao = new ExportDAO();
		 exportDao.saveExport(ledger);
	
	}
	
	public static int subFunction() throws SQLException
	{
		Connection cnn = Database.getInstance().getConnection();
		
		String stockinhandQuery = "select * from ledger where item_code = "+ idofselectedItem();
		
		Statement sta = cnn.createStatement();
		ResultSet res = sta.executeQuery(stockinhandQuery);
		
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
