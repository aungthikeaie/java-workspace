package DataAccess;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

import Form.MainFrame;
import Form.View;

public class TotupTableDAO
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url="jdbc:mysql://localhost/storetest?user=root&password=root";

	static JTable table;
	
	public TotupTableDAO()
	{
		table.setEnabled(false);
	}
	
	
	
	public static void viewFunction(String Query) throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		//String viewFunctionQuery="select * from ledger";
		sta=cnn.createStatement();
		res=sta.executeQuery(Query);
	
		displayResultSet(res);
		//table.remove(table);
		
	}

	private static void displayResultSet(ResultSet rs) throws SQLException 
	{
		boolean r=rs.next();
		if(r==false)
		{
			JOptionPane.showMessageDialog(null,"ResultSet contains no record");
			return;
		}
		Vector cols=new Vector();
		Vector rows=new Vector();
		
		ResultSetMetaData rsmd=rs.getMetaData();
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			cols.addElement(rsmd.getColumnName(i));
		}
		do
		{
			rows.addElement(getNextRow(rs,rsmd));
		}
		while(rs.next());
		table=new JTable(rows,cols);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(10,80,1300,400);
		
		View.frame.add(jsp);
		View.frame.validate();
	}

	private static Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd) throws SQLException 
	{
		Vector tmp=new Vector();
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			switch(rsmd.getColumnType(i))
			{
				case Types.NVARCHAR : tmp.addElement(rs.getString(i));	break;
				case Types.VARCHAR : tmp.addElement(rs.getString(i));	break;
				case Types.INTEGER : tmp.addElement(rs.getInt(i));		break;
				
			}
		}
		return tmp;
	}
	public static void main(String[] args) throws SQLException 
	{
		new TemporaryTable();
	}
}
