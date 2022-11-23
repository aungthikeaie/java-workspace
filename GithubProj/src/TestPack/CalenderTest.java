package TestPack;

import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class CalenderTest extends JFrame implements ActionListener 
{
	JTextArea tf = new JTextArea("",20,30);
	JScrollPane jsp = new JScrollPane(tf);
	//Calendar calender = new GregorianCalendar();
	JButton b = new JButton("Click");
	
	JDateChooser chooser = new JDateChooser();

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	Container c = getContentPane();
	
	
	public CalenderTest()
	{
		setSize(900,800);
		
		//chooser.setLocale(Locale.US);
		
		p1.add(chooser);
		
		p1.add(b);
		
		//p2.add(jsp);
		p2.add(jsp);
		
		c.add("North",p1);
		c.add(p2);
		
		b.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String args[])
	{
		new CalenderTest();
	}

	public void actionPerformed(ActionEvent e) 
	{
		//Insets day = calender.getInsets();
	//	System.out.println(day);
		//Date date=Calendar.getTime();
		//tf.setText(chooser.getDate().toString());

		
		String s=chooser.getDate().toString();
		
		StringTokenizer stk=new StringTokenizer(s);
		stk.nextToken();
		String mm=stk.nextToken();
		String dd=stk.nextToken();
		stk.nextToken();
		stk.nextToken();
		String yy=stk.nextToken();
		System.out.println(dd+"/"+mm+"/"+yy);
		//s.indexOf()
		tf.setText(dd+"/"+mm+"/"+yy);
	
	}
}
