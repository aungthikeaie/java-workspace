package Day12;

public class Ex2 
{
	public static void main(String args[])
	{
		try
		{
		int num1 = 100;
		int num2 = 0;
		int result = num1/num2;
		System.out.println("result = "+result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Error occured in division!");
		}
	}
}
