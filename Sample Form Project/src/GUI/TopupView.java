package GUI;

import java.awt.Container;

import javax.swing.*;

public class TopupView extends JFrame 
{
	JLabel topup_title = new JLabel("Mandalay Technological University");
	JLabel topup_category = new JLabel("Stationay");
	
	String table_title[] = {"No","Name","Unit","Stock In Hand","Ground In Hand","Remark"};
	String table_value[][] = {
			{"1","Kyat Mway","Lone","58","58",""},
			{"2","Trash","Pone","51","51",""}};
	
	JTable topup_table = new JTable(table_value,table_title);
	JScrollPane topup_scrollpane = new JScrollPane(topup_table);
	
	Container topup_container = getContentPane();
	
	public TopupView()
	{
		setTitle("Top Up View");
		setSize(1400,1000);
		setLocation(250,30);
		
		topup_container.setLayout(null);
		
		topup_title.setBounds(600,30,700,20);
		topup_category.setBounds(20,50,250,20);
		topup_scrollpane.setBounds(10,100,1360,840);
		
		topup_container.add(topup_category);
		topup_container.add(topup_title);
		topup_container.add(topup_scrollpane);
		
		setVisible(true);
	}
	public static void main(String []args)
	{
		TopupView topup = new TopupView();
	}
}
