package Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import Connector.ItemTesting;
import DAO.MainDAO;

public class Item extends JFrame implements ActionListener
{
	/*Khin Yadanar Hlaing
	Write GUI (2.11.2018)*/
	
	JLabel itemlabel=new JLabel("Item Name");
	JLabel unitlabel=new JLabel("Unit");
	JLabel bincardlabel=new JLabel("Bin Card No.");
	JLabel categoryinitem=new JLabel("Category");
	
	public static JTextField itemtextfield=new JTextField();
	public static JTextField unittextfield=new JTextField();
	public static JTextField bincardtextfield=new JTextField();
	
	public static JComboBox catecomboinitem=new JComboBox();
	
	JSeparator separatorobj=new JSeparator();
	
	JButton itemsavebutton=new JButton("Save");
	JButton itemupdatebutton=new JButton("Update");
	JButton itemdeletebutton=new JButton("Delete");
	
	Container c=getContentPane();
	
	public Item() throws SQLException
	{
		setTitle("Item");
		setSize(400,600);
		setLocation(200,50);
		
		itemlabel.setBounds(50,50,100,25);
		itemtextfield.setBounds(50,80,250,25);
		
		unitlabel.setBounds(50,130,100,25);
		unittextfield.setBounds(50,160,250,25);
		
		bincardlabel.setBounds(50,210,150,25);
		bincardtextfield.setBounds(50,240,250,25);
		
		categoryinitem.setBounds(50,290,100,25);
		catecomboinitem.setBounds(50,320,250,25);
		
		separatorobj.setBounds(0,470,600,3);
		itemsavebutton.setBounds(50,500,80,25);
		itemupdatebutton.setBounds(150,500,80,25);
		itemdeletebutton.setBounds(250,500,80,25);
		
		c.add(itemlabel);
		c.add(itemtextfield);
		c.add(unitlabel);
		c.add(unittextfield);
		c.add(bincardlabel);
		c.add(bincardtextfield);
		c.add(categoryinitem);
		c.add(catecomboinitem);
		c.add(separatorobj);
		c.add(itemsavebutton);
		//c.add(itemupdatebutton);
		//c.add(itemdeletebutton);
		
		c.setLayout(null);
		
		itemsavebutton.addActionListener(this);
		ItemTesting.categoryComboinItem();
		setVisible(true);
		
	}
	
	public static void main(String []args) throws SQLException
	{
		new Item();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == itemsavebutton)
		{
			try 
			{
				//MainDAO.categoryCombo();
				ItemTesting.saveTest();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
}
