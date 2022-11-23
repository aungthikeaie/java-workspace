package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreams 
{
	public static void main(String[] args) throws IOException 
	{
		File source = new File("D://Test Output/Object.bin");
		
		ObjectInputStream ois = null;
		
		try 
		{
			ois = new ObjectInputStream(new FileInputStream(source));
			
			Student sd = (Student) ois.readObject();
			System.out.println(sd.getId() + " : " + sd.getName());
			sd = (Student) ois.readObject();
			System.out.println(sd.getId() + " : " + sd.getName());
			sd = (Student) ois.readObject();
			System.out.println(sd.getId() + " : " + sd.getName());
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(ois != null)
				ois.close();
		}
	}
}
