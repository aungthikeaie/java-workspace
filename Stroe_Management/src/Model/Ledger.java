package Model;

public class Ledger
{
	private int ledget_id;
	private String transaction_date;
	private String source;
	private int iinvoice_no;
	private String iinvoice_date;
	private int count;
	private double unit_price;
	private double total_cost;
	private int used;
	private int stock_in_hand;
	private String sign;
	private String remark;
	private int item_code;
	private int period_id;
	
	public Ledger(int ledget_id, String transaction_date, String source,
			int iinvoice_no, String iinvoice_date, int count,
			double unit_price, double total_cost, int used, int stock_in_hand,
			String sign, String remark, int item_code, int period_id)
	{
		this.ledget_id = ledget_id;
		this.transaction_date = transaction_date;
		this.source = source;
		this.iinvoice_no = iinvoice_no;
		this.iinvoice_date = iinvoice_date;
		this.count = count;
		this.unit_price = unit_price;
		this.total_cost = total_cost;
		this.used = used;
		this.stock_in_hand = stock_in_hand;
		this.sign = sign;
		this.remark = remark;
		this.item_code = item_code;
		this.period_id = period_id;
	}

	public int getLedget_id() 
	{
		return ledget_id;
	}

	public void setLedget_id(int ledget_id) 
	{
		this.ledget_id = ledget_id;
	}

	public String getTransaction_date() 
	{
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) 
	{
		this.transaction_date = transaction_date;
	}

	public String getSource() 
	{
		return source;
	}

	public void setSource(String source) 
	{
		this.source = source;
	}

	public int getIinvoice_no() 
	{
		return iinvoice_no;
	}

	public void setIinvoice_no(int iinvoice_no) 
	{
		this.iinvoice_no = iinvoice_no;
	}

	public String getIinvoice_date() 
	{
		return iinvoice_date;
	}

	public void setIinvoice_date(String iinvoice_date) 
	{
		this.iinvoice_date = iinvoice_date;
	}

	public int getCount() 
	{
		return count;
	}

	public void setCount(int count) 
	{
		this.count = count;
	}

	public double getUnit_price() 
	{
		return unit_price;
	}

	public void setUnit_price(double unit_price) 
	{
		this.unit_price = unit_price;
	}

	public double getTotal_cost() 
	{
		return total_cost;
	}

	public void setTotal_cost(double total_cost) 
	{
		this.total_cost = total_cost;
	}

	public int getUsed() 
	{
		return used;
	}

	public void setUsed(int used) 
	{
		this.used = used;
	}

	public int getStock_in_hand() 
	{
		return stock_in_hand;
	}

	public void setStock_in_hand(int stock_in_hand) 
	{
		this.stock_in_hand = stock_in_hand;
	}

	public String getSign() 
	{
		return sign;
	}

	public void setSign(String sign) 
	{
		this.sign = sign;
	}

	public String getRemark() 
	{
		return remark;
	}

	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public int getItem_code() 
	{
		return item_code;
	}

	public void setItem_code(int item_code) 
	{
		this.item_code = item_code;
	}

	public int getPeriod_id() 
	{
		return period_id;
	}

	public void setPeriod_id(int period_id) 
	{
		this.period_id = period_id;
	}
	
	
}
