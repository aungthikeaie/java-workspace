package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class TwiceScore extends JFrame implements ActionListener
{
	JLabel l1 = new JLabel("Enter SSN");
	JLabel l2 = new JLabel("Enter Password");
	JLabel l3 = new JLabel("Name");
	JLabel l4 = new JLabel("Score");
	
	JTextField t1 = new JTextField(15);
	JTextField t2 = new JTextField(15);
	JTextField t3 = new JTextField(15);
	
	JPasswordField pw1 = new JPasswordField(15);
	
	JButton b1 = new JButton("Find Score");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	Container c = getContentPane();
	
	Connection cnn;
	Statement sta;
	ResultSet res;
	String url = "jdbc:mysql://localhost/assignment?user=root&password=root";
	
	
	public TwiceScore()
	{
		setTitle("Twice Score");
		setLocation(700,500);
		
		p1.setLayout(new GridLayout(4,2));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(pw1);
		p1.add(l3);
		p1.add(t2);
		p1.add(l4);
		p1.add(t3);
		
		t3.setEditable(false);
		t2.setEditable(false);
		
		p2.add(b1,FlowLayout.LEFT);
		
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.LINE_END);
		
		b1.addActionListener(this);
		
		pack();
		setVisible(true);
	}
	public static void main(String args[])
	{
		TwiceScore twice = new TwiceScore();
	}
	public void actionPerformed(ActionEvent e) 
	{
		DBC();
		if(e.getSource() == b1)
		{
			String ssn = t1.getText();
			String psw = String.valueOf(pw1.getPassword());
			String s = "select * from login";
			
			try 
			{
				res = sta.executeQuery(s);
				int flag = 0;
				while(res.next())
				{
					t1.setText(null);
					pw1.setText(null);
					if((res.getString(3).equals(ssn)) && (res.getString(4).equals(psw)))
					{
						flag = 0;
						t2.setText(res.getString(2));
						t3.setText(res.getString(5));
						break;
					}
					else if(res.getString(3).equals(ssn))
					{
						flag = 1;
						
						break;
					}
					else if(res.getString(4).equals(psw))
					{
						flag = 2;
						
						break;
					}
					else
					{
						flag = 3;
						
						System.out.println(res.getString(3));
						//break;
					}
				}
				switch(flag)
				{
				case 1 : JOptionPane.showMessageDialog(this, "Password Incorrect.","Message",JOptionPane.INFORMATION_MESSAGE); break;
				case 2 : JOptionPane.showMessageDialog(this, "SSN Incorrect.","Message",JOptionPane.INFORMATION_MESSAGE); break;
				case 3 : JOptionPane.showMessageDialog(this, "SSN and Password are incorrect.","Message",JOptionPane.INFORMATION_MESSAGE); break;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}
	public void DBC()
	{
		try {
			cnn = DriverManager.getConnection(url);
			sta = cnn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
