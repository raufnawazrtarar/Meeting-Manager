import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField fullName;
	private JTextField userName;
	private JTextField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setSize(1280,720);
		contentPane.setLayout(null);
		
		//full name text box
		fullName = new JTextField();
		fullName.setBackground(Color.WHITE);
		fullName.setForeground(Color.BLACK);
		fullName.setBounds(580, 192, 176, 22);
		getContentPane().add(fullName);
		fullName.setColumns(10);
		
		
		//User Name text box
		userName = new JTextField();
		userName.setBackground(Color.WHITE);
		userName.setForeground(Color.BLACK);
		userName.setBounds(580, 265, 176, 22);
		getContentPane().add(userName);
		userName.setColumns(10);
		
		//Password Text box	
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setColumns(10);
		password.setBackground(Color.WHITE);		
		password.setBounds(580, 338, 176, 22);
		getContentPane().add(password);
		
		//sign up button
		JButton signUp = new JButton("Sign Up");
		signUp.setForeground(Color.WHITE);	
		Border border = new LineBorder(Color.WHITE, 2);
		signUp.setBorder(border);
		signUp.setBackground(new Color(18, 72, 180));
		signUp.setBounds(674, 389, 82, 25);
		getContentPane().add(signUp);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(userName.getText());
				System.out.print(password.getText());
			}
		});
		
		//label to add background picture
		JLabel signUpBackground = new JLabel("");
		signUpBackground.setBackground(Color.WHITE);
		signUpBackground.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/signUp.png")).getImage();
		signUpBackground.setIcon(new ImageIcon(img));
		signUpBackground.setBounds(0, 0, 1274, 685);
		getContentPane().add(signUpBackground);
	}
}
