package Form;
import java.awt.Container;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DataAccess.ViewTableDAO;
import DataAccess.TemporaryTable;



public class View  extends JFrame 
{
	public String Query="select * from ledger where item_code="+ViewTableDAO.idofselectedItem();
	
	JLabel ledger_label=new JLabel("Ledger");
	JLabel item_label=new JLabel("Item");
	JLabel unit_label=new JLabel("Unit");
	JLabel finance_year_label=new JLabel("Finance Year");
	
	JTextField item_textfield=new JTextField();
	JTextField unit_textfield=new JTextField();
	JTextField finance_year_textfield=new JTextField();
	
	//public static JTable viewTable;
	//JTextArea ledger_textarea=new JTextArea();
	//public static JScrollPane jsp = new JScrollPane(viewTable);
	
	public static JFrame frame=new JFrame();
	
	public View() throws SQLException
	{
		frame.setTitle("Ledger");
		frame.setSize(1400,1000);
		frame.setLayout(null);
		
		ledger_label.setBounds(650,5,50,20);
	
		item_label.setBounds(10,20,50,20);
		unit_label.setBounds(10,50,50,20);
		finance_year_label.setBounds(1000,20,100,20);
		
		item_textfield.setBounds(60,20,250,20);
		unit_textfield.setBounds(60,50,250,20);
		finance_year_textfield.setBounds(1100,20,250,20);
		
		frame.add(ledger_label);
		frame.add(item_label);
		frame.add(unit_label);
		frame.add(finance_year_label);
		
		frame.add(item_textfield);
		frame.add(unit_textfield);
		frame.add(finance_year_textfield);
		
		
		ViewTableDAO.viewFunction(Query);
		
		frame.setVisible(true);
	}
	
	
}

	