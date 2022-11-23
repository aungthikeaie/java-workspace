package Chapter6;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ex1 implements ActionListener
{

	private JFrame frame;
	private JButton addButton;
	private JButton subButton;
	private JButton mulButton;
	private JButton divButton;
	private JTextField first;
	private JTextField second;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex1 window = new ex1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ex1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 198);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		first = new JTextField();
		panel.add(first);
		first.setColumns(10);
		
		second = new JTextField();
		panel.add(second);
		second.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		panel.add(buttonPanel);
		
		addButton = new JButton("+");
		buttonPanel.add(addButton);
		
		subButton = new JButton("-");
		buttonPanel.add(subButton);
		
		mulButton = new JButton("*");
		buttonPanel.add(mulButton);
		
		divButton = new JButton("/");
		buttonPanel.add(divButton);
		
		JPanel resultPanel = new JPanel();
		panel.add(resultPanel);
		
		JLabel lblNewLabel = new JLabel("Result : ");
		resultPanel.add(lblNewLabel);
		
		result = new JTextField();
		resultPanel.add(result);
		result.setColumns(10);
		
		JLabel lblI = new JLabel("input a number in each box");
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblI, BorderLayout.NORTH);
		
		subButton.addActionListener(this);
		addButton.addActionListener(this);
		mulButton.addActionListener(this);
		divButton.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		int a = Integer.parseInt(first.getText());
		int b = Integer.parseInt(second.getText());
		
		if(e.getSource() == addButton)
		{
			int r = a + b;
			result.setText(String.valueOf(r));
		}
		
		if(e.getSource() == subButton)
		{
			int r = a - b;
			result.setText(String.valueOf(r));
		}
		
		if(e.getSource() == mulButton)
		{
			int r = a * b;
			result.setText(String.valueOf(r));
		}
		
		if(e.getSource() == divButton)
		{
			double r = (double)a / (double)b;
			result.setText(String.valueOf(r));
		}
	}

}
