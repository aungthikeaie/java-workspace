package Assignment;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

public class ch20 extends JApplet implements ItemListener,ActionListener 
{
	JMenuBar mb = new JMenuBar();
	
	JMenu 	file = new JMenu("File"),
			format = new JMenu("Format"),
			font = new JMenu("Font"),
			fontcolor = new JMenu("Font Color");
	
	JMenuItem minew = new JMenuItem("New");
	
	JRadioButtonMenuItem 	time = new JRadioButtonMenuItem("Time New Roman"),
							rock = new JRadioButtonMenuItem("Rockwell"),
							arial = new JRadioButtonMenuItem("Arial Black"),
							win = new JRadioButtonMenuItem("Wininnwa");
	
	JCheckBoxMenuItem red = new JCheckBoxMenuItem("Red");
	
	JTextArea ta = new JTextArea();
	
	Container c;
	
	public void init()
	{

		c = getContentPane();
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(time);
		bg.add(rock);
		bg.add(arial);
		bg.add(win);
		
		font.add(time);
		font.add(rock);
		font.add(arial);
		font.add(win);
		
		fontcolor.add(red);
		
		format.add(font);
		format.add(fontcolor);
		
		file.add(minew);
		
		mb.add(file);
		mb.add(format);
		
		setJMenuBar(mb);
		
		time.addItemListener(this);
		rock.addItemListener(this);
		arial.addItemListener(this);
		win.addItemListener(this);
		
		red.addItemListener(this);
		
		minew.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == minew)
		{
			c.add(ta);
			ta.requestFocus();
		}
	}

	public void itemStateChanged(ItemEvent e) 
	{
		Font fontstyle;
		if(time.isSelected())
		{
			fontstyle = new Font("Time New Roman",Font.PLAIN,12);
			ta.setFont(fontstyle);
		}
		if(rock.isSelected())
		{
			fontstyle = new Font("Rockwell",Font.BOLD,14);
			ta.setFont(fontstyle);
		}
		if(arial.isSelected())
		{
			fontstyle = new Font("Arial Black",Font.PLAIN,12);
			ta.setFont(fontstyle);
		}
		if(time.isSelected())
		{
			fontstyle = new Font("Time New Roman",Font.PLAIN,12);
			ta.setFont(fontstyle);
		}
		if(time.isSelected())
		{
			fontstyle = new Font("Time New Roman",Font.PLAIN,12);
			ta.setFont(fontstyle);
		}
		if(red.isSelected())
		{
			ta.setForeground(Color.red);
		}
	}
}
