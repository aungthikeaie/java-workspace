package FirstProgram;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class TableTesting extends JFrame implements ActionListener
{
	JButton b1 = new JButton("Click Me");
	
	JPanel p = new JPanel();
	
	JTextArea ta = new JTextArea();
	JScrollPane jsp = new JScrollPane(ta);
	
	Container c = getContentPane();
	
	Connection cnn;
	Statement sta;
	ResultSet res;
	String url = "jdbc:mysql://localhost/valkyrieinfo?user=root&password=root";
	
	public TableTesting()
	{
		setTitle("Testing Database");
		setSize(600,400);
		
		p.add(b1);
		c.add("North",p);
		c.add(jsp);
		
		b1.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new TableTesting();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == b1)
		{
			try 
			{
				cnn = DriverManager.getConnection(url);
				String s = "select * from stuinfo";
				sta = cnn.createStatement();
				res = sta.executeQuery(s);
				ta.setText("Roll No\tName\tMajor\tYear\n");
				while(res.next())
				{
					int r = res.getInt(1);
					String n = res.getString(2);
					String m = res.getString(3);
					String y = res.getString(4);
					ta.append(r+"\t"+n+"\t"+m+"\t"+y+"\n");
				}
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
	}
}
