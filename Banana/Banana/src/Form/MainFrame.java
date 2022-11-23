package Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.*;

import Connector.CategoryTesting;
import Connector.ItemTesting;
import Connector.PeriodTesting;
import DAO.ConnectionComboboxs;
import DAO.ItemDAO;
import DAO.MainDAO;
import DAO.ViewDAO;
import Model.CategoryModel;

public class MainFrame extends JFrame implements ActionListener,ItemListener
{
	/*Khin Yadanar Hlaing
	Write GUI (2.11.2018)*/
	
	JMenuBar mbar=new JMenuBar();
	JMenu setupmenu=new JMenu("Set Up");
	
	JButton editperiod=new JButton();
	JButton deleteperiod=new JButton();
	
	JButton editcategory=new JButton();
	JButton deletecategory=new JButton();
	
	JButton edititem=new JButton();
	JButton deleteitem=new JButton();
	
	JMenuItem periodmenuitem=new JMenuItem("Period");
	JMenuItem categorymenuitem=new JMenuItem("Category");
	JMenuItem itemmenuitem=new JMenuItem("Item");
	
	
	public static JComboBox periodcombobox=new JComboBox();
	public static JComboBox categorycombobox=new JComboBox();
	public static JComboBox itemcombobox=new JComboBox();
	
	JLabel periodlabel=new JLabel("Period");
	JLabel categorylabel=new JLabel("Category");
	JLabel itemlabel=new JLabel("Item");
	
	JButton iteminbutton=new JButton("Item In");
	JButton itemoutbutton=new JButton("Item Out");
	
	public static JFrame frame=new JFrame();
	
	public MainFrame() throws SQLException
	{
		frame.setTitle("Main Frame");
		//frame.setSize(1700,900);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setLocation(0,0);
		//frame.setResizable(true);
		
	    mbar.setBounds(0,0,2000,25);
		
		//periodlabel.setBounds(150,30,50,25);
	    periodlabel.setBounds(50,30,50,25);
		periodcombobox.setBounds(50,65,250,25);
		
		//categorylabel.setBounds(530,30,60,25);
		categorylabel.setBounds(440,30,60,25);
		categorycombobox.setBounds(440,65,250,25);
		
		//itemlabel.setBounds(920,30,50,25);
		itemlabel.setBounds(830,30,50,25);
		itemcombobox.setBounds(830,65,250,25);
		
		iteminbutton.setBounds(1500,60,100,30);
		itemoutbutton.setBounds(1700,60,100,30);
		
		deleteperiod.setIcon(new ImageIcon("Del.png"));
		deleteperiod.setBounds(310,65,25,30);
		editperiod.setIcon(new ImageIcon("Edit.png"));
		editperiod.setBounds(345,65,25,30);
		
		deleteitem.setIcon(new ImageIcon("Del.png"));
		deleteitem.setBounds(1090,65,25,30);
		edititem.setIcon(new ImageIcon("Edit.png"));
		edititem.setBounds(1125,65,25,30);
		
		deletecategory.setIcon(new ImageIcon("Del.png"));
		deletecategory.setBounds(700,65,25,30);
		editcategory.setIcon(new ImageIcon("Edit.png"));
		editcategory.setBounds(740,65,25,30);
		
		
		
		setupmenu.add(periodmenuitem);
		setupmenu.add(categorymenuitem);
		setupmenu.add(itemmenuitem);
		
		mbar.add(setupmenu);
		
		frame.setLayout(null);
		frame.add(mbar);
		frame.add(periodlabel);
		frame.add(periodcombobox);
		frame.add(categorylabel);
		frame.add(categorycombobox);
		frame.add(itemlabel);
		frame.add(itemcombobox);
		frame.add(iteminbutton);
		frame.add(itemoutbutton);
		frame.add(deletecategory);
		frame.add(deleteitem);
		frame.add(deleteperiod);
		frame.add(editcategory);
		frame.add(edititem);
		frame.add(editperiod);
	
		//adding action listener
		iteminbutton.addActionListener(this);
		itemoutbutton.addActionListener(this);
		editcategory.addActionListener(this);
		edititem.addActionListener(this);
		editperiod.addActionListener(this);
		deletecategory.addActionListener(this);
		deleteitem.addActionListener(this);
		deleteperiod.addActionListener(this);
		categorycombobox.addItemListener(this);
		itemmenuitem.addActionListener(this);
		periodmenuitem.addActionListener(this);
		categorymenuitem.addActionListener(this);
		periodcombobox.addActionListener(this);
		itemcombobox.addActionListener(this);
		
		MainDAO.periodCombo();
		MainDAO.categoryCombo();
		
		
		
	
		//MainFrame.itemcombobox.
		/*
		CategoryTesting testing=new CategoryTesting();
		ItemDAO.getItem(category)
		MainFrame.categorycombobox.setModel(new DefaultComboBoxModel(CategoryDAO.getCategory()));*/
		//periodcombobox.setModel(new DefaultComboBoxModel(PeriodDAO.getPeriod()));
		
	
		frame.setVisible(true);
	}
	public static void main(String []args) throws SQLException
	{
		new MainFrame();
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==iteminbutton)
		{
			new Import();
		}
		
		if(e.getSource()==itemoutbutton)
		{
			new Export();
		}
		
		if(e.getSource()==deletecategory)
		{
			int r = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
			if(r == JOptionPane.YES_OPTION)
			{
				try 
				{
					CategoryTesting.deleteTest();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==deleteitem)
		{
			int r = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
			if(r == JOptionPane.YES_OPTION)
			{
				try 
				{
					ItemTesting.deleteTest();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==deleteperiod)
		{
			int r = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
			if(r == JOptionPane.YES_OPTION)
			{
				try 
				{
					PeriodTesting.deleteTest();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==editcategory)
		{
			new EditCategory();
		}
		
		if(e.getSource()==edititem)
		{
			new EditItem();
		}
		
		if(e.getSource()==editperiod)
		{
			new EditPeriod();
		}
		
		if(e.getSource()==itemmenuitem)
		{
			try 
			{
				new Item();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==categorymenuitem)
		{
			new Category();
		}
		
		if(e.getSource()==periodmenuitem)
		{
			new Period();
		}
		
		
	}

	public void itemStateChanged(ItemEvent e) 
	{
		try 
		{
			ConnectionComboboxs.itemCombo();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		if(e.getSource()==categorycombobox)
		{
			try 
			{
				ViewDAO.viewFunction();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource()==periodcombobox)
		{
			try 
			{
				ViewDAO.viewFunction();
				
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource()==itemcombobox)
		{
			try 
			{
				ViewDAO.viewFunction();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	
}
