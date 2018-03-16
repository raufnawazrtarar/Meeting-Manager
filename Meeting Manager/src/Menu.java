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
	private Meeting lastChange;
	
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
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
	 * Search feature
	 * @param employees
	 * @param date
	 * @param startTime
	 * @param endTime
	 */
	public void search(ArrayList<Employee> employees, Time date, Time startTime, Time endTime)
	{
		
	}
}
