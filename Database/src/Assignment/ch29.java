package Assignment;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.sql.*;
import java.util.Vector;

public class ch29 extends JFrame implements ActionListener
{
	Connection cnn;
	Statement sta;
	ResultSet res;
	//String url = "jdbc:odbc:AAA";//(only for 32 bit OS)
	//String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=D:/Employee.accdb";
	
	String url="jdbc:ucanaccess://D:/Access/Employee.accdb";
	
	JButton b1 = new JButton("Create");
	JButton b2 = new JButton("Insert");
	JButton b3 = new JButton("Update");
	JButton b4 = new JButton("Delete");
	JButton b5 = new JButton("All");
	JButton b6= new JButton("ByName");
	JButton b7 = new JButton("ByDept");
	JButton b8 = new JButton("ByLoc");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	JTextArea ta = new JTextArea();
	
	JScrollPane jsp = new JScrollPane(ta);
	JTable tt;
	JScrollPane jsp1;
	
	
	Container c = getContentPane();
	
	public ch29()
	{
		setTitle("ex1");
		setSize(400,300);
		setLocation(700,400);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		c.add(p1,BorderLayout.NORTH);
		c.add(jsp);
		c.add(p2,BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		ch29 classes = new ch29();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			String tablename = JOptionPane.showInputDialog(null,"Enter the name of the table");
			int numOfRoll = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the numbers of the column of the table"));
			String tableColName[] = new String[numOfRoll];
			String type[] = new String[numOfRoll];
			String s = "create table "+tablename+"(";
			for(int i = 0; i < numOfRoll; i++)
			{
				tableColName[i] = JOptionPane.showInputDialog(null,"Enter the name of column "+(i+1));
				type[i] = JOptionPane.showInputDialog(null,"Enter the type of column "+(i+1)+" fully");
				s = s + tableColName[i]+" "+type[i];
				if((i+1) != numOfRoll)
					s = s + ",";
			}
			s = s + ")";
			System.out.println(s);
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				int r = sta.executeUpdate(s);
				System.out.println(r);
				if(r >= 0)
					JOptionPane.showMessageDialog(this, "Creation of table successful");
				else
					JOptionPane.showMessageDialog(this, "Creation of table unsuccessful");
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b2)
		{
			try
			{
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter ID"));
				String name = JOptionPane.showInputDialog(null,"Enter Name");
				String nrc = JOptionPane.showInputDialog(null,"Enter NRC");
				String gender = JOptionPane.showInputDialog(null,"Enter Gender");
				String dept = JOptionPane.showInputDialog(null,"Enter Department");
				String loc = JOptionPane.showInputDialog(null,"Enter Location");
				
				String s = "insert into emp(eID,eName,nrc,Gender,eDept,eLoc) values ("+id+",'"+name+"','"+nrc+"','"+gender+"','"+dept+"','"+loc+"')";
				
				cnn=DriverManager.getConnection(url);
				sta=cnn.createStatement();
				int r = sta.executeUpdate(s);
				if(r>=1)
					JOptionPane.showMessageDialog(this, "Insert Successful");
				else
					JOptionPane.showMessageDialog(this, "Insert Unsuccessful");
				
				System.out.println("Get Connected");
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
			catch(SQLException s)
			{
				s.printStackTrace();
			}
		}
		if(e.getSource() == b3)
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter id of the name you want to update"));
				String name = JOptionPane.showInputDialog(null,"Enter the new name");
				String s = "update emp set eName = '"+name+"' where eID = "+id;
				
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				int r = sta.executeUpdate(s);
				if(r>=1)
					JOptionPane.showMessageDialog(this, "Update Successful");
				else
					JOptionPane.showMessageDialog(this, "Update Unsucessful");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b4)
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter ID that you want to delete."));
				
				String s = "delete from emp where eID = "+id;
				cnn=DriverManager.getConnection(url);
				sta=cnn.createStatement();
				int r=sta.executeUpdate(s);
				if(r>=1)
					JOptionPane.showMessageDialog(this, "Delete Successful");
				else
					JOptionPane.showMessageDialog(this, "Delete Unsuccessful");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b5)
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String s = "select * from emp";
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				res = sta.executeQuery(s);
				display(res);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == b6)
		{
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String s = "select * from emp order by eName desc";
				cnn = DriverManager.getConnection(url);
				sta = cnn.createStatement();
				res = sta.executeQuery(s);
				ta.setText("eID\teName\t\tNRC\tGender\teDept\teLoc\n");
				while(res.next())
				{
					ta.append(res.getInt (1)+"\t");
					ta.append(res.getString(2)+"\t\t");
					ta.append(res.getString(3)+"\t");
					ta.append(res.getString(4)+"\t");
					ta.append(res.getString(5)+"\t");
					ta.append(res.getString(6)+"\n");
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		//jsp1.setBounds(500, 300, 500, 175);
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
			case Types.NUMERIC : tmp.addElement(res.getInt(i)); break;
			case Types.VARCHAR : tmp.addElement(res.getString(i)); break;
			}
		}

		return tmp;
	}
}
