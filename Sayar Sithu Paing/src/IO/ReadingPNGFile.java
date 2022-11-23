package IO;

/*
Byte Stream can read any type of files including mp3, mp4, jpg, png, etc.
But it only reads one byte per funtion i.e read()
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadingPNGFile 
{
	public static void main(String[] args) throws IOException 
	{
		File source = new File("D://Test Input//Sana2.jpg");
		File destination = new File("D://Test Output//new_Sana.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try 
		{
			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);
			
			int code;
			
			while((code = fis.read()) != -1)
			{
				fos.write(code);
				//it loops as the Size of the file
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
			if(fis != null)
				fis.close();
			if(fos != null)
				fos.close();
		}
		
	}
}
