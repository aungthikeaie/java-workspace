package J2EE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/repeatVisitor")
public class repeatVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public repeatVisitor() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie cookies[] = request.getCookies();
		boolean isNew = true;
		
		if(cookies != null)
		{
			for(Cookie c : cookies)
			{
				if(c.getName().equals("repeatVisitor") && c.getValue().equals("yes"))
				{	
					isNew = false;
					break;
				}
			}
		}
		
		String title;
		
		if(isNew)
		{
			Cookie newCookie = new Cookie("repeatVisitor", "yes");
			newCookie.setMaxAge(10);
			response.addCookie(newCookie);
			title = "Welcome New User";
		}
		else
		{
			title = "Welcome Back";
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
				"<html>" +
				"<body>" +
				"	<h1>" + title + "</h1>" +
				"</body>" +
				"</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
