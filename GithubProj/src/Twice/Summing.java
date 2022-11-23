package Twice;

public class Summing 
{
	public int a;
	public int b;
	public Summing(int a, int b)
	{
		this.a=a;
		this.b=b;
	}
	public int summ()
	{
		return a+b;
	}
	public static void main(String[] args) 
	{
		Summing ss = new Summing(2,3);
		System.out.println(ss.summ());
	}
}
