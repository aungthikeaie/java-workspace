package Testing;

public class Fun 
{
	public static int arr[] = new int [45];
	public static void main(String args[])
	{
		int i = 0;
		while(i < arr.length)
		{
			int res = Rann();
			if(notFoundIt(res))
			{
				arr[i] = res;
				i++;
			}
		}
		
		for(Integer j : arr)
		{
			System.out.println(j);
		}
	}
	
	public static boolean notFoundIt(int res)
	{
		int a = 0;
		for(int i=0 ; i < arr.length ; i++)
		{
			if(arr[i] == res)
			{
				a = 1;
				break;
			}
		}
		
		if(a!=0)
			return false;
		else
			return true;
	}
	
	public static  int Rann()
	{
		int res = (int)((Math.random()*45)+1);
		return res;
	}
}
