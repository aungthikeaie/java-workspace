package wahpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationSevlet")
public class registrationServlet extends HttpServlet 
  {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		boolean isMissingValue=false;
		
		String firstName=request.getParameter("firstname");
		if(firstName.equals("")|| firstName.equals("missing_first_name"))
		{
			firstName=new String("missing_first_name");
			isMissingValue=true;
		}
		String lastName=request.getParameter("lastname");
		if(lastName.equals("")|| lastName.equals("missing_last_name"))
		{
			lastName=new String("missing_last_name");
			isMissingValue=true;
		}
		String emailAddress=request.getParameter("emailaddress");
		if(emailAddress.equals("")|| emailAddress.equals("missing_emailaddress"))
		{
			emailAddress=new String("missing_emailaddress");
			isMissingValue=true;
		}
		Cookie c1=new Cookie("firstname","firstname");
		c1.setMaxAge(60);
		response.addCookie(c1);
		Cookie c2=new Cookie("lastname","lastname");
		c1.setMaxAge(60);
		response.addCookie(c2);
		Cookie c3=new Cookie("emailaddress","emailaddress");
		c1.setMaxAge(60);
		response.addCookie(c3);
		String formAddress="./register";
		if(isMissingValue)
		{
			response.sendRedirect(formAddress);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>"
					+ 		"<head>"
					+ 		"<title>"
					+ 			"<h1>Thanks for registering</h1>"
					+ 		"</title>"
					+ 		"</head>"
					+ 		"<body><center>"
					+ 			"<li>First Name:"+firstName
					+			"<li>Last Name:"+lastName
					+			"<li>Email:"+emailAddress
					+ 		"</center></body>"
					+ "</html>");
		}
	}

	


}
