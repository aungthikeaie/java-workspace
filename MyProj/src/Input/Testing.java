package Input;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Model.CategoryModel;

public class Testing extends JFrame implements ItemListener 
{
	public static JComboBox cb = new JComboBox();
	
	Container c = getContentPane();
	public Testing() throws SQLException
	{
		setTitle("Testing Combobox");
		setSize(400,300);
		//cb.addItem("aa");
		
		CategoryInput.comboAdding();
		//cb.setModel(new DefaultComboBoxModel<Person>(.toArray(new Person[0])));
		
		c.setLayout(new FlowLayout());
		c.add(cb);
		
		setVisible(true);
	}
	public static void main(String args[]) throws SQLException
	{
		new Testing();
		
	}

	public void itemStateChanged(ItemEvent e) 
	{
	
	}
}
