package Day13;

public class Exceptions 
{
	public static void main(String args[])
	{
		try 
		{
			if(args.length == 0)
				System.out.println(args[0]);
		}
		finally
		{
			System.out.println("The end");
		}
	}
}
