package Day18;

import java.util.HashMap;
import java.util.Map;

public class MapTesting 
{
	private static String names[] = {"one","two","three","four","five","six","seven","two","ten","four"};
	
	public MapTesting()
	{
		HashMap map = new HashMap();
		Integer i;
		
		for(int count = 0; count<names.length; count++)
		{
			i = (Integer)map.get(new Character(names[count].charAt(0)));
			
			if(i == null)
			{
				map.put(new Character(names[count].charAt(0)), new Integer(1));
			}
			else
			{
				map.put(new Character(names[count].charAt(0)), new Integer(i.intValue()+1));
			}
		}
		
		System.out.println("numbers of words beginning with letter :");
		printMap(map);
	}
	
	public void printMap(Map mapRef)
	{
		System.out.println(mapRef.toString());
		System.out.println("size : "+mapRef.size());
		System.out.println("isEmpty : "+mapRef.isEmpty());
	}
	
	public static void main(String args[])
	{
		new MapTesting();
	}
}
