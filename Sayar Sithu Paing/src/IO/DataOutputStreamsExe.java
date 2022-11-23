package IO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamsExe 
{
	public static String valk[] = {"Kiana","Kallen","Mei","Bronya","Sakura","Himeko","Fuha"};
	
	public static void main(String[] args) throws IOException 
	{
		File destination = new File("D://Test Output/DataStreamsExercise.txt");
		String type[] = {"Mech","Mech","Biologic","Physic","Biologic","Biologic","Physic"};
		
		DataOutputStream out = null;
		
		try 
		{
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(destination)));
			
			for(int i = 0 ; i < valk.length ; i ++)
			{
				out.writeUTF(valk[i]);
				out.writeUTF(type[i]);
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
		finally
		{
			if(out != null)
				out.close();
		}
	}
}
