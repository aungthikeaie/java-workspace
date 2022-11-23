package Assignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex3 extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JTextArea ta;
	JComboBox cb;
	JButton b1;
	JPanel p1,p2,p3,p4,p5;
	
	Ex3()
	{
		this.setTitle("ex3");
		this.setSize(350,350);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1 = new JLabel("Name");
		l2 = new JLabel("Department");
		l3 = new JLabel("University");
		l4 = new JLabel("Division");
		l5 = new JLabel("Zip");
		
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(15);
		t4 = new JTextField(5);
		
		cb = new JComboBox();
		cb.addItem("Yangon");
		cb.addItem("Mandalay");
		
		ta = new JTextArea(10,20);
		
		b1 = new JButton("store");
		b1.addActionListener(this);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		p3.add(l3);
		p3.add(t3);
		
		p4.add(l4);
		p4.add(cb);
		p4.add(l5);
		p4.add(t4);
		
		p5.add(ta);
		p5.add(b1);
		
		this.setLayout(new FlowLayout());
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		new Ex3();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		ta.setText("");
		ta.append(t1.)
	}

}
