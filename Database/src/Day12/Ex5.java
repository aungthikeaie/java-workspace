package Day12;

public class Ex5 
{
	public static void main(String[] args) 
	{
		int num1 = 100;
		int num2 = 0;
		if(num2 == 0)
			throw new ArithmeticException();
		int res = num1/num2;
		System.out.println("result = "+res);
	}
}
