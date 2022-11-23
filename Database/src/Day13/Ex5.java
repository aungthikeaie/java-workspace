package Day13;

public class Ex5 
{
	public static void main(String args[])throws InterruptedException
	{
		try
		{
			f();
			System.out.println("1");
		}
		finally
		{
			System.out.println("2");
		}
		System.out.println("3");
	}
	static void f() throws InterruptedException
	{
		throw new InterruptedException("Time to go home.");
	}
}
