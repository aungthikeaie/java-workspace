package Assignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JRegistration extends JApplet implements ActionListener 
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2;
	JTextArea ta3;
	JPasswordField pass, cpas;
	JRadioButton r1,r2;
	JCheckBox c1,c2;
	JButton br,bc;
	ButtonGroup bg;
	
	public void init()
	{
		l = new JLabel("Registeration");
		l1 = new JLabel("User Name");
		l2 = new JLabel("Password");
		l3 = new JLabel("Confirm Password");
		l4 = new JLabel("Phone");
		l5 = new JLabel("Address");
		
		c1 = new JCheckBox("Reading");
		c2 = new JCheckBox("Swimming");
		
		bg = new ButtonGroup();
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		bg.add(r1);
		bg.add(r2);
		
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		ta3 = new JTextArea(20,20);
		
		pass = new JPasswordField(20);
		cpas = new JPasswordField(20);
		
		br = new JButton("Register");
		bc = new JButton("Cancel");
		
		JPanel panel = new JPanel();
		panel.add(l);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5,2));
		p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(pass);
		p1.add(l3); p1.add(cpas);
		p1.add(l4); p1.add(t2);
		p1.add(l5); p1.add(ta3);
		
		JPanel ckp = new JPanel();
		Border ckb = BorderFactory.createTitledBorder("Hobby");
		ckp.setBorder(ckb);
		ckp.add(c1);
		ckp.add(c2);
		
		JPanel rp = new JPanel();
		Border rb = BorderFactory.createTitledBorder("Gender");
		rp.setBorder(rb);
		rp.add(r1);
		rp.add(r2);
		
		JPanel cr = new JPanel();
		cr.setLayout(new GridLayout(2,1));
		cr.add(ckp);
		cr.add(rp);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.add(br);
		p3.add(bc);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(3,1));
		p4.add(p1);
		p4.add(cr);
		p4.add(p3);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(p4, BorderLayout.CENTER);
		
		br.addActionListener(this);
		bc.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == br)
		{
			char[] p = pass.getPassword();
			char[] cp = cpas.getPassword();
			
			if(		t1.getText().length() == 0 || t2.getText().length() == 0 ||
					ta3.getText().length() == 0 || (c1.isSelected() == false &&
					c2.isSelected() == false) || (r1.isSelected() == false && r2.isSelected() == false))
				JOptionPane.showMessageDialog(br, "Please, fill complete information", "Incomplete Field",JOptionPane.INFORMATION_MESSAGE);
			
			else
			{
				if(p.length == 0 && cp.length == 0)
				{
					JOptionPane.showMessageDialog(br, "Password Empty","Empty",JOptionPane.ERROR_MESSAGE);
				}
				else if(p.length == 0 || cp.length == 0)
				{
					JOptionPane.showMessageDialog(br, "Password or confirmaiton are left","Password Left",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(isCorrect(p,cp))
						JOptionPane.showMessageDialog(br, "RegisterSuccessful","Successful",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(br, "Password and Confirm Password are Not Match!!!","Not Match",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if(e.getSource() == bc)
		{
			t1.setText(null);
			t2.setText(null);
			ta3.setText(null);
			pass.setText(null);
			cpas.setText(null);
			c1.setSelected(false);
			c2.setSelected(false);
			bg.clearSelection();
		}
	}
	private boolean isCorrect(char[] p, char[] cp)
	{
		if(p.length != cp.length)
			return false;
		else
		{
			for(int i = 0 ; i<p.length; i++)
			{
				if(p[i] != cp[i])
					return false;
			}
		}
		
		return true;
	}
}
