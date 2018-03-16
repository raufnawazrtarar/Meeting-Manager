import java.sql.Time;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Meeting {
	
	private Time date;
	private Time startTime;
	private Time endTime;
	private String description;
	private ArrayList<Employee> attending;

	
	/**
	 * @return the date
	 */
	public Time getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Time date) {
		this.date = date;
	}


	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}


	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}


	/**
	 * @return the endTime
	 */
	public Time getEndTime() {
		return endTime;
	}


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the attending
	 */
	public ArrayList<Employee> getAttending() {
		return attending;
	}


	/**
	 * @param attending the attending to set
	 */
	public void setAttending(ArrayList<Employee> attending) {
		this.attending = attending;
	}


	/**
	 * Default constructor for Meeting
	 */
	public Meeting()
	{
		date = null;
		startTime = null;
		endTime = null;
		description = "";
		attending = new ArrayList<Employee>();
	}
	
	/**
	 * Add feature
	 * @param toAdd
	 */
	public static void addMeeting(Meeting toAdd)
	{
		
	}
	
	/**
	 * Edit feature
	 * @param toEdit
	 */
	public static void editMeeting(Meeting toEdit)
	{
		
	}
	
	/**
	 * Delete feature
	 * @param toDelete
	 */
	public static void deleteMeeting(Meeting toDelete)
	{
		for(Employee employee : toDelete.getAttending())
		{
			employee.getDiary().remove(toDelete);
		}
	}
}
