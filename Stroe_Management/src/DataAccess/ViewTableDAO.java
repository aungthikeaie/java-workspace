package DataAccess;

import java.sql.*;
import java.util.*;

import javax.swing.*;

import Form.*;


public class ViewTableDAO
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	public static String url="jdbc:mysql://localhost/storetest?user=root&password=root";

	static JTable table;
	
	public ViewTableDAO()
	{
		table.setEnabled(false);
	}
	
	public static int idofselectedItem() throws SQLException
	{
		cnn = DriverManager.getConnection(url);
		
		String itemIdQuery = "select * from item where item_name = '"+ MainFrame.itemcombobox.getSelectedItem() +"'";
		
		sta = cnn.createStatement();
		res = sta.executeQuery(itemIdQuery);
		res.next();
		int i = res.getInt(1);
		return i;
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
				case Types.DECIMAL : tmp.addElement(rs.getInt(i));		break;
				case Types.VARCHAR : tmp.addElement(rs.getString(i));	break;
				case Types.DOUBLE : tmp.addElement(rs.getDouble(i));	break;
				case Types.DATE : tmp.addElement(rs.getDate(i));		break;
				case Types.INTEGER : tmp.addElement(rs.getInt(i));		break;
				case Types.NVARCHAR : tmp.addElement(rs.getString(i));	break;
			}
		}
		return tmp;
	}
}
