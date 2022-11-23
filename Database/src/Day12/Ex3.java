package Day12;

public class Ex3 
{
	public static void main(String args[])
	{
		try {
			int num1 = 100;
			int num2 = 0;
			int res = num1/num2;
			System.out.println("result"+res);
		} catch (ArithmeticException e) 
		{
			System.err.println("Error occured in division!");
		}finally
		{
			System.out.println("exit program.");
		}
	}
}
