package FirstPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LotteryNumbers")
public class LotteryNumbers extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private long modTime;
	private int[] numbers = new int[10];
	
	public void init() throws ServletException
	{
		modTime = System.currentTimeMillis()/1000*1000;
		for(int i=0; i<numbers.length ; i++)
		{
			numbers[i] = randomNum();
		}
	}
	
	public long getLastModified(HttpServletRequest request)
	{
		return(modTime);
	}
	
	private int randomNum()
	{
		return((int)(Math.random()*100));
	}
       
    public LotteryNumbers() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Your Lottery Numbers";
		String doctype =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0"+
				"Transitional//EN\">\n";
		out.println
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
