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
	
}
