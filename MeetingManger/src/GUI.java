import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JComboBox;
import java.util.Date;

public class GUI {

	
	private JFrame loginFrame;
	private JFrame signUpFrame;
	private JFrame menuFrame;
	private JFrame addMeetingFrame;
	private JFrame viewMeetingFrame;
	private JFrame editFrame;
	private JFrame searchFrame;
	private JFrame deleteFrame;
	private JFrame undoFrame;
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
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Initialize the contents of the login frame.
	 */
	public void login() {
		
		String Username;
	    String Password;

	    Password = "admin";
	    Username = "admin";
		
		
	    
		loginFrame = new JFrame("Login");
		loginFrame.setBounds(100, 100, 1035, 647);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setSize(1365,720);
		loginFrame.getContentPane().setLayout(null);
		
		//User Name text box
		userName = new JTextField();
		userName.setBackground(Color.WHITE);
		userName.setForeground(Color.BLACK);
		userName.setBounds(575, 240, 215, 22);
		loginFrame.getContentPane().add(userName);
		userName.setColumns(10);
		
		//Password Text box	
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setColumns(10);
		password.setBackground(Color.WHITE);		
		password.setBounds(575, 323, 215, 22);
		loginFrame.getContentPane().add(password);
		
		JLabel lblInvalidUsernameOr = new JLabel("Invalid username or password");
		lblInvalidUsernameOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInvalidUsernameOr.setForeground(Color.RED);
		lblInvalidUsernameOr.setBounds(575, 157, 215, 16);
		loginFrame.getContentPane().add(lblInvalidUsernameOr);
		lblInvalidUsernameOr.setVisible(false);
		
		//Login button
		JButton login = new JButton("Login");
		login.setForeground(Color.WHITE);
		Border border = new LineBorder(Color.WHITE, 2);
		login.setBorder(border);
		login.setBackground(new Color(18, 72, 180));
		login.setBounds(708, 396, 82, 25);
		loginFrame.getContentPane().add(login);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			    if (userName.getText().equals(Username) && password.getText().equals(Password)) {
			        System.out.println("Access Granted! Welcome!");
			        loginFrame.setVisible(false);
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
		loginFrame.getContentPane().add(signUp);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginFrame.setVisible(false);
				signUpFrame.setVisible(true);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
	
			
			}
		});
		//exit button
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);		
		exit.setBorder(border);
		exit.setBackground(new Color(18, 72, 180));
		exit.setBounds(654, 560, 82, 25);
		loginFrame.getContentPane().add(exit);
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
		loginFrame.getContentPane().add(lblNewLabel);
		
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
					loginFrame.setVisible(true);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);			
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
		
		JButton viewMeetingBtn = new JButton("");
		viewMeetingBtn.setBounds(34, 22, 106, 86);
		menuFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.setOpaque(false);
		viewMeetingBtn.setContentAreaFilled(false);
		viewMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("view meeting");
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(true);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
								
				}
			});
		
		JButton addMeetingBtn = new JButton("");
		addMeetingBtn.setBounds(34, 127, 106, 86);
		menuFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.setOpaque(false);
		addMeetingBtn.setContentAreaFilled(false);
		addMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("add meeting");
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(true);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton editMeetingBtn = new JButton("");
		editMeetingBtn.setBounds(34, 227, 106, 93);
		menuFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.setOpaque(false);
		editMeetingBtn.setContentAreaFilled(false);
		editMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("edit meeting");	
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(true);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton searchMeetingBtn = new JButton("");
		searchMeetingBtn.setBounds(34, 333, 106, 102);
		menuFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.setOpaque(false);
		searchMeetingBtn.setContentAreaFilled(false);
		searchMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Search meeting");	
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(true);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton deleteMeetingBtn = new JButton("");
		deleteMeetingBtn.setBounds(34, 448, 106, 86);
		menuFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.setOpaque(false);
		deleteMeetingBtn.setContentAreaFilled(false);
		deleteMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Delete meeting");		
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(true);
					undoFrame.setVisible(false);
				}
			});

		JButton undoBtn = new JButton("");
		undoBtn.setBounds(34, 548, 106, 112);
		menuFrame.getContentPane().add(undoBtn);
		undoBtn.setOpaque(false);
		undoBtn.setContentAreaFilled(false);
		undoBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(undoBtn);
		undoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Undo");
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(true);
				}
			});
		
		JButton logoutBtn = new JButton("");
		logoutBtn.setBounds(1268, 599, 91, 86);
		menuFrame.getContentPane().add(logoutBtn);
		logoutBtn.setOpaque(false);
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(logoutBtn);
		logoutBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Logout");	
					password.setText("");
					userName.setText("");
					loginFrame.setVisible(true);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		//label to add background picture
		JLabel menuBackground = new JLabel("");
		menuBackground.setBackground(Color.WHITE);
		menuBackground.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/menu.png")).getImage();
		menuBackground.setIcon(new ImageIcon(img));
		menuBackground.setBounds(0, 0, 1359, 685);
		menuFrame.getContentPane().add(menuBackground);		
			
		
	}
	
public void viewMeetings() {
		
		viewMeetingFrame = new JFrame("view meetings");
		viewMeetingFrame.setBounds(100, 100, 1035, 647);
		viewMeetingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewMeetingFrame.setResizable(false);
		viewMeetingFrame.setSize(1359, 720);
		viewMeetingFrame.getContentPane().setLayout(null);
		
		
		JButton viewMeetingBtn = new JButton("");
		viewMeetingBtn.setBounds(34, 22, 106, 86);
		viewMeetingFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.setOpaque(false);
		viewMeetingBtn.setContentAreaFilled(false);
		viewMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("view meeting");
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(true);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
								
				}
			});
		
		JButton addMeetingBtn = new JButton("");
		addMeetingBtn.setBounds(1, 110, 181, 102);
		viewMeetingFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.setOpaque(false);
		addMeetingBtn.setContentAreaFilled(false);
		addMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("add meeting");
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(true);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);

				}
			});
		
		JButton editMeetingBtn = new JButton("");
		editMeetingBtn.setBounds(34, 227, 106, 93);
		viewMeetingFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.setOpaque(false);
		editMeetingBtn.setContentAreaFilled(false);
		editMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("edit meeting");	
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(true);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton searchMeetingBtn = new JButton("");
		searchMeetingBtn.setBounds(34, 333, 106, 102);
		viewMeetingFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.setOpaque(false);
		searchMeetingBtn.setContentAreaFilled(false);
		searchMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Search meeting");	
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(true);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton deleteMeetingBtn = new JButton("");
		deleteMeetingBtn.setBounds(34, 448, 106, 86);
		viewMeetingFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.setOpaque(false);
		deleteMeetingBtn.setContentAreaFilled(false);
		deleteMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Delete meeting");	
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(true);
					undoFrame.setVisible(false);
				}
			});

		JButton undoBtn = new JButton("");
		undoBtn.setBounds(34, 548, 106, 112);
		viewMeetingFrame.getContentPane().add(undoBtn);
		undoBtn.setOpaque(false);
		undoBtn.setContentAreaFilled(false);
		undoBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(undoBtn);
		undoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Undo");
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(true);
				}
			});
		
		JButton logoutBtn = new JButton("");
		logoutBtn.setBounds(1268, 599, 91, 86);
		viewMeetingFrame.getContentPane().add(logoutBtn);
		logoutBtn.setOpaque(false);
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(logoutBtn);
		logoutBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Logout");	
					password.setText("");
					userName.setText("");
					loginFrame.setVisible(true);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		
		
		//label to add background picture
		JLabel viewMeetingMenuBackground = new JLabel("");
		viewMeetingMenuBackground.setBackground(Color.WHITE);
		viewMeetingMenuBackground.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/viewMeetingMenu.png")).getImage();
		viewMeetingMenuBackground.setIcon(new ImageIcon(img));
		viewMeetingMenuBackground.setBounds(0, 0, 1359, 720);
		viewMeetingFrame.getContentPane().add(viewMeetingMenuBackground);				
		
}
	

public void addMeetings() {


	
	addMeetingFrame = new JFrame("Add meetings");
	addMeetingFrame.setBounds(100, 100, 1035, 647);
	addMeetingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addMeetingFrame.setResizable(false);
	addMeetingFrame.setSize(1359, 720);
	addMeetingFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(34, 22, 106, 86);
	addMeetingFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(true);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 110, 181, 102);
	addMeetingFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(true);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton editMeetingBtn = new JButton("");
	editMeetingBtn.setBounds(34, 227, 106, 93);
	addMeetingFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.setOpaque(false);
	editMeetingBtn.setContentAreaFilled(false);
	editMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("edit meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(true);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(34, 333, 106, 102);
	addMeetingFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(true);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(34, 448, 106, 86);
	addMeetingFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(true);
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(34, 548, 106, 112);
	addMeetingFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(true);
			}
		});
	
	JButton logoutBtn = new JButton("");
	logoutBtn.setBounds(1268, 599, 91, 86);
	addMeetingFrame.getContentPane().add(logoutBtn);
	logoutBtn.setOpaque(false);
	logoutBtn.setContentAreaFilled(false);
	logoutBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(logoutBtn);
	logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Logout");	
				loginFrame.setVisible(true);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	

	//label to add background picture
	JLabel addMeetingMenuBackground = new JLabel("");
	addMeetingMenuBackground.setBackground(Color.WHITE);
	addMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/addMeetingMenu.png")).getImage();
	addMeetingMenuBackground.setIcon(new ImageIcon(img));
	addMeetingMenuBackground.setBounds(0, 0, 1359, 720);
	addMeetingFrame.getContentPane().add(addMeetingMenuBackground);				
	
}

public void editMeetings() {
	
	editFrame = new JFrame("Add meetings");
	editFrame.setBounds(100, 100, 1035, 647);
	editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	editFrame.setResizable(false);
	editFrame.setSize(1359, 720);
	editFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(34, 22, 106, 86);
	editFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(true);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 110, 181, 102);
	editFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(true);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton editMeetingBtn = new JButton("");
	editMeetingBtn.setBounds(1, 237, 181, 102);
	editFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.setOpaque(false);
	editMeetingBtn.setContentAreaFilled(false);
	editMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("edit meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(true);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(34, 333, 106, 102);
	editFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(true);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(34, 448, 106, 86);
	editFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(true);
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(34, 548, 106, 112);
	editFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	editFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(true);
			}
		});
	
	JButton logoutBtn = new JButton("");
	logoutBtn.setBounds(1268, 599, 91, 86);
	editFrame.getContentPane().add(logoutBtn);
	logoutBtn.setOpaque(false);
	logoutBtn.setContentAreaFilled(false);
	logoutBtn.setBorderPainted(false);
	editFrame.getContentPane().add(logoutBtn);
	logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Logout");	
				loginFrame.setVisible(true);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	

	//label to add background picture
	JLabel addMeetingMenuBackground = new JLabel("");
	addMeetingMenuBackground.setBackground(Color.WHITE);
	addMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/editMeetingMenu.png")).getImage();
	addMeetingMenuBackground.setIcon(new ImageIcon(img));
	addMeetingMenuBackground.setBounds(0, 0, 1359, 720);
	editFrame.getContentPane().add(addMeetingMenuBackground);				
	
}
public void searchMeetings() {
	
	searchFrame = new JFrame("Add meetings");
	searchFrame.setBounds(100, 100, 1035, 647);
	searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	searchFrame.setResizable(false);
	searchFrame.setSize(1359, 720);
	searchFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(34, 22, 106, 86);
	searchFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(true);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 110, 181, 102);
	searchFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(true);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton editMeetingBtn = new JButton("");
	editMeetingBtn.setBounds(1, 237, 181, 102);
	searchFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.setOpaque(false);
	editMeetingBtn.setContentAreaFilled(false);
	editMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("edit meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(true);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(34, 333, 106, 102);
	searchFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(true);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(34, 448, 106, 86);
	searchFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");	
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(true);
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(34, 548, 106, 112);
	searchFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(true);
			}
		});
	
	JButton logoutBtn = new JButton("");
	logoutBtn.setBounds(1268, 599, 91, 86);
	searchFrame.getContentPane().add(logoutBtn);
	logoutBtn.setOpaque(false);
	logoutBtn.setContentAreaFilled(false);
	logoutBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(logoutBtn);
	logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Logout");	
				loginFrame.setVisible(true);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	
	
	//label to add background picture
	JLabel addMeetingMenuBackground = new JLabel("");
	addMeetingMenuBackground.setBackground(Color.WHITE);
	addMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/searchMeetingMenu.png")).getImage();
	addMeetingMenuBackground.setIcon(new ImageIcon(img));
	addMeetingMenuBackground.setBounds(0, 0, 1359, 720);
	searchFrame.getContentPane().add(addMeetingMenuBackground);				
	
}
	/**
	 * Create the application.
	 */
	public GUI() {
		searchMeetings();
		editMeetings();
		viewMeetings();
		addMeetings();
		login();
		signUp();
		menu();
	}
}

