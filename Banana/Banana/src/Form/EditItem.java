package Form;

import javax.swing.*;

import Connector.ItemTesting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EditItem extends JFrame implements ActionListener
{
	/*Khin Yadanar Hlaing
	Write GUI (2.11.2018)*/
	
	JLabel current_name_label=new JLabel("Current Name");
	JTextField current_name_textfield=new JTextField();
	JLabel new_name_lable=new JLabel("Enter new name");
	public static JTextField new_name_textfield=new JTextField();
	
	JSeparator separatorobj=new JSeparator();
	
	JButton update_button=new JButton("Update");
		
	Container c=getContentPane();
	
	public EditItem()
	{
		setTitle("Edit");
		setSize(400,400);
		setLocation(200,50);
		c.setLayout(null);
		
		current_name_label.setBounds(50,50,100,25);
		current_name_textfield.setBounds(50,80,250,25);
		current_name_textfield.setEditable(false);
		current_name_textfield.setText(MainFrame.itemcombobox.getSelectedItem().toString());
		
		new_name_lable.setBounds(50,130,100,25);
		new_name_textfield.setBounds(50,160,250,25);
		
		separatorobj.setBounds(0,270,600,5);
		
		
		update_button.setBounds(140,290,90,30);
	
		c.add(current_name_label);
		c.add(current_name_textfield);
		c.add(new_name_lable);
		c.add(new_name_textfield);
		c.add(separatorobj);
		c.add(update_button);
		
		update_button.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public static void main(String []args)
	{
		new EditItem();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==update_button)
		{
			try {
				ItemTesting.updateTest();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
