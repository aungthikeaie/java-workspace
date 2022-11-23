package Day18;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseSorting 
{
	public static String names[] = {"Heart","Diamond","Clube","Spate"};
	
	public void printArray()
	{
		List list = Arrays.asList(names);
		
		System.out.println("Unsorted List\n"+list);
		
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.println("Sorted List\n"+list);
	}
	
	public static void main(String args[])
	{
		new ReverseSorting().printArray();
	}
}
