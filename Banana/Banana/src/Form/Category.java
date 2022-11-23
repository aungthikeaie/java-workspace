package Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.*;

import Connector.CategoryTesting;
import DAO.CategoryDAO;

public class Category extends JFrame implements ActionListener,ItemListener
{
	/*Khin Yadanar Hlaing
	Write GUI (2.11.2018)*/
	
	JLabel categorylabel=new JLabel("Category");
	public static JTextField categorytextfield=new JTextField();
	
	JSeparator separatorobj=new JSeparator();
	JButton categorysavebutton=new JButton("Save");
	JButton categoryupdatebutton=new JButton("Update");
	JButton categorydeletebutton=new JButton("Delete");
	
	Container c=getContentPane();
	public Category()
	{
		setTitle("Category");
		setSize(400,250);
		setLocation(500,100);
		
		c.setLayout(null);
		
		categorylabel.setBounds(50,20,100,25);
		categorytextfield.setBounds(50,60,250,25);
		
		separatorobj.setBounds(0,110,400,3);
		categorysavebutton.setBounds(50,150,80,25);
		categoryupdatebutton.setBounds(150,150,80,25);
		categorydeletebutton.setBounds(250,150,80,25);
		
		c.add(categorylabel);
		c.add(categorytextfield);
		c.add(separatorobj);
		c.add(categorysavebutton);
		//c.add(categoryupdatebutton);
		//c.add(categorydeletebutton);
		
		categorysavebutton.addActionListener(this);
		
		setVisible(true);
		
	}
	public static void main(String []args)
	{
		new Category();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == categorysavebutton)
		{
			CategoryTesting.saveTest();
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
