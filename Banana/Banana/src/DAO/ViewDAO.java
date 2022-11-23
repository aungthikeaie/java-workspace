package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Form.MainFrame;

public class ViewDAO 
{
	public static Connection cnn;
	public static Statement sta;
	public static ResultSet res;
	
	static JTable table;
	
	
	public ViewDAO()
	{
		table.setEnabled(false);
	}
	
	public static int idofselectedItem() throws SQLException
	{
		cnn = Database.getInstance().getConnection();
		String itemIdQuery ="select * from item where item_name ='"+ MainFrame.itemcombobox.getSelectedItem().toString()+"'";
		sta = cnn.createStatement();
		res = sta.executeQuery(itemIdQuery);
		res.next();
		int i = res.getInt(1);
		return i;
	}
	
	public static int idofselectedPeriod() throws SQLException
	{
		cnn= Database.getInstance().getConnection();
		
		String periodIdQuery ="select * from period where description='"+MainFrame.periodcombobox.getSelectedItem().toString()+"'";
		sta = cnn.createStatement();
	    res = sta.executeQuery(periodIdQuery);
		res.next();
		int i = res.getInt(1);
		return i;
		
	}
	
	public static void viewFunction() throws SQLException
	{
		cnn = Database.getInstance().getConnection();
		
		String viewFunctionQuery="select * from ledger where item_code="+idofselectedItem()+" and "+"period_id="+idofselectedPeriod();
		sta=cnn.createStatement();
		res=sta.executeQuery(viewFunctionQuery);
		
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
		table=null;
		table=new JTable(rows,cols);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(10,130,1900,900);
		
		MainFrame.frame.add(jsp);
		MainFrame.frame.validate();
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
