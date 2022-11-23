package  Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.ExportDAO;

import com.toedter.calendar.JDateChooser;

public class Export extends JFrame implements ActionListener
{
	/*
	 Thiri Win
	 October 22 2018
	 */
	
	////////////// label //////////////////////////////
	JLabel datelabel=new JLabel("Transaction Date");
	JLabel receivelabel=new JLabel("Receiver");
	JLabel invoicenumberlabel=new JLabel("Invoice  Number");
	JLabel invoicedatelabel=new JLabel("Invoice Date");
	JLabel exportcountlabel=new JLabel("Export Count");
	JLabel signlabel=new JLabel("Sign");
	JLabel optionlabel=new JLabel("Option Label");
	
	/////////////textfield///////////////////////////
	public static JDateChooser etranscation_date_chooser=new JDateChooser();
	public static JTextField receiver_textfield=new JTextField();
	public static JTextField invoicenumbertextfield=new JTextField();
	public static JDateChooser invoice_date_chooser=new JDateChooser();
	public static JTextField exportcounttextfield=new JTextField();
	public static JTextField signtextfield=new JTextField();
	
	/////////////combobox//////////////////////////
	
	/////////////textarea///////////////////////
	public static JTextArea optiontextarea=new JTextArea();
	
	////////////////////scrollpane///////////////////
	JScrollPane optionscrollpane=new JScrollPane(optiontextarea);
	
	////////////////////button/////////////////
	JButton confirmbutton=new JButton("Confirm");
	JButton cancelbutton=new JButton("Cancel");
	
	Container c=getContentPane();
	
	public Export()
	{
		setTitle("Export");
		
		datelabel.setBounds(50,50,100,20);
		etranscation_date_chooser.setBounds(200,50,250,20);
		
		receivelabel.setBounds(50,100,100,20);
		receiver_textfield.setBounds(200,100,250,20);
		
		invoicenumberlabel.setBounds(50,150,100,20);
		invoicenumbertextfield.setBounds(200,150,250,20);
		
		invoicedatelabel.setBounds(50,200,100,20);
		invoice_date_chooser.setBounds(200,200,250,20);
		
		exportcountlabel.setBounds(50,250,100,20);
		exportcounttextfield.setBounds(200,250,250,20);
		
		signlabel.setBounds(50,300,100,20);
		signtextfield.setBounds(200,300,250,20);
		
		optionlabel.setBounds(50,350,100,20);
		optionscrollpane.setBounds(200,350,250,50);
		
		confirmbutton.setBounds(240,450,80,20);
		
		cancelbutton.setBounds(370,450,80,20);
		
		c.add(datelabel);
		c.add(etranscation_date_chooser);
		
		c.add(receivelabel);
		c.add(receiver_textfield);
		
		c.add(invoicenumberlabel);
		c.add(invoicenumbertextfield);
		
		c.add(invoicedatelabel);
		c.add(invoice_date_chooser);
		
		c.add(exportcountlabel);
		c.add(exportcounttextfield);
		
		c.add(signlabel);
		c.add(signtextfield);
		
		c.add(optionlabel);
		c.add(optionscrollpane);
		
		c.add(confirmbutton);
		c.add(cancelbutton);
		
		/////////setlayout//////////////
		c.setLayout(null);
		setLocation(410,80);
		setSize(500,600);
		
		//Adding Action For Components
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String []args)
	{
		new Export();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == confirmbutton)
		{
			try 
			{
				ExportDAO.confirmExportFunction();
			} 
			catch (Exception e1) 
			{
				JOptionPane.showMessageDialog(this, "Enter Data","Error",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
		if(e.getSource() == cancelbutton)
		{
			dispose();
		}
	}
}

