package Form;

import java.awt.Container;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.ItemDAO;

public class Item extends JFrame implements ActionListener
{
	JLabel item_label = new JLabel("Item");
	JLabel	unit_label = new JLabel("Unit");
	JLabel bincard_no_label = new JLabel("Bincard Number");
	
	public static JTextField item_textfField = new JTextField();
	public static JTextField unit_textfField = new JTextField();
	public static JTextField bincard_no_textfField = new JTextField();
	
	JButton create_button = new JButton("Create");
	JButton cancel_button = new JButton("Cancel");
	
	Container c = getContentPane();
	
	JSeparator buttons_separator = new JSeparator();
	
	public Item()
	{
		setTitle("Item");
		setSize(700,700);
		setLocation(600, 150);
		c.setLayout(null);
		
		item_label.setBounds(100,50,50,25);
		unit_label.setBounds(100,100,80,25);
		bincard_no_label.setBounds(100,150,100,25);
		
		item_textfField.setBounds(200,50,250,25);
		unit_textfField.setBounds(200,100,250,25);
		bincard_no_textfField.setBounds(200,150,250,25);
		
		buttons_separator.setBounds(0,400,800,800);
		create_button.setBounds(200,500,100,30);
		cancel_button.setBounds(350,500,100,30);
		
		c.add(item_label);
		c.add(unit_label);
		c.add(bincard_no_label);
		c.add(item_textfField);
		c.add(unit_textfField);
		c.add(bincard_no_textfField);
		c.add(buttons_separator);
		c.add(create_button);
		c.add(cancel_button);
		
		//Adding Aciton Listener
		create_button.addActionListener(this);
		cancel_button.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Item();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		//Action For Create Button
		if(e.getSource() == create_button)
		{
			try 
			{
				ItemDAO.createItemFunction();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		//Action For Cancel Button 
		if(e.getSource() ==  cancel_button)
		{
			dispose();
		}
	}
	
	

}
