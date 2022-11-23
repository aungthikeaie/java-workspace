import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JComboBox;


public class Hahah {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hahah window = new Hahah();
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
	public Hahah() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 992, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox Bla = new JComboBox();
		Bla.setBounds(49, 13, 144, 22);
		frame.getContentPane().add(Bla);
	}
}
