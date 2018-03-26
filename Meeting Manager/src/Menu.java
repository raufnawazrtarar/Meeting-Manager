import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
		editsMade = new Stack<String>();
		lastChange = new Meeting[2];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Testing
		/*Menu menu = new Menu();
		menu.allEmployees.add(new Employee("x"));
		menu.allEmployees.add(new Employee("y"));
		menu.allEmployees.add(new Employee("z"));
		Meeting m1 = new Meeting(Date.valueOf("2018-03-03"), Time.valueOf("10:00:00"), Time.valueOf("13:00:00"), "M1", menu.allEmployees);
		Meeting m2 = new Meeting(Date.valueOf("2018-03-03"), Time.valueOf("14:00:00"), Time.valueOf("16:00:00"), "M2", menu.allEmployees);
		Meeting m3 = new Meeting(Date.valueOf("2018-03-05"), Time.valueOf("09:00:00"), Time.valueOf("10:00:00"), "M3", menu.allEmployees);
		Meeting m4 = new Meeting(Date.valueOf("2018-04-03"), Time.valueOf("09:00:00"), Time.valueOf("10:00:00"), "M4", menu.allEmployees);
		Meeting m5 = new Meeting(Date.valueOf("2019-03-03"), Time.valueOf("09:00:00"), Time.valueOf("10:00:00"), "M5", menu.allEmployees);
		menu.addMeeting(m1);
		menu.addMeeting(m2);
		menu.addMeeting(m3);
		menu.addMeeting(m4);
		menu.addMeeting(m5);
		for(Employee e : menu.allEmployees)
		{
			e.displayDiary();
		}
		menu.undo();
		for(Employee e : menu.allEmployees)
		{
			e.displayDiary();
		}
		menu.deleteMeeting(m5);
		menu.deleteMeeting(m4);
		for(Employee e : menu.allEmployees)
		{
			e.displayDiary();
		}
		menu.undo();
		for(Employee e : menu.allEmployees)
		{
			e.displayDiary();
		}
		menu.editMeeting(m2, Date.valueOf("2018-03-03"), Time.valueOf("14:00:00"), Time.valueOf("15:00:00"), "M2 edited", menu.allEmployees);
		menu.undo();
		for(Employee e : menu.allEmployees)
		{
			e.displayDiary();
		}
		menu.undo();
		for(Employee e : menu.allEmployees)
		{
			e.displayDiary();
		}*/
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
	 * Undo feature (only undoes the very last change)
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
				
				//add meeting from before edits
				for(Employee employee : lastChange[0].getAttending())
				{
					employee.getDiary().add(lastChange[0]);
				}
				undo = true;
				break;
		}
		return undo;
	}
	
}
