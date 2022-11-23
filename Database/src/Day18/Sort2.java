package Day18;

import java.util.Arrays;
import java.util.Collections;

public class Sort2 
{
	private static String suits[] = {"Hearts" , "Diamonds" , "Clubs" , "Spades"};
	
	public static void main(String[] args) 
	{
		new Sort2().printElements();
	}
	
	public void printElements()
	{
		java.util.List list = Arrays.asList(suits);
		
		System.out.println("Unsorted array elements : " + list);
		
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.println("Sorted array elements : " + list);
	}
}
