package Ch9No6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		boolean isMissingValue = false;
		
		String firstName = request.getParameter("firstName");
		if(firstName.equals("") || firstName.equals("Missing_first_name"))
		{
			firstName = "Missing_first_name";
			isMissingValue = true;
		}
		
		String lastName = request.getParameter("lastName");
		if(lastName.equals("") || lastName.equals("Missing_last_name"))
		{
			lastName = "Missing_last_name";
			isMissingValue = true;
		}
		
		String email = request.getParameter("emailAddress");
		if(email.equals("") || email.equals("Missing_email"))
		{
			email = "Missing_email";
			isMissingValue = true;
		}
		
		Cookie c1 = new Cookie( "firstName" , firstName);
		c1.setMaxAge(60);
		response.addCookie(c1);
		
		Cookie c2 = new Cookie( "lastName" , lastName);
		c1.setMaxAge(60);
		response.addCookie(c2);
		
		Cookie c3 = new Cookie( "emailAddress" , email);
		c1.setMaxAge(60);
		response.addCookie(c3);
		
		if(isMissingValue)
		{
			response.sendRedirect("./RF");
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(
					"<html>" +
							"<body><center>" +
								"<h2>Thanks for registration!</h2></br></br>" +
								"<li>First Name : " + firstName +
								"<li>Last Name  : " + lastName +
								"<li>Email : " + email +
							"</center></body>" +
					"</html>"
					);
		}
	}
}
