package Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.ImportDAO;

import com.toedter.calendar.JDateChooser;

public class Import extends JFrame implements ActionListener
{
	/*
	 Khin Yadanar Hlaing
	 October 22 2018(1:15 am)
	 */
	JLabel datelabel=new JLabel("Transaction Date");
	JLabel sourcelabel=new JLabel("Source");
	JLabel invoicenumberlabel=new JLabel("Invoice  Number");
	JLabel invoicedatelabel=new JLabel("Invoice Date");
	JLabel importcountlabel=new JLabel("Import Count");
	JLabel unitpricelabel=new JLabel("Unit Price");
	JLabel totalcostlabel=new JLabel("Total Cost");
	JLabel signlabel=new JLabel("Sign");
	JLabel optionlabel=new JLabel("Option / Remark");
	
	public static double totalprice;
	public static JDateChooser transaction_date_chooser=new JDateChooser();
	public static JTextField invoicenumbertextfield=new JTextField();
	public static JDateChooser iinvoice_date_chooser=new JDateChooser();
	public static JTextField importcounttextfield=new JTextField();
	public static JTextField unitpricetextfield=new JTextField();
	public static JTextField totalcosttextfield=new JTextField("Press Enter to know total price");
	public static JTextField signtextfield=new JTextField();
	public static JTextField sourcetextfield= new JTextField();
	
	
	
	public static JTextArea optiontextarea=new JTextArea();
	public static JScrollPane optionscrollpane=new JScrollPane(optiontextarea);
	
	JButton confirmbutton=new JButton("Confirm");
	JButton cancelbutton=new JButton("Cancel");
	
	Container c=getContentPane();
	public Import() throws SQLException
	{
		setTitle("Import");
		datelabel.setBounds(50,50,100,20);
		transaction_date_chooser.setBounds(200,50,250,20);
		
		sourcelabel.setBounds(50,100,100,20);
		sourcetextfield.setBounds(200,100,250,20);
		
		invoicenumberlabel.setBounds(50,150,100,20);
		invoicenumbertextfield.setBounds(200,150,250,20);
		
		invoicedatelabel.setBounds(50,200,100,20);
		iinvoice_date_chooser.setBounds(200,200,250,20);
		
		importcountlabel.setBounds(50,250,100,20);
		importcounttextfield.setBounds(200,250,250,20);
		
		unitpricelabel.setBounds(50,300,100,20);
		unitpricetextfield.setBounds(200,300,250,20);
		
		totalcostlabel.setBounds(50,350,100,20);
		totalcosttextfield.setEditable(false);
		totalcosttextfield.setBounds(200,350,250,20);
		
		signlabel.setBounds(50,400,100,20);
		signtextfield.setBounds(200,400,250,20);
		
		optionlabel.setBounds(50,450,100,20);
		optionscrollpane.setBounds(200,450,250,50);
		
		confirmbutton.setBounds(240,550,80,20);
		cancelbutton.setBounds(370,550,80,20);
		
		c.add(datelabel);
		c.add(transaction_date_chooser);
		c.add(sourcelabel);
		c.add(sourcetextfield);
		c.add(invoicenumberlabel);
		c.add(invoicenumbertextfield);
		c.add(invoicedatelabel);
		c.add(iinvoice_date_chooser);
		c.add(importcountlabel);
		c.add(importcounttextfield);
		c.add(unitpricelabel);
		c.add(unitpricetextfield);
		c.add(totalcostlabel);
		c.add(totalcosttextfield);
		c.add(signlabel);
		c.add(signtextfield);
		c.add(optionlabel);
		c.add(optionscrollpane);
		c.add(confirmbutton);
		c.add(cancelbutton);
		
		//Adding action listener
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		unitpricetextfield.addActionListener(this);
		
		c.setLayout(null);
		setLocation(410,80);
		setSize(500,650);
		setVisible(true);
	}
	
	public static void main(String []args) throws SQLException
	{
		new Import();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==confirmbutton)
		{
			try 
			{
				ImportDAO.confirmImportFunction();
			} 
			catch (Exception e1) 
			{
				JOptionPane.showMessageDialog(this,"Enter Data","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == unitpricetextfield)
		{
			int count = Integer.parseInt(importcounttextfield.getText());
			double price = Double.parseDouble(unitpricetextfield.getText());
			totalprice = count*price;
			totalcosttextfield.setText(String.valueOf(totalprice));
		}
		if(e.getSource() == cancelbutton)
		{
			dispose();
		}
	}
}
