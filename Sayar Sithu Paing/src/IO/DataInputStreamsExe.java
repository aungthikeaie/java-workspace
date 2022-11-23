package IO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamsExe 
{
	public static void main(String[] args) throws IOException 
	{
		File source = new File("D://Test Output/DataStreamsExercise.txt");
		
		DataInputStream in = null;
		
		try 
		{
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(source)));
			
			int limit = DataOutputStreamsExe.valk.length*2;
			
			for(int i = 1 ; i <= limit  ; i++)
			{
				if(i%2 != 0)
					System.out.print(in.readUTF());
				else
					System.out.println(" - "+in.readUTF());
			}
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
			if(in != null)
				in.close();
		}
	}
}
