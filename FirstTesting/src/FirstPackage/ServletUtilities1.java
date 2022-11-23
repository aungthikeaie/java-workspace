package FirstPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletUtilities1")
public class ServletUtilities1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static final String DOCTYPE = "<!DOCTYPE HTML PUBLIC \"-//W#C//DTD HTML 4.0 " + "Transitional//EN\">";
    
    public static String headWithTitle(String title)
    {
    	return(DOCTYPE + "\n" +
    			"<html>\n" + 
    			"<head><title>" + title + "</title></head>\n");
    }
	
    public ServletUtilities1() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
