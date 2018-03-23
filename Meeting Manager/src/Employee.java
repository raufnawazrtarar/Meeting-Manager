import java.sql.Time;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Employee {
	
	private int employeeID;
	private String firstName;
	private String surname;
	private boolean status;
	private TreeSet<Meeting> diary;
	
	
	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstname the firstName to set
	 */
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the diary
	 */
	public TreeSet<Meeting> getDiary() {
		return diary;
	}
	/**
	 * @param diary the diary to set
	 */
	public void setDiary(TreeSet<Meeting> diary) {
		this.diary = diary;
	}
	
	/**
	 * Default constructor for Employee
	 */
	public Employee()
	{
		employeeID = 0; //need to create and assign a unique ID
		firstName = "";
		surname = "";
		status = true;
		diary = new TreeSet<Meeting>(new MeetingComp());
	}
	

	/**
	 * 
	 * @param viewType
	 */
	public void viewDiary(String viewType)
	{
		
	}
	
	/**
	 * Determines if an employee has no meetings scheduled between 2 times on a certain date
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public boolean isFree(Time date, Time startTime, Time endTime)
	{
		boolean free = true;
		Meeting from = new Meeting(date, startTime);
		Meeting to = new Meeting(date, endTime);
		free = diary.subSet(from, to).isEmpty();
		return free;
	}
}
