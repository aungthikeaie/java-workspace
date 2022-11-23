package IO;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream 
{
	public static void main(String[] args) throws IOException 
	{
		File source = new File("D:\\Test Input\\Read.txt");
		File des = new File("D:\\Test Output\\write.txt");
		FileOutputStream fos = null; 
		FileInputStream fis = null;
		
		try 
		{
			fis = new FileInputStream(source);
			fos = new FileOutputStream(des);
			
			int code;
			
			while((code = fis.read()) != -1)
			{
				fos.write(code);
			}
			System.out.println("Writing is finished.");
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
			if(fis != null)
			fis.close();
			
			if(fos != null)
			fos.close();
		}
	}
}
