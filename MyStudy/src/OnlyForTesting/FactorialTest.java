package OnlyForTesting;

import java.util.Scanner;

public class FactorialTest 
{
	public static void main(String[] args) 
	{
		
		String c ="";
		System.out.println("<------Factorial Calculator------->");
		Scanner sc = new Scanner(System.in);
		do
		{
			
			System.out.print("Enter a positive integer: ");
			int a = sc.nextInt();
			String con="";
			int result = 1;
			
			con += a+"! = ";
			if(a < 0)
			{
				System.out.println("Invalid input! Program stopped!");
				System.exit(0);
			}
			else if( a == 0)
			{
				System.out.println("The factorial of 0 is : 1");
			}
			else
			{
				for(int i=1 ; i<=a ; i++)
				{
					result *= i;
					if( i!=a)
						con += i + " x ";
					else
						con += i;
				}
			}
			System.out.println(con);
			System.out.println("The factorial of "+ a +" is : "+result);
			System.out.print("Do you want to input another integer.[y/n]");
			c= sc.next();
		}
		while(c.equals("y"));
		
		
	}
}
