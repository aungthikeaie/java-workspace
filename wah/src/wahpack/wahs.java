package wahpack;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wahs")
public class wahs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstname="";
		String lastname="";
		String emailaddress="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(Cookie c:cookies)
			{
				if(c.getName().equals("firstname"))
					firstname=c.getValue();
				else if(c.getName().equals("lastname"))
					lastname=c.getValue();
				else if(c.getName().equals("emailaddress"))
					emailaddress=c.getValue();
			}
		}
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title><h1>Please Register</h1></title>");
		out.println("</head>");
		out.println("<body><center>");
		out.println("<form method='GET' ACTION=\"registrationServlet\">");
		out.println("<table>"
				+ "<tr>"
					+ "<td>FirstName: </td>"
					+ "<td><input type=\"text\" name=\"firstname\" value="+firstname+"> </td>"
				+ "</tr>"
				+ "<tr>"
					+ "<td>LastName: </td>"
					+ "<td><input type=\"text\" name=\"lastname\" value="+lastname+"></td>"			
				+ "</tr>"
				+ "<tr>"
					+ "<td>EmailAddress: </td>"
					+ "<td><input type=\"text\" name=\"emailaddress\" value="+emailaddress+"></td>"
				+ "</tr>"
				+ "</table>"
				+ "<br><input type=\"submit\" name=\"sumit query\">");
		out.println("</form>");
		out.println("</center></body>");
		out.println("</html>");
	}
}
