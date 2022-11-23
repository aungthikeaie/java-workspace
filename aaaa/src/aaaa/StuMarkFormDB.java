package aaaa;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class StuMarkFormDB extends JFrame implements ActionListener
{    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    private JTextField t1,t2,t3,t4,t5;
    private JComboBox c1,c2,c3;
    private JButton b1;
    private JPanel p1,p2,p3;
    private String[] sub1 ={"Oracle","J2SE","J2EE"}; 
    private String[] sub2 ={"J2SE","J2EE","Oracle"};
    private String[] sub3 ={"J2EE","J2SE","Oracle"};
    
    public StuMarkFormDB()
    {
        super("Student's Marks System");
        setSize(300, 500);
        setLocation(100, 100);
        
        l1 = new JLabel("Student Name");
        l2 = new JLabel("Student RollNo");
        l3 = new JLabel("Subject1");
        l4 = new JLabel("Mark1");
        l5 = new JLabel("Subject2");
        l6 = new JLabel("Mark2");
        l7 = new JLabel("Subject3");
        l8 = new JLabel("Mark3");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        
        c1 = new JComboBox(sub1);
        c2 = new JComboBox(sub2);
        c3 = new JComboBox(sub3);
        
        b1 = new JButton("Save");
        b1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(8,2));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(c1);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(c2);
        p1.add(l6);
        p1.add(t4);
        p1.add(l7);
        p1.add(c3);
        p1.add(l8);
        p1.add(t5);
        
        p2 = new JPanel();
        p2.add(b1);
                
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(p1,BorderLayout.CENTER);
        c.add(p2,BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        new StuMarkFormDB();
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}