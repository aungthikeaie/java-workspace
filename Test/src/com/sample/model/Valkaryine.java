package com.sample.model;

public class Valkaryine 
{
	private String name;
	private String type;
	private int age;
	private String bloodtype;
	
	
	
	public Valkaryine(String name, String type, int age, String bloodtype) 
	{
		super();
		this.name = name;
		this.type = type;
		this.age = age;
		this.bloodtype = bloodtype;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public String getBloodtype() 
	{
		return bloodtype;
	}
	
	public void setBloodtype(String bloodtype) 
	{
		this.bloodtype = bloodtype;
	}
}
