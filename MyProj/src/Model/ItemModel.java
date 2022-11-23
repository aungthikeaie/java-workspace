package Model;

public class ItemModel 
{
	private	int item_code;
	private	String item_name;
	private String unit;
	private int bincard_no;
	private	int category_id;
	
	public ItemModel(int item_code, String item_name, String unit, int bincard_no,int category_id) 
	{
		super();
		this.item_code = item_code;
		this.item_name = item_name;
		this.unit = unit;
		this.bincard_no = bincard_no;
		this.category_id = category_id;
	}

	public int getItem_code() 
	{
		return item_code;
	}

	public void setItem_code(int item_code) 
	{
		this.item_code = item_code;
	}

	public String getItem_name() 
	{
		return item_name;
	}

	public void setItem_name(String item_name) 
	{
		this.item_name = item_name;
	}

	public String getUnit() 
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public int getBincard_no()
	{
		return bincard_no;
	}

	public void setBincard_no(int bincard_no) 
	{
		this.bincard_no = bincard_no;
	}

	public int getCategory_id()
	{
		return category_id;
	}

	public void setCategory_id(int category_id) 
	{
		this.category_id = category_id;
	}
}
