package Form;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.CategoryDAO;



public class Category extends JFrame implements ActionListener
{
	JLabel category_label = new JLabel("Category");
	
	public static JTextField category_textfield = new JTextField();
	
	JButton create_button = new JButton("Create");
	JButton cancel_button = new JButton("Cancel");
	
	Container c = getContentPane();
	
	JSeparator buttons_separator = new JSeparator();
	
	
	public Category()
	{
		setTitle("Category");
		setSize(700,700);
		setLocation(600, 150);
		c.setLayout(null);
		
		
		category_label.setBounds(100,50,80,25);
		
		category_textfield.setBounds(200,50,250,25);
		
		buttons_separator.setBounds(0,400,800,800);
		create_button.setBounds(200,500,100,30);
		cancel_button.setBounds(350,500,100,30);
		
		c.add(category_label);
		c.add(category_textfield);
		c.add(buttons_separator);
		c.add(create_button);
		c.add(cancel_button);
		
		create_button.addActionListener(this);
		cancel_button.addActionListener(this);
	
	
		setVisible(true);
	}

	
	
	public static void main(String[] args)
	{
		new Category();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == create_button)
		{
			String s = new String(category_textfield.getText());
			if(s.length() != 0)
			{
				try 
				{
					CategoryDAO.createCategory();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this , "Enter category name.");
			}
		}
		if(e.getSource() == cancel_button)
		{
			dispose();
		}
	}
	
	

}
