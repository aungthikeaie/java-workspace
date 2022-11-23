import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ThreeParams extends HttpServlet 
{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>" +
					"<body>" +
						"<h3>First : " + req.getParameter("param1") + "</h3>" +
						"<h3>Second : " + req.getParameter("param2") + "</h3>" +
						"<h3>Third : " + req.getParameter("param3") + "</h3>" +
					"</body>" +
					"</html>");
		
	}	
}
