package Session9;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;

public class Test extends JFrame implements ActionListener
{
	JTextField t = new JTextField("Press <Enter>",30);
	
	
	Container c = getContentPane();
	
	public Test()
	{
		setTitle("Test Programe");
		setSize(400,300);
		
		c.setLayout(new FlowLayout());
		t.setHorizontalAlignment(JTextField.RIGHT);
		
		c.add(t);
		
		setVisible(true);
	}
	public static void main(String args[])
	{
		new Test();
	}
	public void actionPerformed(ActionEvent e) 
	{
		
	}

}
