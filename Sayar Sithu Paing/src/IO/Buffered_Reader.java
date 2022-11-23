package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Buffered_Reader 
{
	public static void main(String[] args) throws IOException 
	{
		File source = new File("D://Test Input//Read.txt");
		BufferedReader br = null;
		
		try 
		{
			FileReader fr = new FileReader(source);
			br = new BufferedReader(fr);
			
			String line;
			
			int i = 0;
			
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
				i++;
			}
			System.out.println("Number of looping = " + i);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
				br.close();
		}
		
	}
}
