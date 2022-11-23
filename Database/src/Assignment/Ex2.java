package Assignment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex2 extends JFrame implements ActionListener,ItemListener 
{
	JTextField t1;
	JTextArea ta;
	JButton b1;
	JComboBox cb;
	JPanel p1,p2;
	
	
	public Ex2()
	{
		this.setTitle("ex  2");
		this.setSize(450, 200);
		this.setLocation(300,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		t1 = new JTextField(10);
		ta = new JTextArea(10,15);
		b1 = new JButton("store");
		cb = new JComboBox();
		p1 = new JPanel();
		p2 = new JPanel();
		
		p1.add(t1);
		p1.add(ta);
		p1.add(cb);
		
		p2.add(b1);
		b1.addActionListener(this);
		cb.addItemListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(p1, BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Ex2();
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		t1.setText(cb.getSelectedItem().toString());
	}

	public void actionPerformed(ActionEvent e) 
	{
			
			if(e.getSource() == b1)
			{
				cb.addItem(t1.getText());
				ta.append(t1.getText()+"\n");
			}
	}

}
