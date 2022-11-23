package Model;

public class TopUpModel 
{
	public int no;
	public String name;
	public String unit;
	public int stock;
	
	public TopUpModel(int no, String name, String unit, int stock) 
	{
		this.no = no;
		this.name = name;
		this.unit = unit;
		this.stock = stock;
	}

	public int getNo() 
	{
		return no;
	}

	public void setNo(int no) 
	{
		this.no = no;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getUnit() 
	{
		return unit;
	}

	public void setUnit(String unit) 
	{
		this.unit = unit;
	}

	public int getStock() 
	{
		return stock;
	}

	public void setStock(int stock) 
	{
		this.stock = stock;
	}
}
