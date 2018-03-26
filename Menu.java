import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Kamila
 *
 */
public class Menu {

	private ArrayList<Employee> allEmployees;
	private ArrayList<Employee> employeesAtMeeting;	//For testing just now
	private String fileName;
	private Stack<String> editsMade;
	private Meeting lastChange;
	private Employee employee;
	
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
	public Meeting getLastChange() {
		return lastChange;
	}

	/**
	 * @param lastChange the lastChange to set
	 */
	public void setLastChange(Meeting lastChange) {
		this.lastChange = lastChange;
	}

	/**
	 * Default constructor for Menu
	 */
	public Menu()
	{
		allEmployees = new ArrayList<Employee>();
		employeesAtMeeting = new ArrayList<Employee>();	
		employee= new Employee();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
		menu.addMeetingFromList();
		
	}

	/**
	 * Undo feature
	 */
	public void undo()
	{
		String editType = editsMade.pop();
		switch(editType)
		{
			case "add": break;
			case "delete": break;
			case "edit": break;
		}
	}
	
	/**
	 * Adding/Selecting meeting from list of potential meeting times
	 */
	public void addMeetingFromList()
	{
		Date date = null;
		
		//User chooses employees from drop down list - these employees are added to 'employees' ArrayList
		//For testing just now i've created an employee to add
		Employee employee1 = new Employee(1, "Abc", "Xyz");
		employeesAtMeeting.add(employee1);
		
		//User enters date to store meeting
		Scanner s1 = new Scanner(System.in);
		System.out.println("Please enter the date on which you would like to hold the meeting in the format (dd-mm-yyyy)");
		String stringDate = s1.nextLine();
		
		//Format for user to enter String in
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		 try 
		 {
			 //Formats string to Date object
			 date = formatter.parse(stringDate);
			//Printing date just to make sure it's working - will delete later
			 System.out.println(date);
			 System.out.println(formatter.format(date));

	      }
		 catch (ParseException e) 
		 {
			 e.printStackTrace();
	     }
		
		//User chooses startTime and endTime of search
		//TODO - GUI - maybe select from drop down?
		System.out.println("Please enter the earliest time to start searching for a meeting (in the format hh:mm:ss)");
		 
		String stringStartTime = s1.nextLine();
		Time startTime = Time.valueOf(stringStartTime);
		 
		System.out.println("Please enter the latest time to end searching for a meeting (in the format hh:mm:ss)");
		String stringEndTime = s1.nextLine();
		 
		Time endTime = java.sql.Time.valueOf(stringEndTime);
		
		//search() method is called - (returning time chosen when feature is added)
		Time timeToAdd = search(employeesAtMeeting, date, startTime, endTime);
		
		Meeting meetingToAdd= new Meeting(date, timeToAdd);
		
		
		for(int i = 0; i < employeesAtMeeting.size(); i++)
		{
			employeesAtMeeting.get(i).addMeeting(meetingToAdd);
			
			System.out.println(employeesAtMeeting.get(i).getDiary());
			
		}
	}
	
	/**
	 * Search feature
	 * @param employees
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @return 
	 */
	public Time search(ArrayList<Employee> employees, Date date, Time startTime, Time endTime)
	{
		Set<Time> allTimes = new HashSet<Time>();
		Set<Time> allBusy = new HashSet<Time>();
		
		Time timeToAdd = null;

		//Adding all possible meeting times (every half hour 9-5) to the allTimes set
		//TODO: find alternative way to add all of these times
		allTimes.add(java.sql.Time.valueOf("09:00:00")); 
		allTimes.add(java.sql.Time.valueOf("09:30:00"));
		allTimes.add(java.sql.Time.valueOf("10:00:00"));
		allTimes.add(java.sql.Time.valueOf("10:30:00"));
		allTimes.add(java.sql.Time.valueOf("11:00:00"));
		allTimes.add(java.sql.Time.valueOf("11:30:00"));
		allTimes.add(java.sql.Time.valueOf("12:00:00"));
		allTimes.add(java.sql.Time.valueOf("12:30:00"));
		allTimes.add(java.sql.Time.valueOf("13:00:00"));
		allTimes.add(java.sql.Time.valueOf("13:30:00"));
		allTimes.add(java.sql.Time.valueOf("14:00:00"));
		allTimes.add(java.sql.Time.valueOf("14:30:00"));
		allTimes.add(java.sql.Time.valueOf("15:00:00"));
		allTimes.add(java.sql.Time.valueOf("15:30:00"));
		allTimes.add(java.sql.Time.valueOf("16:00:00"));
		allTimes.add(java.sql.Time.valueOf("16:30:00"));
		
		
		Iterator<Employee> employeeIterator = getIterator();
		
		while (employeeIterator.hasNext())
		{
			Employee nextEmployee = employeeIterator.next();
			
			//Creating new Set to store employee's busy times
			Set<Time> tempEmployeeBusySet = new HashSet<Time>();

			Iterator<Meeting> meetingIterator = nextEmployee.getMeetingIterator();
			
			//While iterator has next meeting to step through
			while (meetingIterator.hasNext())
			{
				Meeting nextMeeting = meetingIterator.next();
			
				//Add nextMeeting start time to temporary set
				tempEmployeeBusySet.add(nextMeeting.getStartTime());
		
			}
			
			
			
			//Add all contents of the temporary set to allBusy Set
			allBusy.addAll(tempEmployeeBusySet);
		}

		Set<Time> tempSet = new HashSet<Time>();
		
		for (Time time : allTimes) 
		{
			if (time.after(startTime) && time.before(endTime))
			{
				tempSet.add(time);
			}
		}		
		
		//Removing all times from tempSet which are in allBusy Set
		tempSet.removeAll(allBusy);
		
	    //Saves set of meetings to arrayList   
		 List<Time> meetingTimes = new ArrayList<Time>(tempSet);
		//Prints out all all times in arrayList
		 System.out.println("Possible meeting times:");
		 for (int i = 0; i < meetingTimes.size(); i++) 
		 {
		   Object o = meetingTimes.get(i);
		   System.out.println((i+1) + "\t" + o);
		 }
		
		Scanner s2 = new Scanner(System.in);
		System.out.println("Choose time to create meeting: (choose number from list e.g. 1)");
		int userChoice = s2.nextInt();
		
		//Stepping through all elements of arrayList
		for (int i = 0; i < meetingTimes.size(); i++)
		{
			//If current element id equal to user's choice of time
			if (meetingTimes.get(userChoice-1) == meetingTimes.get(i))
			{
				//Store time
				timeToAdd = meetingTimes.get(i);
			}
		}
		return timeToAdd;
		
		//TODO: GUI - user able to click on meeting time to add meeting at that time
	}
	
	/**
	 * Get the iterator from the Employee arrayList
	 * @return The iterator for the arrayList
	 */
	public Iterator<Employee> getIterator()
	{
		return allEmployees.iterator();
	}
	
	/**
	 * Get the iterator from the Employee arrayList
	 * @return The iterator for the arrayList
	 */
	public Iterator<Employee> getEmployeesAtMeetingIterator()
	{
		return employeesAtMeeting.iterator();
	}
	
	public static void editMeeting(Meeting toEdit)
	{
		editMeeting edit = new editMeeting();
		int option = 0;
		option = edit.getInstruction();
		
		switch(option) {
		case 1: toEdit.setDate(edit.changeDate(toEdit.getDate())); break;
		case 2: toEdit.setStartTime(edit.changeStartTime(toEdit.getStartTime())); break;
		case 3: toEdit.setEndTime(edit.changeEndTime(toEdit.getEndTime())); break;
		case 4: toEdit.setDescription(edit.changeDesc(toEdit.getDescription())); break;
		case 5: edit.changeEmployees(); break;
		case 6: /*TODO add exit*/ break;
		default:break;
		}
	}
	
}