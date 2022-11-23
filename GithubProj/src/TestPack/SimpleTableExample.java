package TestPack;

import java.awt.*;

import javax.swing.*;

public class SimpleTableExample extends JFrame
{
	String []columns = {"Name","Telephone","City","Company"};
	String [][] values = {
			{"Mr.X","703-4228989","Herndon","Bell Atlantic"},
			{"Mr.Z","301-6748989","Rockville","Artesia Tech"},
			{"Mr.W","703-4258999","Herndon","Intersect Soft"},
			{"Mr.A","703-7864456","Herndon","Intelsat"}};
	
	JTable table = new JTable(values,columns);
	JScrollPane pane = new JScrollPane(table);
	
	Container c = getContentPane();
	
	public SimpleTableExample()
	{
		setTitle("Simple Table Example");
		setSize(600,300);
		
		c.add(pane);
		
		setVisible(true);
	}
	public static void main(String[] args)
	{
		SimpleTableExample ste = new SimpleTableExample();
	}
}
