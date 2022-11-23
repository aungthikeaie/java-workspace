package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered_Writer 
{
	public static void main(String[] args) throws IOException 
	{
		String lines[] = {"Hello!","I'm Ai-chan.","Nice to meet you."};
		File destination = new File("D://Test Output//Writer.txt");
		FileWriter fw;
		BufferedWriter bw = null;
		try 
		{
			fw = new FileWriter(destination);
			bw = new BufferedWriter(fw);
			
			for(String line: lines)
			{
				bw.write(line);
				bw.newLine();
			}
			System.out.println("Finished.");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(bw != null)
				bw.close();
		}
		
	}
}
