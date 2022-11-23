package Form;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.PeriodDAO;

import com.toedter.calendar.JDateChooser;

public class Period extends JFrame implements ActionListener
{
	
	
	JLabel year_label = new JLabel("Year");
	JLabel start_date_label = new JLabel("Start Date");
	JLabel end_date_label = new JLabel("End Date");
	
	public static JTextField desc_textfield = new JTextField();
	public static JDateChooser  start_date_calendar = new JDateChooser();
	public static JDateChooser  end_date_calendar = new JDateChooser();
	
	JButton create_button = new JButton("Create");
	JButton cancel_button = new JButton("Cancel");
	
	Container c = getContentPane();
	
	public Period()
	{
		setTitle("Period");
		setSize(700,700);
		setLocation(600,150);
		
		
		c.setLayout(null);
		
		//year_label.setFont(new Font("Zawgyi-One",Font.BOLD, 22));
		
		year_label.setBounds(100,50,50,25);
		start_date_label.setBounds(100,100,80,25);
		end_date_label.setBounds(100,150,50,25);
		
		desc_textfield.setBounds(200,50,250,25);
		start_date_calendar.setBounds(200,100,250,25);
		end_date_calendar.setBounds(200,150,250,25);
		
		create_button.setBounds(200,500,100,30);
		cancel_button.setBounds(350,500,100,30);
		
		
		
		c.add(year_label);
		c.add(start_date_label);
		c.add(end_date_label);
		
		c.add(desc_textfield);
		c.add(start_date_calendar);
		c.add(end_date_calendar);
		
		c.add(create_button);
		c.add(cancel_button);
		
		//Adding Action Listener
		
		create_button.addActionListener(this);
		cancel_button.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		new Period();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == create_button)
		{
			try 
			{
				PeriodDAO.createPeriod();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == cancel_button)
		{
			dispose();
		}
	}
	
}
