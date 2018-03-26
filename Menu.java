import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
	private ArrayList<Employee> employeesAtMeeting;
	private Stack<String> editsMade;
	private Employee employee;
	private String fileName;
	private Meeting[] lastChange;
	
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
	 * Default constructor for Menu
	 */
	public Menu()
	{
		allEmployees = new ArrayList<Employee>();
		employeesAtMeeting = new ArrayList<Employee>();	
		editsMade = new Stack<String>();
		lastChange = new Meeting[2];
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
	public void editMeeting(Meeting toEdit,Time date, Time startTime, 
			Time endTime, String description, ArrayList<Employee> attending)
	{
		boolean valid = true;
		
		//checks if all employees are free for the new meeting date and time
		boolean free = true;
		for(Employee employee : attending)
		{
			free = employee.isFree(date, startTime, endTime);
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
				deleteMeeting(lastChange[1]); //delete meeting from after edits
				addMeeting(lastChange[0]); //add meeting from before edits
				undo = true;
				break;
		}
		
		return undo;
	}
	
	
	/**
	 * Adding/Selecting meeting from list of potential meeting times
	 * @param startSearchTime 
	 * @param endSearchTime 
	 * @param duration 
	 */
	public void addMeetingFromList()
	{
		Date date = null;
		
		//User chooses employees from drop down list - these employees are added to 'employees' ArrayList
		//For testing just now i've created an employee to add
		Employee employee1 = new Employee("user", "Abc", "Xyz");
		Employee employee2 = new Employee("user", "Abc", "Xyz");
//		Employee employee3 = new Employee("user", "Abc", "Xyz");
		employeesAtMeeting.add(employee1);
		employeesAtMeeting.add(employee2);
		
		Time startSearchTime;
		Time endSearchTime;
		Long duration;
		
		
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
			 //System.out.println(date);
			 System.out.println(formatter.format(date));

	      }
		 catch (ParseException e) 
		 {
			 e.printStackTrace();
	     }
		
		//User chooses startTime and endTime of search
		//TODO - GUI - maybe select from drop down?
		
		boolean durationValid = false;
		do
		{
			System.out.println("Please enter the earliest time to start searching for a meeting (in the format hh:mm)");
			 
			String stringStartTime = (s1.nextLine() + ":00");
			 
			startSearchTime = Time.valueOf(stringStartTime);
			 
			System.out.println("Please enter the latest time to end searching for a meeting (in the format h:mm)");
			String stringEndTime = (s1.nextLine() + ":00");
			 
			endSearchTime = java.sql.Time.valueOf(stringEndTime);
			
			System.out.println("Please enter the duration of the meeting (please keep to 30 min segments for up to 2 hours and enter the time in minutes e.g. '30', '60', '90', '120')");
			duration = s1.nextLong();
			
			if (duration == 30 || duration == 60 || duration == 90 || duration == 120)
			{
				durationValid = true;
			}
			else
			{
				System.out.println("Incorrect duration entered");
				System.out.println("Please enter a half hour segment in minutes between 30 and 120");
				System.out.println("If you wish to make a meeting longer than 2 hours, please schedule 2 seperate meetings");
				duration = s1.nextLong();
			}
		} 
		while (durationValid == false);
		
		
		//search() method is called - (returning time chosen when feature is added)
		Time timeToAdd = search(employeesAtMeeting, date, startSearchTime, endSearchTime, duration);
		
		String stringTimeToAdd = timeToAdd.toString();
		
		System.out.println("Meeting starting at: " + stringTimeToAdd);

		LocalTime meetingEndTime = LocalTime.parse(stringTimeToAdd);

		meetingEndTime = meetingEndTime.plusMinutes(duration);
		
		System.out.println("Meeting ending at: " + meetingEndTime);
		System.out.println("Added to diaries");
		
		Meeting meetingToAdd= new Meeting(date, timeToAdd);
		
		ArrayList<Meeting> meetingsToAddList = new ArrayList<Meeting>();
		
		meetingsToAddList.add(meetingToAdd);
		
		if (duration == 60)
		{
			String tempString = timeToAdd.toString();

			//Create variable for second start time, adding the first start time
			LocalTime meetingStartTime2 = LocalTime.parse(tempString);

			//Add 30 mins to starting time
			meetingStartTime2 = meetingStartTime2.plusMinutes(30);
			
			//Convert variable to String
			String stringTimeToAdd2 = (meetingStartTime2.toString() + ":00");
			
			//Convert string to Time object
			Time timeToAdd2 = java.sql.Time.valueOf(stringTimeToAdd2);
			
			//Use value to create second meeting half an hour later
			Meeting meetingToAdd2 = new Meeting(date, timeToAdd2);
			
			//Add meeting to list of meetings
			meetingsToAddList.add(meetingToAdd2);
		}
		else if (duration == 90)
		{
			String tempString = timeToAdd.toString();

			//Create variable for second start time, adding the first start time
			LocalTime meetingStartTime2 = LocalTime.parse(tempString);

			//Add 30 mins to each starting time
			meetingStartTime2 = meetingStartTime2.plusMinutes(30);
			LocalTime meetingStartTime3 = meetingStartTime2.plusMinutes(30);
			
			//Convert variable to String variables
			String stringTimeToAdd2 = (meetingStartTime2.toString() + ":00");
			String stringTimeToAdd3 = (meetingStartTime3.toString() + ":00");
			
			//Convert Strings to Time object
			Time timeToAdd2 = java.sql.Time.valueOf(stringTimeToAdd2);
			Time timeToAdd3 = java.sql.Time.valueOf(stringTimeToAdd3);
			
			//Use valuse to create further meetings half an hour later
			Meeting meetingToAdd2 = new Meeting(date, timeToAdd2);
			Meeting meetingToAdd3 = new Meeting(date, timeToAdd3);
			
			//Add meetings to list of meetings
			meetingsToAddList.add(meetingToAdd2);
			meetingsToAddList.add(meetingToAdd3);
		}
		else if (duration == 120)
		{
			String tempString = timeToAdd.toString();

			//Create variable for second start time, adding the first start time
			LocalTime meetingStartTime2 = LocalTime.parse(tempString);

			//Add 30 mins to each starting time
			meetingStartTime2 = meetingStartTime2.plusMinutes(30);
			LocalTime meetingStartTime3 = meetingStartTime2.plusMinutes(30);
			LocalTime meetingStartTime4 = meetingStartTime3.plusMinutes(30);
			
			//Convert variable to String variables
			String stringTimeToAdd2 = (meetingStartTime2.toString() + ":00");
			String stringTimeToAdd3 = (meetingStartTime3.toString() + ":00");
			String stringTimeToAdd4 = (meetingStartTime4.toString() + ":00");
			
			//Convert Strings to Time object
			Time timeToAdd2 = java.sql.Time.valueOf(stringTimeToAdd2);
			Time timeToAdd3 = java.sql.Time.valueOf(stringTimeToAdd3);
			Time timeToAdd4 = java.sql.Time.valueOf(stringTimeToAdd4);
			
			//Use valuse to create further meetings half an hour later
			Meeting meetingToAdd2 = new Meeting(date, timeToAdd2);
			Meeting meetingToAdd3 = new Meeting(date, timeToAdd3);
			Meeting meetingToAdd4 = new Meeting(date, timeToAdd3);
			
			//Add meetings to list of meetings
			meetingsToAddList.add(meetingToAdd2);
			meetingsToAddList.add(meetingToAdd3);
			meetingsToAddList.add(meetingToAdd4);
		}
			
		
		//Stepping thorough all employees to be present at the meeting
		for(int i = 0; i < employeesAtMeeting.size(); i++)
		{	
			//stepping through all meetings in arrayList
			for (int j = 0; j < meetingsToAddList.size(); j++)
			{
				//Adds meeting into diary
				employeesAtMeeting.get(i).addMeeting(meetingsToAddList.get(j));
			}
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
	public Time search(ArrayList<Employee> employees, Date date, Time startSearchTime, Time endSearchTime, Long duration)
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
			if (time.equals(startSearchTime) || time.after(startSearchTime) && time.before(endSearchTime))
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
	
}
