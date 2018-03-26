import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class editMeeting {
	
	public editMeeting() {
		
	}
	
	public int getInstruction()
	{
		int option;
		System.out.println("1. Change Date");
		System.out.println("2. Change Start time");
		System.out.println("3. Change End time");
		System.out.println("4. Change Description");
		System.out.println("5. Change EmployeesAttending");
		System.out.println("6. Exit");
		System.out.print("Please enter the number of the change you wish to make: ");
		
		Scanner s1 = new Scanner(System.in);
		do {
		option = s1.nextInt();
		}
		while(option < 1 || option > 6);
		
		return option;
	}
	
	public Date changeDate(Date date)
	{
		Boolean fail = true;
		while(fail) {
			System.out.println("The current date is: "+date);
			Scanner s1 = new Scanner(System.in);
			System.out.println("Please enter new date in the format dd-mm-yyyy: ");
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
				 fail = false;
				 return date;
		      }
			 catch (ParseException e) 
			 {
				 e.printStackTrace();
		     }
		}
		return date;
	}
	
	public Time changeStartTime(Time time)
	{
		System.out.println("The current start time is: "+time);
		
		System.out.println("Please enter the earliest time to start searching for a meeting (in the format hh:mm:ss)");
		Scanner s1 = new Scanner(System.in);
		String stringStartTime = s1.nextLine();
		 
		Time startTime = Time.valueOf(stringStartTime);
		return time;
	}
	
	public Time changeEndTime(Time time)
	{
		System.out.println("The current end time is: "+time);
		
		System.out.println("Please enter the latest time to start searching for a meeting (in the format hh:mm:ss)");
		Scanner s1 = new Scanner(System.in);
		String stringEndTime = s1.nextLine();
		 
		Time startTime = Time.valueOf(stringEndTime);
		return time;
	}
	
	public String changeDesc(String desc)
	{
		System.out.println("The current end time is: "+desc);
		
		System.out.println("Please enter new description: ");
		Scanner s1 = new Scanner(System.in);
		desc = s1.nextLine();
		return desc;
	}
	
	public void changeEmployees()
	{
		//TODO WITH UI
	}
}