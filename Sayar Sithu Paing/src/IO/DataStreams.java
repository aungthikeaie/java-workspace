package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams 
{
	public static void main(String[] args) throws IOException 
	{
		//DataOutputStream
		File destination = new File("D://Test Output/mydata.txt");
		DataOutputStream out = null;
		try 
		{
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(destination)));
			out.writeUTF("Himeko");
			out.writeUTF("Kallen");
			out.writeInt(500);
			out.writeInt(600);
			System.out.println("Finished");
			
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
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(destination)));
			System.out.println(in.readUTF());
			System.out.println(in.readUTF());
			System.out.println(in.readInt());
			System.out.println(in.readInt());
			
		if(in != null)
			in.close();
	}
}
