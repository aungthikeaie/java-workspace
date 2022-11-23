package Form;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.TotupTableDAO;
import DataAccess.ViewTableDAO;
import DataAccess.TemporaryTable;

public class TopupView extends JFrame 
{
	
	public String Query="select item_name,unit,stock_in_hand,max(ledger_id) from totup";
	
	
	public static JFrame topupFrame = new JFrame();
	
	public static String title = MainFrame.categorycombobox.getSelectedItem().toString();
	
	JLabel topup_title = new JLabel("Mandalay Technological University");
	JLabel topup_category = new JLabel(title);
	
	/*String table_title[] = {"No","Name","Unit","Stock In Hand","Ground In Hand","Remark"};
	String table_value[][] = {
			{"1","Kyat Mway","Lone","58","58",""},
			{"2","Trash","Pone","51","51",""}};*/
	
	/*JTable topup_table = new JTable(table_value,table_title);
	JScrollPane topup_scrollpane = new JScrollPane(topup_table);*/
	
	Container topup_container = getContentPane();
	
	public TopupView() throws SQLException
	{
		topupFrame.setTitle("Top Up View");
		topupFrame.setSize(1400,1000);
		topupFrame.setLocation(250,30);
		
		topupFrame.setLayout(null);
		
		topup_title.setBounds(600,30,700,20);
		topup_category.setBounds(20,50,250,20);
		//topup_scrollpane.setBounds(10,100,1360,840);
		
		topupFrame.add(topup_category);
		topupFrame.add(topup_title);
		//topup_container.add(topup_scrollpane);
		
		TemporaryTable.createTempTable();
		TotupTableDAO.viewFunction(Query);
		
		topupFrame.setVisible(true);
	}
	public static void main(String []args) throws SQLException
	{
		TopupView topup = new TopupView();
	}
}
