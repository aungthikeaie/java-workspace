

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		boolean isMissingValue = false;
		
		String firstName = request.getParameter("firstName");
		if(firstName.equals("") || firstName.equals("Missing_first_name"))
		{
			firstName = new String("Missing_first_name");
			isMissingValue = true;
		}
		
		String lastName = request.getParameter("lastName");
		if(lastName.equals("") || lastName.equals("Missing_last_name"))
		{
			lastName = new String("Missing_last_name");
			isMissingValue = true;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
