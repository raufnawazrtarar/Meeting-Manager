import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp {

	private JTextField userName;
	private JTextField password;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sign Up");
		frame.setBounds(100, 100, 1128, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.setResizable(false);
		
		
		//User Name text box
				userName = new JTextField();
				userName.setBackground(Color.WHITE);
				userName.setForeground(Color.BLACK);
				userName.setBounds(520, 222, 176, 22);
				frame.getContentPane().add(userName);
				userName.setColumns(10);
				
				//Password Text box	
				password = new JPasswordField();
				password.setForeground(Color.BLACK);
				password.setColumns(10);
				password.setBackground(Color.WHITE);		
				password.setBounds(420, 275, 176, 22);
				frame.getContentPane().add(password);
		
		
		//label to add background picture
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setBackground(Color.WHITE);
	lblNewLabel.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/Signup.png")).getImage();
	lblNewLabel.setIcon(new ImageIcon(img));
	lblNewLabel.setBounds(-47, 0, 1072, 600);
	frame.getContentPane().add(lblNewLabel);
	}

}
