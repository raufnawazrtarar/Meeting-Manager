import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
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
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class GUI {

	private JFrame frame;
	private JFrame signUpFrame;
	private JFrame menuFrame;
	private JTextField userName;
	private JTextField newUserName;
	private JTextField password;
	private JTextField newPassword;
	
	
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
		signUp();
		menu();
		
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		String Username;
	    String Password;

	    Password = "admin";
	    Username = "admin";
		
		
	    
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 1035, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1365,720);
		frame.getContentPane().setLayout(null);
		
		//User Name text box
		userName = new JTextField();
		userName.setBackground(Color.WHITE);
		userName.setForeground(Color.BLACK);
		userName.setBounds(575, 240, 215, 22);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		//Password Text box	
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setColumns(10);
		password.setBackground(Color.WHITE);		
		password.setBounds(575, 323, 215, 22);
		frame.getContentPane().add(password);
		
		JLabel lblInvalidUsernameOr = new JLabel("Invalid username or password");
		lblInvalidUsernameOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInvalidUsernameOr.setForeground(Color.RED);
		lblInvalidUsernameOr.setBounds(575, 157, 215, 16);
		frame.getContentPane().add(lblInvalidUsernameOr);
		lblInvalidUsernameOr.setVisible(false);
		
		//Login button
		JButton login = new JButton("Login");
		login.setForeground(Color.WHITE);
		Border border = new LineBorder(Color.WHITE, 2);
		login.setBorder(border);
		login.setBackground(new Color(18, 72, 180));
		login.setBounds(708, 396, 82, 25);
		frame.getContentPane().add(login);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			    if (userName.getText().equals(Username) && password.getText().equals(Password)) {
			        System.out.println("Access Granted! Welcome!");
			        frame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(true);
			    } else if(login.getText().equals(Username)) {
			    	lblInvalidUsernameOr.setVisible(true);		        
			    } else if (password.getText().equals(Password)) {
			    	lblInvalidUsernameOr.setVisible(true);
			    } else {
			    	lblInvalidUsernameOr.setVisible(true);
			        
			    }
			}
		});
		
		//sign up button
		JButton signUp = new JButton("Sign Up");
		signUp.setForeground(Color.WHITE);		
		signUp.setBorder(border);
		signUp.setBackground(new Color(18, 72, 180));
		signUp.setBounds(575, 396, 82, 25);
		frame.getContentPane().add(signUp);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			signUpFrame.setVisible(true);
	
			
			}
		});
		//exit button
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);		
		exit.setBorder(border);
		exit.setBackground(new Color(18, 72, 180));
		exit.setBounds(654, 560, 82, 25);
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
		lblNewLabel.setBounds(0, 0, 1359, 685);
		frame.getContentPane().add(lblNewLabel);
		
		
		

		
		
	}

	
	public void signUp() {
		
		signUpFrame = new JFrame("SignUp");
		signUpFrame.setBounds(100, 100, 1035, 647);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpFrame.setResizable(false);
		signUpFrame.setSize(1365,720);
		signUpFrame.getContentPane().setLayout(null);
		
		
		//full name text box
		JTextField fullName = new JTextField();
		fullName.setBackground(Color.WHITE);
		fullName.setForeground(Color.BLACK);
		fullName.setBounds(580, 192, 176, 22);
		signUpFrame.getContentPane().add(fullName);
		fullName.setColumns(10);
		
		
		//User Name text box
		newUserName = new JTextField();
		newUserName.setBackground(Color.WHITE);
		newUserName.setForeground(Color.BLACK);
		newUserName.setBounds(580, 265, 176, 22);
		signUpFrame.getContentPane().add(newUserName);
		newUserName.setColumns(10);
		
		//Password Text box	
		newPassword = new JPasswordField();
		newPassword.setForeground(Color.BLACK);
		newPassword.setColumns(10);
		newPassword.setBackground(Color.WHITE);		
		newPassword.setBounds(580, 338, 176, 22);
		signUpFrame.getContentPane().add(newPassword);
		
		//sign up button
		JButton signUp = new JButton("Sign Up");
		signUp.setForeground(Color.WHITE);	
		Border border = new LineBorder(Color.WHITE, 2);
		signUp.setBorder(border);
		signUp.setBackground(new Color(18, 72, 180));
		signUp.setBounds(674, 389, 82, 25);
		signUpFrame.getContentPane().add(signUp);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(newUserName.getText());
				System.out.print(newPassword.getText());
			}
		});
		//back button
		JButton back = new JButton("Back");
		back.setForeground(Color.WHITE);		
		back.setBorder(border);
		back.setBackground(new Color(18, 72, 180));
		back.setBounds(580, 389, 82, 25);
		signUpFrame.getContentPane().add(back);
		back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.setVisible(true);
					signUpFrame.setVisible(false);			
						}
					});
		
		//exit button
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);		
		exit.setBorder(border);
		exit.setBackground(new Color(18, 72, 180));
		exit.setBounds(640, 562, 82, 25);
		signUpFrame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Exit");
					System.exit(0);				
				}
			});
		
		//label to add background picture
		JLabel signUpBackground = new JLabel("");
		signUpBackground.setBackground(Color.WHITE);
		signUpBackground.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/signUp.png")).getImage();
		signUpBackground.setIcon(new ImageIcon(img));
		signUpBackground.setBounds(0, 0, 1359, 685);
		signUpFrame.getContentPane().add(signUpBackground);
	}
	
	public void menu() {
		
		menuFrame = new JFrame("Menu");
		menuFrame.setBounds(100, 100, 1035, 647);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setResizable(false);
		menuFrame.setSize(1365,720);
		menuFrame.getContentPane().setLayout(null);
		
		
		
		//label to add background picture
		JLabel menuBackground = new JLabel("");
		menuBackground.setBackground(Color.WHITE);
		menuBackground.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/menu.png")).getImage();
		menuBackground.setIcon(new ImageIcon(img));
		menuBackground.setBounds(0, 0, 1359, 685);
		menuFrame.getContentPane().add(menuBackground);		
		
		
		
	}
}

