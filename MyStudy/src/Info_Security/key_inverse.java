package Info_Security;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class key_inverse extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1;
	
	JLabel l1 = new JLabel("Enter character code : ");
	JLabel l3 = new JLabel("Enter value of modulus : ");
	JLabel l4 = new JLabel("Inverse key code : ");
	
	JTextField t1 = new JTextField(15);
	JTextField t3 = new JTextField(15);
	JTextField t4 = new JTextField(15);
	
	JButton b1 = new JButton("Calculate");
	JButton b2 = new JButton("Cancle");
	JButton b3 = new JButton("Exit");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	Container c = getContentPane();
	
	public key_inverse() //Constructor 
	{
		setTitle("Finding Key Inverse");
		setSize(500,350);
		setLocation(600,300);
		
		t4.setEditable(false);
		
		//Setting labels and textfields
		p1.setLayout(new GridLayout(3,2));
		p1.add(l1) ; p1.add(t1);
		p1.add(l3) ; p1.add(t3);
		p1.add(l4) ; p1.add(t4);
		
		//Setting buttons
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		//Setting panels
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
		
		//adding actions
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new key_inverse();
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		//For calculate button
		if(e.getSource() == b1)
		{
			//cc = character code : mv = modulus value rs : result
			int cc, mv, rs=0;
			try 
			{
				cc = Integer.parseInt(t1.getText());
				mv = Integer.parseInt(t3.getText());
				
				boolean flag = false;
				
				//Creating to use GCD function
				BigInteger bcc = BigInteger.valueOf(cc);
				BigInteger bmv = BigInteger.valueOf(mv);
				BigInteger brs = bcc.gcd(bmv);
				
				//Checking is GCD of both numbers '1'
				if( brs.intValue() == 1 && cc%mv != 0 && mv%cc !=0)
				{
					flag = true;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Character code and modulus value are not co-prime.");
				}
				
				//if boths of GCD is 1
				if(flag)
				{
					for(int i = 0 ; i < mv ; i++)
					{
						
						if( (cc*i) % mv == 1)
							rs = i;
					}
					t4.setText(String.valueOf(rs));
				}
			} 
			
			catch (Exception e2) 
			{
				JOptionPane.showMessageDialog(this, "MUST ENTER ONLY NUMBER", "Error!", JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
		//For cancel button
		if(e.getSource() == b2)
		{
			t1.setText(null);
			t3.setText(null);
			t4.setText(null);
		}
		
		//For exit button
		if(e.getSource() == b3)
		{
			System.exit(0);
		}
	}
}
