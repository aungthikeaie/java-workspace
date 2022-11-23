package OnlyForTesting;

public class TestingLooping 
{
	public static void main(String[] args) 
	{
		int a = 0;
		for(int i = 1 ; i <=9 ; i++,a++)
		{
			for(int j = 1 ; j<=9 ; j++)
			{
				if( 1+a==j || 9-a==j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
