package Day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Assignment1 
{
	public static String StudentName[] = {"Im_Nayeon", "Yoo_Jungyeon", "Hirai_Momo",
									"Minatozaki_Sana", "Park_Jihyo", "Myoui_Mina",
									"Kim_Dahyun", "Son_Chaeyoung", "Chou_Tzuyu"};
	
	public static ArrayList studentArr = new ArrayList(Arrays.asList(StudentName));
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		//(a)
		System.out.println("Names of the Students : \n"+studentArr);
		
		//(b)
		Collections.sort(studentArr);
		
		//(c)
		System.out.println("\nAfter Softing : \n"+studentArr);
		
		//(d)
		System.out.print("\nEnter Student Name you want to search : ");
		String name = sc.next();
		int i = Collections.binarySearch(studentArr, name);
		if(i >= 0)
			System.out.println(name+"\'s position in the list : "+i);
		else 
			System.out.println(name+" is not in the list.");
		
		//(e)
		System.out.print("\nEnter the student name you want to insert : ");
		String newName = sc.next();
		studentArr.add(newName);
		System.out.println("After adding new student name : \n"+studentArr);
		
		//(f)
		System.out.print("Enter the letter to search : ");
		String letter = sc.next();
		String upLetter = letter.toUpperCase();
		String lowLetter = letter.toLowerCase();
		startWith(upLetter, lowLetter,letter);
		
		//(g)
		System.out.print("\nEnter the letter to remove : ");
		String removeLetter = sc.next();
		String upRemoveLetter = removeLetter.toUpperCase();
		String lowRemoveLetter = removeLetter.toLowerCase();
		removeLet(upRemoveLetter,lowRemoveLetter,removeLetter);
		System.out.println("After removing : \n"+studentArr);
		
		//(h)
		studentArr.clear();
		System.out.println("\nAfter clearing : ");
		
	}
	
	public static void removeLet(String upRemoveLetter, String lowRemoveLetter, String removeLetter)
	{
		int i = 0;
		int j = 0;
		for(; j < studentArr.size() ; j++)
		{
			String ss = studentArr.get(j).toString();
			if(upRemoveLetter.charAt(0) == ss.charAt(0) || lowRemoveLetter.charAt(0) == ss.charAt(0))
			{
				i = 1;
				break;
			}
			else
				i = 0;
		}
		if(i==1)
			studentArr.remove(j);
		else
			System.out.println("No Student");
	}
	
	public static void startWith(String upLetter,String lowLetter,String letter)
	{
		int i = 0;
		int j = 0;
		for(; j < studentArr.size() ; j++)
		{
			String ss = studentArr.get(j).toString();
			if(upLetter.charAt(0) == ss.charAt(0) || lowLetter.charAt(0) == ss.charAt(0))
			{
				i = 1;
				break;
			}
			else
				i = 0;
		}
		if(i==1)
			System.out.println("Student names start with \'"+letter+"\' are : \n"+studentArr.get(j));
		else
			System.out.println("No Student.");
	}
}
