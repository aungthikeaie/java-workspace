package Session9;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GridBagTest extends JFrame implements ActionListener
{
	JButton b1 = new JButton("Button 1");
	JButton b2 = new JButton("Button 2");
	JButton b3 = new JButton("Button 3");
	JButton b4 = new JButton("Button 4");
	JButton b5 = new JButton("Button 5");
	JButton b6 = new JButton("Button 6");
	JButton b7 = new JButton("Button 7");
	JButton b8 = new JButton("Button 8");
	JButton b9 = new JButton("Button 9");
	JButton b10 = new JButton("Button 10");
	
	Container c = getContentPane();
	 
	public GridBagTest()
	{
		setTitle("Frist Program");
		setSize(400,300);
	
		c.setLayout(new GridBagLayout());
		
		GridBagConstraints gb = new GridBagConstraints();
		gb.fill = GridBagConstraints.BOTH;
		
		gb.gridx = 0;
		gb.gridy = 0;
		c.add(b1,gb);
		
		gb.gridx = 1;
		gb.gridy = 0;
		c.add(b2,gb);
		
		gb.gridx = 2;
		gb.gridy = 0;
		c.add(b3,gb);
		
		gb.gridx = 3;
		gb.gridy = 0;
		//gb.gridwidth = GridBagConstraints.REMAINDER;
		c.add(b4);
		
		gb.gridx = 0;
		gb.gridy = 1;
		gb.gridwidth = GridBagConstraints.REMAINDER;
		c.add(b5,gb);
		
		gb.gridx = 0;
		gb.gridy = 2;
		gb.gridwidth = 3;
		c.add(b6,gb);
		
		gb.gridx = 3;
		gb.gridy = 2;
		gb.gridwidth = GridBagConstraints.REMAINDER;
		c.add(b7,gb);
		
		gb.gridx = 0;
		gb.gridy = 3;
		gb.gridwidth = 1;
		gb.gridheight = 2;
		c.add(b8,gb);
		
		gb.gridheight = 1;
		gb.gridx = 1;
		gb.gridy = 3;
		gb.gridwidth = GridBagConstraints.REMAINDER;
		c.add(b9,gb);
		
		gb.gridx = 1;
		gb.gridy = 4;
		gb.gridwidth = GridBagConstraints.REMAINDER;
		c.add(b10,gb);
		
		//pack();
		setVisible(true);
	}
	public static void main(String args[])
	{
		new GridBagTest();
	}

	public void actionPerformed(ActionEvent e) 
	{

	}
}
