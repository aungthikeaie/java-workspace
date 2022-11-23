package Day12;

public class Ex4 
{
	public static void main(String args[])
	{
		printAverage(100,0);
		System.out.println("Exit main().");
	}

	private static void printAverage(int totalSum, int totalNumber) 
	{
		int average = computeAverage(totalSum,totalNumber);
		System.out.println("Average = "+ totalSum+"/"+totalNumber+"="+average);
		System.out.println("Exit printAverage().");
		
	}

	private static int computeAverage(int sum, int number) 
	{
		System.out.println("Computing average.");
		return sum/number;
	}
}
