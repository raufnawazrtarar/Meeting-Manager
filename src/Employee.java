import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Employee implements Serializable{
	
	private String userName;
	private String password;
	private String firstName;
	private String surname;
	private boolean status;
	private TreeSet<Meeting> diary;
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param username the userName to set
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
		userName = "";
		firstName = "";
		surname = "";
		status = true;
		diary = new TreeSet<Meeting>();
	}
	
	/**
	 * Alternative constructor for Employee
	 */
	public Employee(String userName, String password, String firstName, String surname)
	{
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.surname = surname;
		status = true;
		diary = new TreeSet<Meeting>();
	}

	
	
	/**
	 * Determines if an employee has no meetings, other a specified meeting, scheduled between 2 times on a certain date
	 * @param ignoreMeeting Meeting to ignore
	 * @param date Date to check
	 * @param startTime Start time
	 * @param endTime End time
	 * @return If the employee is free between the specified times
	 */
	public boolean isFree(Meeting ignoreMeeting, Date date, Time startTime, Time endTime)
	{
		boolean free = true;
		for(Meeting m : diary)
		{
			if(m != ignoreMeeting)
			{
				if(date.compareTo(m.getDate()) == 0)
				{
					boolean start = startTime.after(m.getStartTime()) && startTime.before(m.getEndTime());
					boolean end = endTime.after(m.getStartTime()) && endTime.before(m.getEndTime());
					if(start || end)
					{
						free = false;
						return free;
					}
				}
			}
		}
		return free;
	}
	
	/**
	 * Display diary to console
	 */
	public void displayDiary()
	{
		int count = 0;
		for(Meeting m : diary)
		{
			System.out.println(count + ") ");
			m.display();
			count ++;
		}
		System.out.println();
	}
}
