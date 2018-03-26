import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu menu = new Menu();
		menu.loginMenu();
	}

	/**
	 * Displays a menu of available options to the user
	 */
	public void displayLogin()
	{
		System.out.println();
		System.out.println("Welcome to the Meeting Manager");
		System.out.println("Please select an option:");
		System.out.println("1) Login");
		System.out.println("2) Sign Up");
		System.out.println("3) Exit");
	}
	
	/**
	 * Processes the user's menu option and responds accordingly
	 */
	public void loginMenu()
	{
		String choice;
		boolean menu = true;
		
		while(menu)
		{
			displayLogin();
			choice = s.nextLine();
			switch (choice)
			{
				case "1": login(); break;
				
				case "2":  signUp(); break;
				
				case "3": menu = false; break;
				
				default: System.out.println("You have not selected an option from the menu.");
				
			}
		}
	}
	
	public void login()
	{
		String userName, password;
		boolean stop = false;
		while(!stop)
		{
			System.out.println("Please enter your username: ");
			userName = s.nextLine();
			System.out.println("Please enter your password:");
			password = s.nextLine();
			for(Employee e : allEmployees)
			{
				if(userName.equals(e.getUserName()) && password.equals(e.getPassword()))
				{
					stop = true;
					currentEmployee = e;
					System.out.println("Welcome!");
					menuOptions();
				}
			}
			
			if(!stop)
			{
				System.out.println("Invalid login");
				System.out.println("Try again? (y/n)");
				String answer = s.nextLine();
				if(answer.equals("n"))
				{
					stop = true;
				}
			}
		}
	}
	
	public void signUp()
	{
		String userName, password, firstName, surname;
		System.out.println("Please enter your username: ");
		userName = s.nextLine();
		System.out.println("Please enter your password:");
		password = s.nextLine();
		System.out.println("Please enter your first name: ");
		firstName = s.nextLine();
		System.out.println("Please enter your surname: ");
		surname = s.nextLine();
		
		currentEmployee = new Employee(userName, password, firstName, surname);
		allEmployees.add(currentEmployee);
		menuOptions();
	}
	
	/**
	 * Displays a menu of available options to the user
	 */
	public void displayMenu()
	{
		System.out.println();
		System.out.println("Menu Options:");
		System.out.println("1) View diary");
		System.out.println("2) Delete a meeting");
		System.out.println("3) Edit a meeting");
		System.out.println("4) Search for potential meeting times and add a meeting");
		System.out.println("5) Undo last ‘add’, ‘delete’ or ‘edit’ of a diary entry");
		System.out.println("6) Exit");
	}
	
	/**
	 * Processes the user's menu option and responds accordingly
	 */
	public void menuOptions()
	{
		String choice;
		boolean menu = true;
		Scanner s = new Scanner(System.in);
		
		while(menu)
		{
			displayMenu();
			choice = s.nextLine();
			switch (choice)
			{
				case "1": currentEmployee.displayDiary(); break;
				
				//case "2":  delete(); break;
				
				//case "3":  edit(); break;
				
				//case "4":  search(); break;
				
				case "5":  undo(); break;
				
				case "6": menu = false; break;
				
				default: System.out.println("You have not selected an option from the menu.");
				
			}
		}
	}
	
	public void delete()
	{
		System.out.println("Please select a meeting from the list below: ");
		currentEmployee.displayDiary();
		try
		{
			int number = s.nextInt();
			Meeting toDel = currentEmployee.getDiary()[number - 1];
			deleteMeeting(toDel);
		}
		catch (Exception e)
		{
			System.out.println("You didn't select a meeting");
		}
	}
}
