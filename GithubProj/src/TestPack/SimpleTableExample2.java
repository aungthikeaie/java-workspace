package TestPack;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SimpleTableExample2 extends JFrame 
{
	String []title = {"Sub1","Sub2","Sub3","Sub4","Sub5"};
	String [][]data = {
			{"10","20","30","14","15"},
			{"16","17","18","29","36"},
			{"9","22","33","40","50"}};
	JTable table = new JTable(new MyTableModel(data,title));
	JScrollPane pane = new JScrollPane(table);
	Container c = getContentPane();
	public SimpleTableExample2()
	{
		setTitle("Simple Table Example 2");
		setSize(400,300);
		
		table.setRowHeight(30);
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setForeground(Color.blue);
		c.add(pane);
		
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		SimpleTableExample2 ste2 = new SimpleTableExample2();
	}
}
class MyTableModel extends DefaultTableModel
{
	public MyTableModel(Object data[][],String []title)
	{
		int colCount = title.length;
		for(int i = 0 ; i < colCount ; i++)
			this.addColumn(new String(title[i]));
		this.addColumn("Total");
		for(int i = 0 , n = data.length ; i < n;i++)
		{
			int sum =0;
			Object[] obj = new Object[colCount+1];
			int j = 0;
			for(j = 0; j <colCount; j++)
			{
				sum += Integer.valueOf(data[i][j].toString());
				obj[j] = data[i][j];
			}
			obj[j] = ""+sum;
			this.addRow(obj);
		}
	}
}


