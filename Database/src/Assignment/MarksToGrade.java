package Assignment;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarksToGrade extends JFrame implements ActionListener
{
	JLabel l1 = new JLabel("English");
	JLabel l2 = new JLabel("201-Java");
	JLabel l3 = new JLabel("202-Mathematics");
	JLabel l4 = new JLabel("203-DS in Java");
	JLabel l5 = new JLabel("204-SAD");
	JLabel l6 = new JLabel("205-JavaScript+HCI");
	JLabel l7 = new JLabel("206-OOSD");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	
	JButton b1 = new JButton("Marks To Grade");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	Container c = getContentPane();
	
	
	public MarksToGrade()
	{
		setTitle("Marks to Grade");
		setBounds(30, 30, 300, 200);
		
		p1.setLayout(new GridLayout(7,2));
		p1.setBorder(BorderFactory.createTitledBorder("Second Year-CS"));
		p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(t2);
		p1.add(l3); p1.add(t3);
		p1.add(l4); p1.add(t4);
		p1.add(l5); p1.add(t5);
		p1.add(l6); p1.add(t6);
		p1.add(l7); p1.add(t7);
		
		p2.add(b1);
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		c.add(p1);
		c.add("South",p2);
		
		b1.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new MarksToGrade();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == b1)
		{
			String msg = "Your Grade is:\n";
			if(		t1.getText().length() == 0 || t2.getText().length() == 0 ||
					t3.getText().length() == 0 || t4.getText().length() == 0 ||
					t5.getText().length() == 0 || t6.getText().length() == 0 ||
					t7.getText().length() == 0	)
				JOptionPane.showMessageDialog(null, "Please, Complete Info","Message",JOptionPane.INFORMATION_MESSAGE);
			
			else
			{
				try
				{
					int eng = Integer.parseInt(t1.getText());
					int java = Integer.parseInt(t2.getText());
					int math = Integer.parseInt(t3.getText());
					int ds = Integer.parseInt(t4.getText());
					int sad = Integer.parseInt(t5.getText());
					int js = Integer.parseInt(t6.getText());
					int oosd = Integer.parseInt(t7.getText());
					int avgmarks = (eng+java+math+ds+sad+js+oosd)/7;
					
					int imarks[] = {eng,java,math,ds,sad,js,oosd,avgmarks};
					
					if(		imarks[0]<0 || imarks[0]>100 ||
							imarks[1]<0 || imarks[1]>100 ||
							imarks[2]<0 || imarks[2]>100 ||
							imarks[3]<0 || imarks[3]>100 ||
							imarks[4]<0 || imarks[4]>100 ||
							imarks[5]<0 || imarks[5]>100 ||
							imarks[6]<0 || imarks[6]>100 ||
							imarks[7]<0 || imarks[7]>100 )
						JOptionPane.showMessageDialog(null, "Wrong Marks.Please enter your marks between 0 and 100.","MarksError",JOptionPane.ERROR_MESSAGE);
					else
					{
						String res[] = new String[8];
						for(int i = 0 ; i<imarks.length; i++)
						{
							res[i] = getGrade(imarks[i]);
						}
						msg += "English:"+res[0]+
								"\n201:"+res[1]+
								"\n202:"+res[2]+
								"\n203:"+res[3]+
								"\n204:"+res[4]+
								"\n205:"+res[5]+
								"\n206:"+res[6]+
								"\nAverageGrade:"+res[7];
						
						JOptionPane.showMessageDialog(null, msg,"Grade",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Please, only enter number.","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
		
	}
	private String getGrade(int marks)
	{
		if(marks>=81 && marks<=100)
			return "A";
		else if(marks>=61 && marks<=80)
			return "B";
		else if(marks>=41 && marks<=60)
			return "C";
		else if(marks>=21 && marks<=40)
			return "D";
		else if(marks>=0 && marks<=20)
			return "E";
		
		return null;
	}

}
