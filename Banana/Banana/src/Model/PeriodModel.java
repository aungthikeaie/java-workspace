package Model;

public class PeriodModel 
{
	private int period_id;
	private String start_date;
	private String end_date;
	private String description;
	
	public PeriodModel(int period_id, String start_date, String end_date,
			String description) 
	{
		this.period_id = period_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
	}

	public int getPeriod_id() 
	{
		return period_id;
	}

	public void setPeriod_id(int period_id) 
	{
		this.period_id = period_id;
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

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
	
}