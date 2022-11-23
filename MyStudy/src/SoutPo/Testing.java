package SoutPo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Testing 
{
	public static void main(String[] args) 
	{
		try 
		{
			Socket s = new Socket("192.168.201.20",9999);
			
			InputStream in = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			String data = br.readLine();
			
			System.out.println(data);
		}
		
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
