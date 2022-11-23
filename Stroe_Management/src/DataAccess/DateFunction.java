package DataAccess;

import java.util.StringTokenizer;

public class DateFunction 
{
	public static String dates;
	
	public String day,month,year;
	
	public static String identifier;
	
	public static String dateReturn(String date)
	{
		StringTokenizer stk = new StringTokenizer(date);
		
		stk.nextToken();
		
		String month = stk.nextToken();
		String day = stk.nextToken();
		
		stk.nextToken();
		stk.nextToken();
		
		String year = stk.nextToken();
		
		switch (month) 
		{
			case "Jan" : identifier = "1" ;	break;
			case "Feb" : identifier = "2" ;	break;
			case "Mar" : identifier = "3" ;	break;
			case "Apr" : identifier = "4" ;	break;
			case "May" : identifier = "5" ;	break;
			case "Jun" : identifier = "6" ;	break;
			case "Jul" : identifier = "7" ;	break;
			case "Aug" : identifier = "8" ;	break;
			case "Sep" : identifier = "9" ;	break;
			case "Oct" : identifier = "10" ;	break;
			case "Nov" : identifier = "11" ;	break;
			case "Dec" : identifier = "12" ;	break;

			default:
			break;
		}
		
		dates = year+"-"+identifier+"-"+day;
		
		return dates;
	}
	public static void main(String args[])
	{
		new DateFunction();
		System.out.println(dates);
		
	}
}
