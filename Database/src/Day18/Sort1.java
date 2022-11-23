package Day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort1 
{
	private static String suits[] = {"Hearts" , "Diamonds" , "Clubs" , "Spades"};
	
	public static void main(String[] args) 
	{
		new Sort1().printElements();
	}
	
	public void printElements()
	{
		ArrayList list = new ArrayList(Arrays.asList(suits));
		
		System.out.println("Unsorted array elements : " + list);
		
		Collections.sort(list);
		
		System.out.println("Sorted array elements : " + list);
	}
}
