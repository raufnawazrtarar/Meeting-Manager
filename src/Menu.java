import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Menu {

	private ArrayList<Employee> allEmployees;
	private String fileName;
	private Stack<String> editsMade;
	private Meeting[] lastChange;
	private Employee currentEmployee;
	private Scanner s;
	
	/**
	 * @return the allEmployees
	 */
	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	/**
	 * @param allEmployees the allEmployees to set
	 */
	public void setAllEmployees(ArrayList<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the editsMade
	 */
	public Stack<String> getEditsMade() {
		return editsMade;
	}

	/**
	 * @param editsMade the editsMade to set
	 */
	public void setEditsMade(Stack<String> editsMade) {
		this.editsMade = editsMade;
	}

	
	/**
	 * @return the lastChange
	 */
	public Meeting[] getLastChange() {
		return lastChange;
	}

	/**
	 * @param lastChange the lastChange to set
	 */
	public void setLastChange(Meeting[] lastChange) {
		this.lastChange = lastChange;
	}

	/**
	 * @return the currentEmployee
	 */
	public Employee getCurrentEmployee() {
		return currentEmployee;
	}

	/**
	 * @param currentEmployee the currentEmployee to set
	 */
	public void setCurrentEmployee(Employee currentEmployee) {
		this.currentEmployee = currentEmployee;
	}

	/**
	 * Default constructor for Menu
	 */
	public Menu(String fileName)
	{
		this.fileName = fileName;
		allEmployees = new ArrayList<Employee>();
		editsMade = new Stack<String>();
		lastChange = new Meeting[2];
		currentEmployee = new Employee();
		s = new Scanner(System.in);
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
	
	/**
	 * Add meeting method for undo feature
	 * @param toAdd
	 */
	public void addMeeting(Meeting toAdd)
	{
		for(Employee employee : toAdd.getAttending())
		{
			employee.getDiary().add(toAdd);
		}
		
		lastChange[0] = toAdd;
		editsMade.push("add");
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
	
	/**
	 * Delete meeting
	 * @param toDelete
	 */
	public void deleteMeeting(Meeting toDelete)
	{
		for(Employee employee : toDelete.getAttending())
		{
			employee.getDiary().remove(toDelete);
		}
		
		lastChange[0] = toDelete;
		editsMade.push("delete");
	}
	
	/**
	 * Determines if changes can be made to meetings and edits them
	 * @param toEdit Meeting to edit
	 * @param date The changed date
	 * @param startTime The changed start time
	 * @param endTime The changed end time
	 * @param description The changed description
	 * @param attending The changed list of employees attending
	 */
	public void editMeeting(Meeting toEdit, Date date, Time startTime, 
			Time endTime, String description, ArrayList<Employee> attending)
	{
		boolean valid = true;
		
		//checks if all employees are free for the new meeting date and time
		boolean free = true;
		for(Employee employee : attending)
		{
			free = employee.isFree(toEdit, date, startTime, endTime);
			if(!free)
			{
				valid = false;
				break;
			}
		}
		
		if(valid)
		{
			editsMade.push("edit");
			Meeting beforeEdits = new Meeting(toEdit);
			lastChange[0] = beforeEdits;
			
			if(!toEdit.getAttending().equals(attending) || !toEdit.getDate().equals(date) 
					|| !toEdit.getStartTime().equals(startTime))
			{
				deleteMeeting(toEdit);
				toEdit.setDate(date);
				toEdit.setStartTime(startTime);
				toEdit.setAttending(attending);
				addMeeting(toEdit);
			}
			toEdit.setEndTime(endTime);
			toEdit.setDescription(description);
			
			lastChange[1] = toEdit;
		}
		else
		{
			System.out.println("Cannot make these changes to the meeting as not all employees are available.");
		}
	}
	
	
	/**
	 * Undo feature
	 */
	public boolean undo()
	{
		boolean undo = false;
		String editType = editsMade.pop();
		//System.out.println(editType);
		switch(editType)
		{
			case "add": 
				deleteMeeting(lastChange[0]);
				undo = true;
				break;
			
			case "delete": 
				addMeeting(lastChange[0]);
				undo = true;
				break;
			
			case "edit":
				//delete meeting from after edits
				for(Employee employee : lastChange[1].getAttending())
				{
					employee.getDiary().remove(lastChange[1]);
				}
				
				addMeeting(lastChange[0]); //add meeting from before edits
				undo = true;
				break;
		}
		return undo;
	}
	
}
