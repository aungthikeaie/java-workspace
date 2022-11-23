package IO;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreams 
{
	public static void main(String[] args) throws IOException 
	{
		File destination = new File("D://Test Output/Object.bin");
		
		Student sd1 = new Student("Kallen", 2);
		Student sd2 = new Student("Mei" , 1);
		Student sd3 = new Student("Rita" , 10);
		ObjectOutputStream oos = null;
		try 
		{
			oos = new ObjectOutputStream(new FileOutputStream(destination));
			oos.writeObject(sd1);
			oos.writeObject(sd2);
			oos.writeObject(sd3);
			
			System.out.println("Finished.");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(oos != null)
				oos.close();
		}
	}
}
