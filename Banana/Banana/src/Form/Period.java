package Form;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import Connector.PeriodTesting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Period extends JFrame implements ActionListener
{
	/*Khin Yadanar Hlaing
	Write GUI (2.11.2018)*/
	
	JLabel fromlabel=new JLabel("From");
	JLabel tolabel=new JLabel("To");
	JLabel descriptionlabel=new JLabel("Description");
	
	public static JDateChooser  start_date = new JDateChooser();
	public static JDateChooser  end_date = new JDateChooser();
	
	public static JTextArea descriptiontextarea=new JTextArea();
	
	JScrollPane sp=new JScrollPane(descriptiontextarea);
	JSeparator separatorobj=new JSeparator();
	
	JButton periodsavebutton=new JButton("Save");
	JButton periodupdatebutton=new JButton("Update");
	JButton perioddeletebutton=new JButton("Delete");
	
	Container c=getContentPane();
	
	public Period()
	{
		setTitle("Ledger Period");
		setSize(400,600);
		setLocation(200,50);
		c.setLayout(null);
		
		fromlabel.setBounds(50,50,100,25);
		start_date.setBounds(50,80,250,25);
		
		tolabel.setBounds(50,130,100,25);
		end_date.setBounds(50,160,250,25);
		
		descriptionlabel.setBounds(50,210,100,25);
		sp.setBounds(50,240,250,50);
		
		separatorobj.setBounds(0,450,600,3);
		periodsavebutton.setBounds(50,480,80,25);
		periodupdatebutton.setBounds(150,480,80,25);
		perioddeletebutton.setBounds(250,480,80,25);
		
		c.add(fromlabel);
		c.add(start_date);
		c.add(tolabel);
		c.add(end_date);
		c.add(descriptionlabel);
		c.add(sp);
		c.add(separatorobj);
		c.add(periodsavebutton);
		//c.add(periodupdatebutton);
		//c.add(perioddeletebutton);
		
		periodsavebutton.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public static void main(String []args)
	{
		new Period();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==periodsavebutton)
		{
			PeriodTesting.saveTest();
		}
	}
}
