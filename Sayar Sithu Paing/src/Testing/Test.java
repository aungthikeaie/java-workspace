package Testing;

public class Test 
{
	public static void main(String[] args) 
	{
		int a[] = new int[10];
		for(int i = 0 ; i < 10 ; )
		{
			a[i] = 1;
		}
		
		for(int i = 0 ; i < 10 ; i++)
		{
			System.out.println(a[i]);
		}
	}
}
