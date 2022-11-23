package Session2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lottery
 */
@WebServlet("/Lottery")
public class Lottery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public long modTime = System.currentTimeMillis()/1000*1000;
	public int[] number = new int[10];
	
	public void init()
	{
		for(int i = 0 ; i < number.length ; i++)
		{
			number[i] = randomNum();
		}
	}
	
	public int randomNum()
	{
		return (int) (Math.random()*100);
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "lottery";
		out.println("<html>"
				+ "<head><title>"+title+"</title></head>"
						+ "<body>"
						+ "<h1 align=\"center\">Lottery</h1>"
						+ "<ol>");
		for(int i = 0 ; i < number.length ; i ++)
		{
			out.println("<li>"+number[i]+"</li>");
		}
		out.println("</ol></body></html>");
	}

	
}
