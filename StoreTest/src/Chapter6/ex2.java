package Chapter6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ex2 implements KeyListener 
{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex2 window = new ex2();
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
	public ex2() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEnterText = new JLabel("Enter Text");
		lblEnterText.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblEnterText, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		textField.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == 10)
		{
			textField.setText(textField.getText().toUpperCase());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
