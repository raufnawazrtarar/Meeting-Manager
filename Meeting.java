import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Meeting implements Comparable<Meeting>{
	
	private Date date;
	private Time startTime;
	private Time endTime;
	private String description;
	private ArrayList<Employee> attending;

	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
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
	 * Alternative constructor for Meeting
	 * @param date
	 * @param startTime
	 */
	public Meeting(Date date, Time startTime)
	{
		this.date = date;
		this.startTime = startTime;
		endTime = null;
		description = "";
		attending = new ArrayList<Employee>();
	}
	
	/**
	 * Alternative constructor for Meeting
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @param description
	 * @param attending
	 */
	public Meeting(Time date, Time startTime, Time endTime, String description, ArrayList<Employee> attending)
	{
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.attending = attending;
	}
	
	/**
	 * Copy constructor for Meeting
	 * @param meeting
	 */
	public Meeting(Meeting meeting)
	{
		date = meeting.getDate();
		startTime = meeting.getStartTime();
		endTime = meeting.getEndTime();
		description = meeting.getDescription();
		attending = new ArrayList<Employee>(meeting.getAttending());
	}


	@Override
	public int compareTo(Meeting m2)
	{
		int compare = date.compareTo(m2.getDate());
		if(compare == 0)
		{
			return startTime.compareTo(m2.getStartTime());
		}
		else
		{
			return compare;
		}
	}

}
