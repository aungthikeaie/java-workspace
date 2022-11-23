package IO;

import java.io.Serializable;

public class Student implements Serializable
{

	private static final long serialVersionUID = 123L;
	
	private String name;
	private int id;
	
	public Student(String name, int id) 
	{
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	
}
