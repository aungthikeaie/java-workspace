package Day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sorting 
{
	public static String names[] = {"Heart","Diamond","Club","Spate"};
	
	public void printElement()
	{
		ArrayList list = new ArrayList(Arrays.asList(names));
		
		System.out.println("Unsorted ArrayList");
		System.out.println(list+"\t");
		
		Collections.sort(list);
		
		System.out.println("Sorted ArrayList");
		System.out.println(list+"\t");
		
		
 	}
	
	public static void main(String args[])
	{
		new Sorting().printElement();
	}
}
