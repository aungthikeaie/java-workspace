package Day18;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms1 
{
	private String letters[] = {"P","C","M"}, lettersCopy[];
	private List list, copyList;
	public Algorithms1()
	{
		list = Arrays.asList(letters);
		lettersCopy = new String[3];
		copyList = Arrays.asList(lettersCopy);
		
		
		System.out.println("Printing initial statistics: ");
		printStatistics(list);
		
		Collections.reverse(list);
		System.out.println("Printing statistics after calling reverse: ");
		printStatistics(list);
		
		Collections.copy(copyList, list);
		System.out.println("Printing statistics after copying: ");
		printStatistics(copyList);
		
		Collections.fill(list, "R");
		System.out.println("Printing statistics after calling fill: ");
		printStatistics(list);
		
		
	}
	
	public void printStatistics(List listRef)
	{
		System.out.print("The List is : ");
		
		for(int k = 0 ; k<listRef.size();k++)
		{
			System.out.print(listRef.get(k)+" ");
		}
		System.out.println("\nMax: "+ Collections.max(listRef));
		System.out.println("Min: \n"+ Collections.min(listRef));
	}
	
	public static void main(String args[])
	{
		new Algorithms1();
	}
}
