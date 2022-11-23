package Form;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import DataAccess.*;


public class MainFrame extends JFrame implements ActionListener,ItemListener
{
	/*
	 Khin Yadanar Hlaing
 	 October 22 2018(11:00 am)
	 */
	static MainFrame mainFrameObj;
	
	Container c=getContentPane();
	
	JLabel periodlabel=new JLabel("Period");
	JLabel categorylabel=new JLabel("Category");
	JLabel itemlabel=new JLabel("Item");
	
	public static JComboBox periodcombobox = new JComboBox();
	public static JComboBox categorycombobox =  new JComboBox();
	public static JComboBox	itemcombobox = new JComboBox();
	public static JTextField current_textfield = new JTextField();
	
	JButton periodbutton=new JButton("Create");
	JButton categorybutton=new JButton("Create");
	JButton itembutton=new JButton("Create");
	
	JButton period_delete_button=new JButton("Delete");
	JButton category_delete_button=new JButton("Delete");
	JButton item_delete_button=new JButton("Delete");
	
	JButton importbutton=new JButton("Import");
	JButton exportbutton=new JButton("Export");
	JButton viewbutton=new JButton("View");
	JButton topupbutton=new JButton("Top Up");
	JButton exitbutton=new JButton("Exit");
	
	//JFrame mainframe = new JFrame();
	
	//Icon images = new ImageIcon(getClass().getResource("sakura.gif"));
	
	//Container c=getContentPane();
	
	public MainFrame() throws SQLException
	{
		super("Main Frame");
		setLocation(370,150);
		setSize(800,450);
		
		c.setLayout(null);
		
		periodlabel.setBounds(50,50,80,30);
		periodcombobox.setBounds(150,50,300,30);
		periodbutton.setBounds(490,50,100,30);
		period_delete_button.setBounds(630,50,100,30);
		
		categorylabel.setBounds(50,110,80,30);
		categorycombobox.setBounds(150,110,300,30);
		categorybutton.setBounds(490,110,100,30);
		category_delete_button.setBounds(630,110,100,30);
		
		itemlabel.setBounds(50,170,80,30);
		itemcombobox.setBounds(150,170,300,30);
		itembutton.setBounds(490,170,100,30);
		item_delete_button.setBounds(630,170,100,30);
		
		importbutton.setBounds(210,260,100,30);
		exportbutton.setBounds(350,260,100,30);
		viewbutton.setBounds(490,260,100,30);
		topupbutton.setBounds(630,260,100,30);
		
		
		
		exitbutton.setBounds(630,340,100,30);
		
		periodcombobox.setEditable(false);
		categorycombobox.setEditable(false);
		itemcombobox.setEditable(false);
		
		c.add(periodlabel);
		c.add(categorylabel);
		c.add(itemlabel);
		
		c.add(categorycombobox);
		c.add(periodcombobox);
		c.add(itemcombobox);
		
		c.add(periodbutton);
		c.add(categorybutton);
		c.add(itembutton);
		c.add(periodbutton);
		c.add(importbutton);
		c.add(exportbutton);
		c.add(viewbutton);
		c.add(topupbutton);
		c.add(exitbutton);
		c.add(period_delete_button);
		c.add(category_delete_button);
		c.add(item_delete_button);
		
		//Adding Action to Buttons
		periodbutton.addActionListener(this);
		categorybutton.addActionListener(this);
		itembutton.addActionListener(this);
		importbutton.addActionListener(this);
		exportbutton.addActionListener(this);
		exitbutton.addActionListener(this);
		period_delete_button.addActionListener(this);
		category_delete_button.addActionListener(this);
		item_delete_button.addActionListener(this);
		viewbutton.addActionListener(this);
		topupbutton.addActionListener(this);
		categorycombobox.addItemListener(this);
		
		//mainframe.setIconImage((Image) images);
		
		//Adding ComboBoxes
		MainFrameDAO.periodCombo();
		MainFrameDAO.categoryCombo();
		//MainFrameDAO.itemCombo();
		
		
		
		setVisible(true);

	}
	
	public static void main(String []args) throws SQLException
	{
		MainFrame mainObj = new MainFrame();
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() ==  periodbutton)
		{
			Period periodObj = new Period();
		}
		if(e.getSource() == categorybutton)
		{
				Category categoryObj = new Category();
		}
		if(e.getSource() == itembutton)
		{
			Item itemObj = new Item();
		}
		if(e.getSource() == importbutton)
		{
			
			try 
			{
				
				Import importObj = new Import();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == exportbutton)
		{
			Export exportObj = new Export();
		}
		//Action for view
		if(e.getSource() == viewbutton)
		{
			try 
			{
				View viewObj = new View();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		//Action for topup
		if(e.getSource() == topupbutton)
		{
			try 
			{
				TopupView topupObj = new TopupView();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == exitbutton)
		{
			System.exit(0);
		}
		//Action for item delete button
		if(e.getSource()==item_delete_button)
		{
			int i = JOptionPane.showConfirmDialog(this, "Do you want to delete");
			if(i == JOptionPane.YES_OPTION)
			{
				try 
				{
					ItemDAO.deleteItem();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		//Action for category delete button
		if(e.getSource()==category_delete_button)
		{
			int i = JOptionPane.showConfirmDialog(this, "Do you want to delete");
			if(i == JOptionPane.YES_OPTION)
			{
				try 
				{
					CategoryDAO.deleteCategory();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		//Action for period delete button
		if(e.getSource()==period_delete_button)
		{
			int i = JOptionPane.showConfirmDialog(this, "Do you want to delete");
			if(i == JOptionPane.YES_OPTION)
			{
				try 
				{
					PeriodDAO.deletePeriod();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			
		}
	
	}
	public void itemStateChanged(ItemEvent e) 
	{
		try 
		{
			ConnectorCombo.itemCombo();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}
}