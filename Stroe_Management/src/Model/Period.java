package Model;

public class Period 
{
	private String start_date;
	private String end_date;
	private String desription;
	
	
	
	public Period(String start_date, String end_date, String desription) 
	{
		
		this.start_date = start_date;
		this.end_date = end_date;
		this.desription = desription;
	}
	
	public String getStart_date() 
	{
		return start_date;
	}
	
	public void setStart_date(String start_date) 
	{
		this.start_date = start_date;
	}
	
	public String getEnd_date() 
	{
		return end_date;
	}
	
	public void setEnd_date(String end_date) 
	{
		this.end_date = end_date;
	}
	
	public String getDesription() 
	{
		return desription;
	}
	
	public void setDesription(String desription) 
	{
		this.desription = desription;
	}
	
}
