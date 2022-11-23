package FirstProgram;

import java.sql.*;
import java.util.Vector;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Valkyrie extends JFrame implements ActionListener
{
	Connection cnn;
	Statement sta;
	ResultSet res;
	String url = "jdbc:mysql://localhost/valkyrieinfo?user=root&password=root";
	
	JButton b1 = new JButton("Save");
	JButton b2 = new JButton("Delete");
	JButton b3 = new JButton("Update");
	JButton b4 = new JButton("Search by RNO");
	JButton b5 = new JButton("Search by Name");
	JButton b6 = new JButton("Search by Major");
	JButton b7 = new JButton("Search by Year");
	JButton b8 = new JButton("Sort by ASC");
	JButton b9 = new JButton("Sort by DESC");
	JButton b10 = new JButton("View All");
	JButton b11 = new JButton("Find");
	JButton b12 = new JButton("View All by Table");
	JButton b13 = new JButton("Update All");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	
	JLabel l1 = new JLabel("Roll Number");
	JLabel l2 = new JLabel("Name");
	JLabel l3 = new JLabel("Major");
	JLabel l4 = new JLabel("Year");
	
	JTextArea ta = new JTextArea();
	
	JScrollPane jsp = new JScrollPane(ta);
	
	Container c = getContentPane();
	
	//for table
	
	JTable tt;
	JScrollPane jsp1;
	
	public Valkyrie()
	{
		setTitle("Valkyrie Database");
		setSize(1200,600);
		
		c.setLayout(null);
		
		l1.setBounds(100, 50, 100, 20);
		l2.setBounds(100, 100, 100, 20);
		l3.setBounds(100, 150, 100, 20);
		l4.setBounds(100, 200, 100, 20);
		
		t1.setBounds(250, 50, 200, 25);
		t2.setBounds(250, 100, 200, 25);
		t3.setBounds(250, 150, 200, 25);
		t4.setBounds(250, 200, 200, 25);
		
		b1.setBounds(100, 250, 150, 25);
		b2.setBounds(100, 275, 150, 25);
		b3.setBounds(100, 300, 150, 25);
		b4.setBounds(100, 325, 150, 25);
		b5.setBounds(100, 350, 150, 25);
		b6.setBounds(100, 375, 150, 25);
		b7.setBounds(100, 400, 150, 25);
		b8.setBounds(250, 250, 150, 25);
		b9.setBounds(250, 275, 150, 25);
		b10.setBounds(250, 300, 150, 25);
		b11.setBounds(250, 325, 150, 25);
		b12.setBounds(250, 350, 150, 25);
		b13.setBounds(250, 375, 150, 25);
		
		jsp.setBounds(500, 50,500,175);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(jsp);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		c.add(b6);
		c.add(b7);
		c.add(b8);
		c.add(b9);
		c.add(b10);
		c.add(b11);
		c.add(b12);
		c.add(b13);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		t1.addActionListener(this);
		b13.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String args[])
	{
		Valkyrie val = new Valkyrie();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() ==  b1)
		{
			try 
			{
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				String s = "insert into stuinfo values("+Integer.parseInt(t1.getText())+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
				int r = sta.executeUpdate(s);
				if(r>=1)
					JOptionPane.showMessageDialog(this, "Insert Successful");
				else
					JOptionPane.showMessageDialog(this, "Insert Failed");
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == b2)
		{
			try {
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				String s = "delete from stuinfo where rno = "+Integer.parseInt(t1.getText());
				int r = sta.executeUpdate(s);
				if(r>=1)
					JOptionPane.showMessageDialog(this, "Delect Successful");
				else
					JOptionPane.showMessageDialog(this, "Delect Failed");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == b10)
		{
			try {
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				String s = "Select * from stuinfo";
				res = sta.executeQuery(s);
				ta.setText("RollNo\tName\tMajor\tYear\n");
				while(res.next())
				{
					ta.append(res.getString(1)+"\t");
					ta.append(res.getString(2)+"\t");
					ta.append(res.getString(3)+"\t");
					ta.append(res.getString(4)+"\n");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b12)
		{
			/*try {
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				String s = "select * from stuinfo";
				res = sta.executeQuery(s);
				display(res);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			new Information();
			c.validate();
		}
		if(e.getSource() == t1)
		{
			try {
				cnn = DriverManager.getConnection(url);
				String s = "Select * from stuinfo where rno = "+Integer.parseInt(t1.getText());
				sta = cnn.createStatement();
				res = sta.executeQuery(s);
				if(res.next())
				{
					t2.setText(res.getString(2));
					t3.setText(res.getString(3));
					t4.setText(res.getString(4));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b13)
		{
			try {
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				String s = "update stuinfo set name ='"+t2.getText()+"', major = '"+t3.getText()+"',year='"+t4.getText()+"' where rno = "+Integer.parseInt(t1.getText());
				int r = sta.executeUpdate(s);
				if(r>=1)
				{
					JOptionPane.showMessageDialog(this , "Update Successful");
				}
				else
					JOptionPane.showMessageDialog(this, "Update Failed");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
	}
	private void display(ResultSet res) throws SQLException 
	{
		if(!res.next())
		{
			JOptionPane.showMessageDialog(this, "Table contains no data");
			return;
		}
		Vector cols = new Vector();
		Vector rows = new Vector();
		ResultSetMetaData rsmd = res.getMetaData();
		for(int i = 1 ; i <= rsmd.getColumnCount() ; i++)
		{
			cols.addElement(rsmd.getColumnName(i));
		}
		do
		{
			rows.addElement(getNextRow(res,rsmd)); 
		}
		while(res.next());
		tt = new JTable( rows , cols);
		jsp1 = new JScrollPane(tt);
		jsp1.setBounds(500, 300, 500, 175);
		c.add(jsp1);
		c.validate();
		
	}
	private Vector getNextRow(ResultSet res, ResultSetMetaData rsmd) throws SQLException
	{
		Vector tmp = new Vector();
		for(int i = 1 ; i<= rsmd.getColumnCount(); i++)
		{
			switch(rsmd.getColumnType(i))
			{
			case Types.DECIMAL : tmp.addElement(res.getInt(i)); break;
			case Types.VARCHAR : tmp.addElement(res.getString(i)); break;
			}
		}

		return tmp;
	}
	
}
