import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import java.util.ArrayList;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {
	String fileName = "user-pass.txt";
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
	private static JTextField meetingDescriptionTxtField;
	private static JTextField meetingDateTxtField;
	private static JTextField employeesTxtField;
	private Menu menuClass = new Menu("employees.txt");

	
	private static final String hours[] = {"24", "23", "22", "21", "20", "19", "18", "17", "16", "15",
		    "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
	private static final String mins[] = {"00","15","30","45"};
	
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
	    
		//Creates new frame for login panel
		loginFrame = new JFrame("Login");
		loginFrame.setBounds(100, 100, 1035, 647);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setSize(1365,720);
		loginFrame.getContentPane().setLayout(null);
		
		//Text box to get user name on login frame
		userName = new JTextField();
		userName.setBackground(Color.WHITE);
		userName.setForeground(Color.BLACK);
		userName.setBounds(575, 240, 215, 22);
		loginFrame.getContentPane().add(userName);
		userName.setColumns(10);
		
		//Text box to get password on login frame
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setColumns(10);
		password.setBackground(Color.WHITE);		
		password.setBounds(575, 323, 215, 22);
		loginFrame.getContentPane().add(password);
		
		//label to display when login details are wrong 
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
				
				boolean validUser = false;
			   for(Employee e : menuClass.getAllEmployees())
			   {
				   if(userName.getText().equals(e.getUserName()) && password.getText().equals(e.getPassword()))
				   {
					   validUser = true;
					   menuClass.setCurrentEmployee(e);
				   }
			   }
			   
			   if(validUser)
			   {
				   System.out.println("Access Granted! Welcome!");
				   loginFrame.setVisible(false);
				   signUpFrame.setVisible(false);
				   menuFrame.setVisible(true);
			   }
			   else
			   {
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
		
		JButton forgotpassbtn = new JButton("");
		forgotpassbtn.setBounds(620, 358, 170, 25);
		forgotpassbtn.setContentAreaFilled(false);
		forgotpassbtn.setBorderPainted(false);
		loginFrame.getContentPane().add(forgotpassbtn);
		forgotpassbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(loginFrame, "Please contact to the admin to reset your password");
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
		
		//New frame to create sign up panel
		signUpFrame = new JFrame("SignUp");
		signUpFrame.setBounds(100, 100, 1035, 647);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpFrame.setResizable(false);
		signUpFrame.setSize(1365,720);
		signUpFrame.getContentPane().setLayout(null);
		
		
		//Text box to get Full name
		JTextField fullName = new JTextField();
		fullName.setBackground(Color.WHITE);
		fullName.setForeground(Color.BLACK);
		fullName.setBounds(580, 192, 176, 22);
		signUpFrame.getContentPane().add(fullName);
		fullName.setColumns(10);
		
		
		//Text box to get New user name
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
				
				Employee newEmployee = new Employee(newUserName.getText(), newPassword.getText(), firstName.getText(), surname.getText());
				menuClass.setCurrentEmployee(newEmployee);
				menuClass.getAllEmployees().add(newEmployee);
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
					saveToFile();
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
		viewMeetingBtn.setBounds(12, 13, 170, 95);
		menuFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.setOpaque(false);
		viewMeetingBtn.setContentAreaFilled(false);
		viewMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("view meeting");
					viewMeetingFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);				
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
								
				}
			});
		
		JButton addMeetingBtn = new JButton("");
		addMeetingBtn.setBounds(1, 121, 181, 102);
		menuFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.setOpaque(false);
		addMeetingBtn.setContentAreaFilled(false);
		addMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("add meeting");
					addMeetingFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);					
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton editMeetingBtn = new JButton("");
		editMeetingBtn.setBounds(1, 237, 181, 102);
		menuFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.setOpaque(false);
		editMeetingBtn.setContentAreaFilled(false);
		editMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("edit meeting");	
					editFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);				
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton searchMeetingBtn = new JButton("");
		searchMeetingBtn.setBounds(1, 343, 181, 102);
		menuFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.setOpaque(false);
		searchMeetingBtn.setContentAreaFilled(false);
		searchMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Search meeting");	
					searchFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton deleteMeetingBtn = new JButton("");
		deleteMeetingBtn.setBounds(1, 458, 181, 102);
		menuFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.setOpaque(false);
		deleteMeetingBtn.setContentAreaFilled(false);
		deleteMeetingBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Delete meeting");		
					deleteFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);					
					undoFrame.setVisible(false);
				}
			});

		JButton undoBtn = new JButton("");
		undoBtn.setBounds(1, 583, 181, 102);
		menuFrame.getContentPane().add(undoBtn);
		undoBtn.setOpaque(false);
		undoBtn.setContentAreaFilled(false);
		undoBtn.setBorderPainted(false);
		menuFrame.getContentPane().add(undoBtn);
		undoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Undo");
					undoFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					
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
		

		JLabel lblWelcomeToThe = new JLabel("Welcome to the Meeting Manger");
		lblWelcomeToThe.setForeground(Color.WHITE);
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblWelcomeToThe.setBackground(Color.WHITE);
		lblWelcomeToThe.setBounds(579, 107, 509, 86);
		menuFrame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblPleaseSelectOne = new JLabel("Please select one of the options from left side ");
		lblPleaseSelectOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseSelectOne.setForeground(Color.WHITE);
		lblPleaseSelectOne.setBounds(668, 191, 338, 31);
		menuFrame.getContentPane().add(lblPleaseSelectOne);
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
		viewMeetingFrame.setSize(1379, 759);
		viewMeetingFrame.getContentPane().setLayout(null);
		
		
		JButton viewMeetingBtn = new JButton("");
		viewMeetingBtn.setBounds(12, 13, 170, 95);
		viewMeetingFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.setOpaque(false);
		viewMeetingBtn.setContentAreaFilled(false);
		viewMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(viewMeetingBtn);
		viewMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("view meeting");
					viewMeetingFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);					
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
								
				}
			});
		
		JButton addMeetingBtn = new JButton("");
		addMeetingBtn.setBounds(1, 121, 181, 102);
		viewMeetingFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.setOpaque(false);
		addMeetingBtn.setContentAreaFilled(false);
		addMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(addMeetingBtn);
		addMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("add meeting");
					addMeetingFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);					
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);

				}
			});
		
		JButton editMeetingBtn = new JButton("");
		editMeetingBtn.setBounds(1, 237, 181, 102);
		viewMeetingFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.setOpaque(false);
		editMeetingBtn.setContentAreaFilled(false);
		editMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(editMeetingBtn);
		editMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("edit meeting");	
					editFrame.setVisible(true);					
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton searchMeetingBtn = new JButton("");
		searchMeetingBtn.setBounds(1, 343, 181, 102);
		viewMeetingFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.setOpaque(false);
		searchMeetingBtn.setContentAreaFilled(false);
		searchMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(searchMeetingBtn);
		searchMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Search meeting");	
					searchFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					deleteFrame.setVisible(false);
					undoFrame.setVisible(false);
				}
			});
		
		JButton deleteMeetingBtn = new JButton("");
		deleteMeetingBtn.setBounds(1, 458, 181, 102);
		viewMeetingFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.setOpaque(false);
		deleteMeetingBtn.setContentAreaFilled(false);
		deleteMeetingBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(deleteMeetingBtn);
		deleteMeetingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Delete meeting");	
					deleteFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);					
					undoFrame.setVisible(false);
				}
			});

		JButton undoBtn = new JButton("");
		undoBtn.setBounds(1, 583, 181, 102);
		viewMeetingFrame.getContentPane().add(undoBtn);
		undoBtn.setOpaque(false);
		undoBtn.setContentAreaFilled(false);
		undoBtn.setBorderPainted(false);
		viewMeetingFrame.getContentPane().add(undoBtn);
		undoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("Undo");
					undoFrame.setVisible(true);
					loginFrame.setVisible(false);
					signUpFrame.setVisible(false);
					menuFrame.setVisible(false);
					viewMeetingFrame.setVisible(false);
					addMeetingFrame.setVisible(false);
					editFrame.setVisible(false);
					searchFrame.setVisible(false);
					deleteFrame.setVisible(false);
					
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
		// label to add header of View meetings
		JLabel lblViewMeetings = new JLabel("View Meetings");
		lblViewMeetings.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewMeetings.setForeground(Color.WHITE);
		lblViewMeetings.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblViewMeetings.setBounds(656, 106, 294, 36);
		viewMeetingFrame.getContentPane().add(lblViewMeetings);
		
		//Displays creates Text area
		JTextArea diaryView = new JTextArea();
		diaryView.setFont(new Font("Monospaced", Font.PLAIN, 15));
		diaryView.setText("Description	Date	Start Time	End Time	Employees ");
		diaryView.setBounds(541, 237, 587, 386);
		diaryView.setVisible(false);
		viewMeetingFrame.getContentPane().add(diaryView);
		
		
		//Button to display Diary view
		JButton btnDiaryView = new JButton("Diary view");
		btnDiaryView.setForeground(Color.WHITE);
		Border border = new LineBorder(Color.WHITE, 2);
		btnDiaryView.setBorder(border);
		btnDiaryView.setBackground(new Color(18, 72, 180));
		btnDiaryView.setBounds(531, 176, 129, 36);
		viewMeetingFrame.getContentPane().add(btnDiaryView);
		btnDiaryView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				diaryView.setVisible(true);
			}
		});
		
		JButton btnalenderView = new JButton("Calender view");
		btnalenderView.setForeground(Color.WHITE);
		btnalenderView.setBorder(border);
		btnalenderView.setBackground(new Color(18, 72, 180));
		btnalenderView.setBounds(941, 176, 142, 36);
		viewMeetingFrame.getContentPane().add(btnalenderView);
		

		
		
		//label to add background picture
		JLabel viewMeetingMenuBackground = new JLabel("");
		viewMeetingMenuBackground.setBackground(Color.WHITE);
		viewMeetingMenuBackground.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/viewMeetingMenu.png")).getImage();
		viewMeetingMenuBackground.setIcon(new ImageIcon(img));
		viewMeetingMenuBackground.setBounds(0, 0, 1361, 716);
		viewMeetingFrame.getContentPane().add(viewMeetingMenuBackground);				
		
		
		
}
public void addMeetings() {


	
	addMeetingFrame = new JFrame("Add meetings");
	addMeetingFrame.setBounds(100, 100, 1035, 647);
	addMeetingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addMeetingFrame.setResizable(false);
	addMeetingFrame.setSize(1379, 759);
	addMeetingFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(12, 13, 170, 95);
	addMeetingFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				viewMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);					
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 121, 181, 102);
	addMeetingFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				addMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);					
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton editMeetingBtn = new JButton("");
	editMeetingBtn.setBounds(1, 237, 181, 102);
	addMeetingFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.setOpaque(false);
	editMeetingBtn.setContentAreaFilled(false);
	editMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("edit meeting");	
				editFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);				
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(1, 343, 181, 102);
	addMeetingFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				searchFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);				
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(1, 458, 181, 102);
	addMeetingFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");	
				deleteFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);				
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(1, 583, 181, 102);
	addMeetingFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				undoFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);			
			}
		});
	
	JButton logoutBtn = new JButton("");
	logoutBtn.setBounds(1268, 599, 91, 112);
	addMeetingFrame.getContentPane().add(logoutBtn);
	logoutBtn.setOpaque(false);
	logoutBtn.setContentAreaFilled(false);
	logoutBtn.setBorderPainted(false);
	addMeetingFrame.getContentPane().add(logoutBtn);
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
	

	//label to add header "Add Meetings"
	JLabel lblAddMeetings = new JLabel("Add Meetings");
	lblAddMeetings.setHorizontalAlignment(SwingConstants.CENTER);
	lblAddMeetings.setForeground(Color.WHITE);
	lblAddMeetings.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblAddMeetings.setBounds(656, 106, 294, 36);
	addMeetingFrame.getContentPane().add(lblAddMeetings);
	
	//label to display "Meeting description" 
	JLabel lblMeetingDescription = new JLabel("Meeting description:");
	lblMeetingDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblMeetingDescription.setForeground(Color.WHITE);
	lblMeetingDescription.setBounds(423, 200, 158, 20);
	addMeetingFrame.getContentPane().add(lblMeetingDescription);
	
	//Text field to get Meeting Description from the user
	meetingDescriptionTxtField = new JTextField();
	meetingDescriptionTxtField.setBounds(605, 200, 345, 20);
	addMeetingFrame.getContentPane().add(meetingDescriptionTxtField);
	meetingDescriptionTxtField.setColumns(10);
	
	//Label to display "Date"
	JLabel lblDate = new JLabel("Date:");
	lblDate.setForeground(Color.WHITE);
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblDate.setBounds(423, 280, 160, 20);
	addMeetingFrame.getContentPane().add(lblDate);
	
	//Text field to get Meeting Date from the user
	meetingDateTxtField = new JTextField();
	meetingDateTxtField.setBounds(605, 280, 345, 20);
	addMeetingFrame.getContentPane().add(meetingDateTxtField);
	meetingDateTxtField.setColumns(10);
	
	//label to display "Start Time"
	JLabel lblStartTime = new JLabel("Start Time:");
	lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblStartTime.setForeground(Color.WHITE);
	lblStartTime.setBounds(423, 360, 158, 20);
	addMeetingFrame.getContentPane().add(lblStartTime);
	
	//Label to display "end Time"
	JLabel lblEndTime = new JLabel("End Time:");
	lblEndTime.setForeground(Color.WHITE);
	lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEndTime.setBounds(423, 440, 158, 20);
	addMeetingFrame.getContentPane().add(lblEndTime);
	
	//Label to display "Employees attending"
	JLabel lblEmployeesAttending = new JLabel("Employees attending:");
	lblEmployeesAttending.setForeground(Color.WHITE);
	lblEmployeesAttending.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEmployeesAttending.setBounds(423, 520, 158, 20);
	addMeetingFrame.getContentPane().add(lblEmployeesAttending);
	
	//Text field to get Employees attending from the user
	employeesTxtField = new JTextField();
	employeesTxtField.setBounds(605, 520, 345, 20);
	addMeetingFrame.getContentPane().add(employeesTxtField);
	employeesTxtField.setColumns(10);
	
	//Add meeting button
	JButton btnAddMeeting = new JButton("Add meeting");
	btnAddMeeting.setBackground(new Color(0, 102, 204));
	btnAddMeeting.setForeground(Color.WHITE);		
	Border border = new LineBorder(Color.WHITE, 2);
	btnAddMeeting.setBorder(border);
	btnAddMeeting.setBounds(853, 583, 97, 25);
	addMeetingFrame.getContentPane().add(btnAddMeeting);
	btnAddMeeting.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(editFrame, "Meeting has been added to the diary.");
		meetingDescriptionTxtField.setText("");
		meetingDateTxtField.setText("");
		employeesTxtField.setText("");
				}
			});	
	//Drop down box to ask the user the starting hour
	JComboBox startHour = new JComboBox(hours);
	startHour.setBounds(624, 360, 60, 22);
	addMeetingFrame.getContentPane().add(startHour);
	
	//Drop down box to ask the user the starting mins
	JComboBox startMins = new JComboBox(mins);
	startMins.setBounds(717, 360, 53, 22);
	addMeetingFrame.getContentPane().add(startMins);
	
	//Drop down box to ask the user the ending hour
	JComboBox endhour = new JComboBox(hours);
	endhour.setBounds(624, 440, 60, 22);
	addMeetingFrame.getContentPane().add(endhour);
	
	//Drop down box to ask the user the ending mins
	JComboBox endMins = new JComboBox(mins);
	endMins.setBounds(717, 440, 53, 22);
	addMeetingFrame.getContentPane().add(endMins);
	
	//label to add background picture
	JLabel addMeetingMenuBackground = new JLabel("");
	addMeetingMenuBackground.setBackground(Color.WHITE);
	addMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/addMeetingMenu.png")).getImage();
	addMeetingMenuBackground.setIcon(new ImageIcon(img));
	addMeetingMenuBackground.setBounds(0, 0, 1361, 716);
	addMeetingFrame.getContentPane().add(addMeetingMenuBackground);
	
}
public void editMeetings() {
	
	editFrame = new JFrame("Edit meetings");
	editFrame.setBounds(100, 100, 1035, 647);
	editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	editFrame.setResizable(false);
	editFrame.setSize(1379, 759);
	editFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(12, 13, 170, 95);
	editFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				viewMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);					
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 121, 181, 102);
	editFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				addMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
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
				editFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);				
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(1, 343, 181, 102);
	editFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				searchFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);				
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(1, 458, 181, 102);
	editFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	editFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");	
				deleteFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);				
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(1, 583, 181, 102);
	editFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	editFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				undoFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);				
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
	
	//label to display "Meeting description" 
	JLabel lblMeetingDescription = new JLabel("Meeting description:");
	lblMeetingDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblMeetingDescription.setForeground(Color.WHITE);
	lblMeetingDescription.setBounds(423, 200, 158, 20);
	editFrame.getContentPane().add(lblMeetingDescription);
	
	//Text field to get Meeting Description from the user
	meetingDescriptionTxtField = new JTextField();
	meetingDescriptionTxtField.setBounds(605, 200, 345, 20);
	editFrame.getContentPane().add(meetingDescriptionTxtField);
	meetingDescriptionTxtField.setColumns(10);
	
	//Label to display "Date"
	JLabel lblDate = new JLabel("Date:");
	lblDate.setForeground(Color.WHITE);
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblDate.setBounds(423, 280, 160, 20);
	editFrame.getContentPane().add(lblDate);
	
	//Text field to get Meeting Date from the user
	meetingDateTxtField = new JTextField();
	meetingDateTxtField.setBounds(605, 280, 345, 20);
	editFrame.getContentPane().add(meetingDateTxtField);
	meetingDateTxtField.setColumns(10);
	
	//label to display "Start Time"
	JLabel lblStartTime = new JLabel("Start Time:");
	lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblStartTime.setForeground(Color.WHITE);
	lblStartTime.setBounds(423, 360, 158, 20);
	editFrame.getContentPane().add(lblStartTime);
	
	//Label to display "end Time"
	JLabel lblEndTime = new JLabel("End Time:");
	lblEndTime.setForeground(Color.WHITE);
	lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEndTime.setBounds(423, 440, 158, 20);
	editFrame.getContentPane().add(lblEndTime);
	
	//Label to display "Employees attending"
	JLabel lblEmployeesAttending = new JLabel("Employees attending:");
	lblEmployeesAttending.setForeground(Color.WHITE);
	lblEmployeesAttending.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEmployeesAttending.setBounds(423, 520, 158, 20);
	editFrame.getContentPane().add(lblEmployeesAttending);
	
	//Text field to get Employees attending from the user
	employeesTxtField = new JTextField();
	employeesTxtField.setBounds(605, 520, 345, 20);
	editFrame.getContentPane().add(employeesTxtField);
	employeesTxtField.setColumns(10);
	
	//Add confirm changes button button
	JButton btneditMeeting = new JButton("Edit meeting");
	btneditMeeting.setBackground(new Color(0, 102, 204));
	btneditMeeting.setForeground(Color.WHITE);		
	Border border = new LineBorder(Color.WHITE, 2);
	btneditMeeting.setBorder(border);
	btneditMeeting.setBounds(605, 583, 97, 25);
	editFrame.getContentPane().add(btneditMeeting);
	btneditMeeting.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {	
		JOptionPane.showMessageDialog(editFrame, "Now add updated meeting details");
		meetingDescriptionTxtField.setText("");
		meetingDateTxtField.setText("");
		employeesTxtField.setText("");
				}
			});	
	
	//confirm changes button
	JButton btnConfirm= new JButton("Confirm changes");
	btnConfirm.setBackground(new Color(0, 102, 204));
	btnConfirm.setForeground(Color.WHITE);		
	btnConfirm.setBorder(border);
	btnConfirm.setBounds(840, 583, 110, 25);
	editFrame.getContentPane().add(btnConfirm);
	btnConfirm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {	
		JOptionPane.showMessageDialog(editFrame, "Meeting detail has been updated");
		meetingDescriptionTxtField.setText("");
		meetingDateTxtField.setText("");
		employeesTxtField.setText("");
					}
				});	
	
	//Drop down box to ask the user the starting hour
	JComboBox startHour = new JComboBox(hours);
	startHour.setBounds(624, 360, 60, 22);
	editFrame.getContentPane().add(startHour);
	
	//Drop down box to ask the user the starting mins
	JComboBox startMins = new JComboBox(mins);
	startMins.setBounds(717, 360, 53, 22);
	editFrame.getContentPane().add(startMins);
	
	//Drop down box to ask the user the ending hour
	JComboBox endhour = new JComboBox(hours);
	endhour.setBounds(624, 440, 60, 22);
	editFrame.getContentPane().add(endhour);
	
	//Drop down box to ask the user the ending mins
	JComboBox endMins = new JComboBox(mins);
	endMins.setBounds(717, 440, 53, 22);
	editFrame.getContentPane().add(endMins);
	

	//label to add background picture
	JLabel editMeetingMenuBackground = new JLabel("");
	editMeetingMenuBackground.setBackground(Color.WHITE);
	editMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/editMeetingMenu.png")).getImage();
	editMeetingMenuBackground.setIcon(new ImageIcon(img));
	editMeetingMenuBackground.setBounds(0, 0, 1361, 716);
	editFrame.getContentPane().add(editMeetingMenuBackground);				
	
}
public void searchMeetings() {
	
	searchFrame = new JFrame("Search meetings");
	searchFrame.setBounds(100, 100, 1035, 647);
	searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	searchFrame.setResizable(false);
	searchFrame.setSize(1379, 759);
	searchFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(12, 13, 170, 95);
	searchFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				viewMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);					
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 121, 181, 102);
	searchFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				addMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);				
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
				editFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);				
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(1, 343, 181, 102);
	searchFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");
				searchFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);				
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(1, 458, 181, 102);
	searchFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");
				deleteFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);				
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(1, 583, 181, 102);
	searchFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	searchFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				undoFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);				
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
	
	//Label to display "Date"
	JLabel lblDate = new JLabel("Date:");
	lblDate.setForeground(Color.WHITE);
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblDate.setBounds(423, 174, 160, 20);
	searchFrame.getContentPane().add(lblDate);
	
	//Text field to get Meeting Date from the user
	meetingDateTxtField = new JTextField();
	meetingDateTxtField.setBounds(605, 175, 345, 20);
	searchFrame.getContentPane().add(meetingDateTxtField);
	meetingDateTxtField.setColumns(10);
	
	//label to display "Start Time"
	JLabel lblStartTime = new JLabel("Start Time:");
	lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblStartTime.setForeground(Color.WHITE);
	lblStartTime.setBounds(423, 235, 158, 20);
	searchFrame.getContentPane().add(lblStartTime);
	
	//Label to display "end Time"
	JLabel lblEndTime = new JLabel("End Time:");
	lblEndTime.setForeground(Color.WHITE);
	lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEndTime.setBounds(423, 292, 158, 20);
	searchFrame.getContentPane().add(lblEndTime);
	
	//Label to display "Employees attending"
	JLabel lblEmployeesAttending = new JLabel("Employees attending:");
	lblEmployeesAttending.setForeground(Color.WHITE);
	lblEmployeesAttending.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEmployeesAttending.setBounds(423, 353, 158, 20);
	searchFrame.getContentPane().add(lblEmployeesAttending);
	
	//Text field to get Employees attending from the user
	employeesTxtField = new JTextField();
	employeesTxtField.setBounds(605, 354, 345, 20);
	searchFrame.getContentPane().add(employeesTxtField);
	employeesTxtField.setColumns(10);
	
	//Add confirm changes button button
	JButton btneditMeeting = new JButton("Search");
	btneditMeeting.setBackground(new Color(0, 102, 204));
	btneditMeeting.setForeground(Color.WHITE);		
	Border border = new LineBorder(Color.WHITE, 2);
	btneditMeeting.setBorder(border);
	btneditMeeting.setBounds(1025, 352, 97, 25);
	searchFrame.getContentPane().add(btneditMeeting);
	btneditMeeting.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {	
		meetingDescriptionTxtField.setText("");
		meetingDateTxtField.setText("");
		employeesTxtField.setText("");
				}
			});	
	
	
	
	//Drop down box to ask the user the starting hour
	JComboBox startHour = new JComboBox(hours);
	startHour.setBounds(624, 237, 60, 22);
	searchFrame.getContentPane().add(startHour);
	
	//Drop down box to ask the user the starting mins
	JComboBox startMins = new JComboBox(mins);
	startMins.setBounds(717, 235, 53, 22);
	searchFrame.getContentPane().add(startMins);
	
	//Drop down box to ask the user the ending hour
	JComboBox endhour = new JComboBox(hours);
	endhour.setBounds(624, 292, 60, 22);
	searchFrame.getContentPane().add(endhour);
	
	//Drop down box to ask the user the ending mins
	JComboBox endMins = new JComboBox(mins);
	endMins.setBounds(717, 292, 53, 22);
	searchFrame.getContentPane().add(endMins);	
	
	JLabel lblSearch = new JLabel("Search");
	lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
	lblSearch.setForeground(Color.WHITE);
	lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblSearch.setBounds(624, 78, 306, 43);
	searchFrame.getContentPane().add(lblSearch);

	//label to add background picture
	JLabel searchMeetingMenuBackground = new JLabel("");
	searchMeetingMenuBackground.setBackground(Color.WHITE);
	searchMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/searchMeetingMenu.png")).getImage();
	searchMeetingMenuBackground.setIcon(new ImageIcon(img));
	searchMeetingMenuBackground.setBounds(0, 0, 1361, 716);
	searchFrame.getContentPane().add(searchMeetingMenuBackground);				
	
}
public void deleteMeetings() {
	
	deleteFrame = new JFrame("Delete meetings");
	deleteFrame.setBounds(100, 100, 1035, 647);
	deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	deleteFrame.setResizable(false);
	deleteFrame.setSize(1379, 759);
	deleteFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(12, 13, 170, 95);
	deleteFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				viewMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);					
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
							
			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 121, 181, 102);
	deleteFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				addMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);				
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton editMeetingBtn = new JButton("");
	editMeetingBtn.setBounds(1, 237, 181, 102);
	deleteFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.setOpaque(false);
	editMeetingBtn.setContentAreaFilled(false);
	editMeetingBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("edit meeting");
				editFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);				
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(1, 343, 181, 102);
	deleteFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				searchFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);				
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(1, 458, 181, 102);
	deleteFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");
				deleteFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);				
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(1, 583, 181, 102);
	deleteFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				undoFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				
			}
		});
	
	JButton logoutBtn = new JButton("");
	logoutBtn.setBounds(1268, 599, 91, 86);
	deleteFrame.getContentPane().add(logoutBtn);
	logoutBtn.setOpaque(false);
	logoutBtn.setContentAreaFilled(false);
	logoutBtn.setBorderPainted(false);
	deleteFrame.getContentPane().add(logoutBtn);
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
	


	JComboBox meeting = new JComboBox(meetings);
	meeting.setBounds(791, 241, 412, 22);
	deleteFrame.getContentPane().add(meeting);
	
	JLabel lblDeleteMeetings = new JLabel("Delete Meetings");
	lblDeleteMeetings.setHorizontalAlignment(SwingConstants.CENTER);
	lblDeleteMeetings.setForeground(Color.WHITE);
	lblDeleteMeetings.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblDeleteMeetings.setBounds(690, 103, 262, 37);
	deleteFrame.getContentPane().add(lblDeleteMeetings);
	
	JLabel lblSelectOneOf = new JLabel("Select one of the following meeting to delete:");
	lblSelectOneOf.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblSelectOneOf.setHorizontalAlignment(SwingConstants.CENTER);
	lblSelectOneOf.setForeground(Color.WHITE);
	lblSelectOneOf.setBounds(420, 237, 348, 29);
	deleteFrame.getContentPane().add(lblSelectOneOf);
	
	//confirm changes button
	JButton btnConfirm= new JButton("Delete");
	btnConfirm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(loginFrame,"Selected meeting has been deleted");
		}
	});
	btnConfirm.setBackground(new Color(0, 102, 204));
	btnConfirm.setForeground(Color.WHITE);
	Border border = new LineBorder(Color.WHITE, 2);
	btnConfirm.setBorder(border);
	btnConfirm.setBounds(1093, 458, 110, 25);
	deleteFrame.getContentPane().add(btnConfirm);
	
	//label to add background picture
	JLabel deleteMeetingMenuBackground = new JLabel("");
	deleteMeetingMenuBackground.setBackground(Color.WHITE);
	deleteMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/deleteMeetingMenu.png")).getImage();
	deleteMeetingMenuBackground.setIcon(new ImageIcon(img));
	deleteMeetingMenuBackground.setBounds(0, 0, 1361, 716);
	deleteFrame.getContentPane().add(deleteMeetingMenuBackground);				
	
	
	
	
	
	
}
public void undoMeetings() {
	
	undoFrame = new JFrame("Undo meetings");
	undoFrame.setBounds(100, 100, 1035, 647);
	undoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	undoFrame.setResizable(false);
	undoFrame.setSize(1379, 759);
	undoFrame.getContentPane().setLayout(null);
	
	
	JButton viewMeetingBtn = new JButton("");
	viewMeetingBtn.setBounds(12, 13, 170, 95);
	undoFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.setOpaque(false);
	viewMeetingBtn.setContentAreaFilled(false);
	viewMeetingBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(viewMeetingBtn);
	viewMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("view meeting");
				viewMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);				
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);	

			}
		});
	
	JButton addMeetingBtn = new JButton("");
	addMeetingBtn.setBounds(1, 121, 181, 102);
	undoFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.setOpaque(false);
	addMeetingBtn.setContentAreaFilled(false);
	addMeetingBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(addMeetingBtn);
	addMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("add meeting");
				addMeetingFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);				
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton editMeetingBtn = new JButton("");
	editMeetingBtn.setBounds(1, 237, 181, 102);
	undoFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.setOpaque(false);
	editMeetingBtn.setContentAreaFilled(false);
	editMeetingBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(editMeetingBtn);
	editMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("edit meeting");	
				editFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);				
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton searchMeetingBtn = new JButton("");
	searchMeetingBtn.setBounds(1, 343, 181, 102);
	undoFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.setOpaque(false);
	searchMeetingBtn.setContentAreaFilled(false);
	searchMeetingBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(searchMeetingBtn);
	searchMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Search meeting");	
				searchFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);				
				deleteFrame.setVisible(false);
				undoFrame.setVisible(false);
			}
		});
	
	JButton deleteMeetingBtn = new JButton("");
	deleteMeetingBtn.setBounds(1, 458, 181, 102);
	undoFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.setOpaque(false);
	deleteMeetingBtn.setContentAreaFilled(false);
	deleteMeetingBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(deleteMeetingBtn);
	deleteMeetingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Delete meeting");	
				deleteFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);				
				undoFrame.setVisible(false);
			}
		});

	JButton undoBtn = new JButton("");
	undoBtn.setBounds(1, 583, 181, 102);
	undoFrame.getContentPane().add(undoBtn);
	undoBtn.setOpaque(false);
	undoBtn.setContentAreaFilled(false);
	undoBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(undoBtn);
	undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Undo");
				undoFrame.setVisible(true);
				loginFrame.setVisible(false);
				signUpFrame.setVisible(false);
				menuFrame.setVisible(false);
				viewMeetingFrame.setVisible(false);
				addMeetingFrame.setVisible(false);
				editFrame.setVisible(false);
				searchFrame.setVisible(false);
				deleteFrame.setVisible(false);
				
			}
		});
	
	JButton logoutBtn = new JButton("");
	logoutBtn.setBounds(1268, 599, 91, 86);
	undoFrame.getContentPane().add(logoutBtn);
	logoutBtn.setOpaque(false);
	logoutBtn.setContentAreaFilled(false);
	logoutBtn.setBorderPainted(false);
	undoFrame.getContentPane().add(logoutBtn);
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
	JLabel undoMeetingMenuBackground = new JLabel("");
	undoMeetingMenuBackground.setBackground(Color.WHITE);
	undoMeetingMenuBackground.setForeground(Color.WHITE);
	Image img = new ImageIcon(this.getClass().getResource("/undoMeetingMenu.png")).getImage();
	undoMeetingMenuBackground.setIcon(new ImageIcon(img));
	undoMeetingMenuBackground.setBounds(0, 0, 1361, 716);
	undoFrame.getContentPane().add(undoMeetingMenuBackground);				
	
	
	
}

public void saveToFile()
{
	JOptionPane.showMessageDialog(null, "Saving to file...");
	FileOutputStream outputStream;
	ObjectOutputStream objectOutputStream;
	try
	{
		outputStream = new FileOutputStream(menuClass.getFileName());
		objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(menuClass.getAllEmployees());
		objectOutputStream.flush();
		objectOutputStream.close();
	}
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in saving to file");
	}
}

public void loadFromFile()
{
	JOptionPane.showMessageDialog(null, "Loading from file...");
    FileInputStream inputStream;
    ObjectInputStream objectInputStream;
    try
    {
  	  inputStream = new FileInputStream(menuClass.getFileName());
  	  objectInputStream = new ObjectInputStream(inputStream);
  	  menuClass.setAllEmployees((ArrayList<Employee>) objectInputStream.readObject());
  	  objectInputStream.close();
    }
    catch(Exception e)
    {
    	JOptionPane.showMessageDialog(null,"Error loading from file");
    }
}
	/**
	 * Create the application.
	 */
	public GUI() throws IOException {
		loadFromFile();
		undoMeetings();
		deleteMeetings();
		searchMeetings();
		editMeetings();
		viewMeetings();
		addMeetings();
		login();
		signUp();
		menu();
		
	}
	
}

