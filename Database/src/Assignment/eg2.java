package Assignment;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class eg2 extends JFrame implements ActionListener
{
	JMenuBar jb = new JMenuBar();
	
	JMenu file = new JMenu("File");
	
	JMenuItem newit = new JMenuItem("New");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem exit = new JMenuItem("Exit");
	
	JPopupMenu pop = new JPopupMenu();
	
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem paste = new JMenuItem("Paste");
	
	JSeparator jsp = new JSeparator();
	
	JTextArea ta = new JTextArea();
	
	Container c = getContentPane();
	
	public eg2()
	{
		pop.add(copy);
		pop.add(cut);
		pop.add(paste);
		
		file.add(newit);
		file.add(save);
		file.add(open);
		file.add(jsp);
		file.add(exit);
		
		jb.add(file);
		c.add("North",jb);
		
		file.setMnemonic('F');
		newit.setMnemonic('N');
		save.setMnemonic('S');
		open.setMnemonic('O');
		exit.setMnemonic('E');
		
		newit.addActionListener(this);
		save.addActionListener(this);
		open.addActionListener(this);
		exit.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		
		ta.addMouseListener(new MouseAdapter() {
		});
		
	}

	public static void main(String args[])
	{
		JFrame fa = new eg2();
		fa.setBounds(20, 30, 200, 300);
		fa.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) 
	{

	}
	
}