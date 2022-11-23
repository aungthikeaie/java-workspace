package IO;

//It can only read character streams

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreams 
{
	public static void main(String[] args) 
	{
		File source = new File("D://Test Input//sana2.jpg");
		File destination = new File("D://Test Output//newsana2.jpg");
		FileReader fr = null;
		FileWriter fw = null;
		
		try 
		{
			fr = new FileReader(source);
			fw = new FileWriter(destination);
			
			int code ;
			while((code = fr.read()) != -1)
			{
				fw.write(code);
			}
			
			System.out.println("Finished.");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
