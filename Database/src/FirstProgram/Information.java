package FirstProgram;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Information extends JFrame 
{
	Connection cnn;
	Statement sta;
	ResultSet res;
	String url = "jdbc:mysql://localhost/valkyrieinfo?user=root&password=root";
	
	Container c = getContentPane();
	
	JTable tt;
	JScrollPane jsp1;
	public Information()
	{
		setTitle("View All by Another Frame");
		setSize(600,400);
		
		try {
			cnn = DriverManager.getConnection(url);
			sta = cnn.createStatement();
			String s = "select * from stuinfo";
			res = sta.executeQuery(s);
			display(res);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setVisible(true);
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
