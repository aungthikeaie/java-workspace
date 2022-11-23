package Ch9No6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationForm
 */
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName = "";
		String lastName = "";
		String emailAddress = "";
		
		Cookie cookies[] = request.getCookies();
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("firstName"))
					firstName = cookie.getValue();
				else if(cookie.getName().equals("lastName"))
					lastName = cookie.getValue();
				else if(cookie.getName().equals("emailAddress"))
					emailAddress = cookie.getValue();
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
				"<html>" +
				"<head><center><title>Please Register</title></center></head>" +
				"<body><center>" +
					"<h2>Please Register</h2>" +
					"<form method = 'get' action = \"registrationServlet\">" +
						"<table>" +
							"<tr><td>First Name : </td><td><input type=\"text\" name=\"firstName\" value="+ firstName +"></td></tr>" +
							"<tr><td>Last Name&nbsp : </td><td><input type=\"text\" name=\"lastName\" value="+ lastName +"></td></tr>" +
							"<tr><td>Email : </td><td><input type=\"text\" name=\"emailAddress\" value="+ emailAddress +"></td></tr>" +
						"</table>" +
						"<input type=\"submit\" name=\"submit\">" +
					"</form>" +
				"</center></body>" +
				"</html>"
				);
	}
}
