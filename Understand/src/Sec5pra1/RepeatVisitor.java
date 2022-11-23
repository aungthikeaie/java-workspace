package Sec5pra1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RepeatVisitor")
public class RepeatVisitor extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
    public RepeatVisitor() 
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean newUser = true;
		Cookie cookies[] = request.getCookies();
		if(cookies != null)
		{
			for(Cookie c : cookies)
			{
				if((c.getName().equals("repeatVisitor")) && (c.getValue().equals("yes")))
				{
					newUser = false;
					break;
				}
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
