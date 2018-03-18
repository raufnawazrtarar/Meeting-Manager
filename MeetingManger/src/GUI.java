import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class GUI {

	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	private JPasswordField passwordField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String Username;
	    String Password;

	    Password = "admin";
	    Username = "admin";
		
		
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 1035, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//User Name text box
		userName = new JTextField();
		userName.setBackground(Color.WHITE);
		userName.setForeground(Color.BLACK);
		userName.setBounds(420, 222, 176, 22);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		//Password Text box	
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setColumns(10);
		password.setBackground(Color.WHITE);		
		password.setBounds(420, 275, 176, 22);
		frame.getContentPane().add(password);
		
		
		//Login button
		JButton login = new JButton("Login");
		login.setForeground(Color.WHITE);
		Border border = new LineBorder(Color.WHITE, 2);
		login.setBorder(border);
		login.setBackground(new Color(18, 72, 180));
		login.setBounds(514, 331, 82, 25);
		frame.getContentPane().add(login);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(userName.getText());
				System.out.print(password.getText());
				

			    if (userName.getText().equals(Username) && password.getText().equals(Password)) {
			        System.out.println("Access Granted! Welcome!");
			    } else if(login.getText().equals(Username)) {
			        System.out.println("Invalid Password!");
			    } else if (password.getText().equals(Password)) {
			        System.out.println("Invalid Username!");
			    } else {
			        System.out.println("Invalid Username & Password!");
			    }
			}
		});
		
		//sign up button
		JButton signUp = new JButton("Sign Up");
		signUp.setForeground(Color.WHITE);		
		signUp.setBorder(border);
		signUp.setBackground(new Color(18, 72, 180));
		signUp.setBounds(420, 331, 82, 25);
		frame.getContentPane().add(signUp);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(userName.getText());
				System.out.print(password.getText());
			}
		});
		//exit button
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);		
		exit.setBorder(border);
		exit.setBackground(new Color(18, 72, 180));
		exit.setBounds(466, 434, 82, 25);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Exit");
				System.exit(0);				
			}
		});
		
		
	
	
		//label to add background picture
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-47, 0, 1072, 600);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(514, 331, 82, 25);
		frame.getContentPane().add(passwordField);
		
		
	}
}
