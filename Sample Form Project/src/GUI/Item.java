package GUI;

import java.awt.*;


import javax.swing.*;

public class Item extends JFrame
{	
	JLabel itemlabel = new JLabel("Item");
	JLabel newitemlabel = new JLabel("Item");
	JLabel newunitlabel = new JLabel("Unit");
	JLabel newbincardlabel = new JLabel("BinCard Number");
	
	JTextField newitemtextfield = new JTextField();
	JTextField newunittextfield = new JTextField();
	JTextField newbincardtextfield = new JTextField();
	
	JButton newitemcreate = new JButton("Create");
	JButton newitemcancel = new JButton("Cancel");
	JButton itemdelete = new JButton("Delete");
	JButton itemconfirm = new JButton("Confirm");
	JButton itemcancel = new JButton("Cancel");
	
	JComboBox itemcombobox = new JComboBox();
	
	JCheckBox itemcheckbox = new JCheckBox("Create New Item");
	
	JPanel itempanel = new JPanel();
	
	Container itemcontainer = getContentPane();
	
	public Item()
	{
		setTitle("Item");
		setSize(700,500);
		setLocation(600,300);
		
		itemcontainer.setLayout(null);
		itempanel.setLayout(null);
		
		itemlabel.setBounds(50, 20, 100, 20);//add 20 pixels
		newitemlabel.setBounds(30,50,100,20);//sub 50 pixels
		newunitlabel.setBounds(30,100,100,20);//sub 50 pixels
		newbincardlabel.setBounds(30,150,100,20);//sub 50 pixels
		
		newitemtextfield.setBounds(150,50,250,20);//sub 50 pixels
		newunittextfield.setBounds(150,100,250,20);//sub 50 pixels
		newbincardtextfield.setBounds(150,150,250,20);//sub 50 pixels
		
		newitemcreate.setBounds(430,200,80,20);
		newitemcancel.setBounds(530,200,80,20);
		
		itemdelete.setBounds(350,400,80,20);
		itemconfirm.setBounds(450,400,80,20);
		itemcancel.setBounds(550,400,80,20);
		
		itemcombobox.setBounds(170, 20, 250, 20);//adding 20 pixels
		
		itemcheckbox.setBounds(170, 70, 200, 20);//adding 20 pixels
		
		itempanel.setBounds(20,120,650,250);
		
		itempanel.add(newitemlabel);
		itempanel.add(newunitlabel);
		itempanel.add(newbincardlabel);
		itempanel.add(newitemcreate);
		itempanel.add(newitemcancel);
		itempanel.add(newitemtextfield);
		itempanel.add(newunittextfield);
		itempanel.add(newbincardtextfield);
		itempanel.setBorder(BorderFactory.createTitledBorder("New Item"));
		
		itemcontainer.add(itemlabel);
		itemcontainer.add(itemcombobox);
		itemcontainer.add(itemcheckbox);
		itemcontainer.add(itempanel);
		itemcontainer.add(itemdelete);
		itemcontainer.add(itemconfirm);
		itemcontainer.add(itemcancel);
	
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		Item item = new Item();
	}
}
