import java.util.Comparator;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class MeetingComp implements Comparator<Meeting>{
	
	@Override
	public int compare(Meeting m1, Meeting m2)
	{
		int date = m1.getDate().compareTo(m2.getDate());
		if(date == 0)
		{
			return m1.getStartTime().compareTo(m2.getStartTime());
		}
		else
		{
			return date;
		}
	}

}
