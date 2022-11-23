package Session9;

public class CollectionModel 
{
	int number;
	String name;
	String position;
	
	public CollectionModel(int number, String name, String position) 
	{
		super();
		this.number = number;
		this.name = name;
		this.position = position;
	}

	public int getNumber() 
	{
		return number;
	}

	public void setNumber(int number) 
	{
		this.number = number;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getPosition() 
	{
		return position;
	}

	public void setPosition(String position) 
	{
		this.position = position;
	}
}


