package Ch9No8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowItems")
public class ShowItems extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		ArrayList<String> previousItems = (ArrayList<String>) session.getAttribute("previousItems");
		
		if(previousItems == null)
		{
			previousItems = new ArrayList<String>();
			session.setAttribute("previousItems", previousItems);
		}
		
		String newItem = request.getParameter("newItem");
		if((newItem != null) && (!newItem.trim().equals("")))
		{
			previousItems.add(newItem);
		}
		
		String title = "Items Purchased";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
				"<html>" +
					"<head><center><title>" + title + "</title></center></head>" +
					"<body>" +
						"<h1>" + title + "</h1>"
					);
						if(previousItems.size() == 0)
						{
							out.println("<i>No items</i>");
						} 
						else
						{
							out.println("<ul>");
							for(String s : previousItems)
								out.println("<li>" + s );
							out.println("</ul>");
						}
		out.println(
					"</body>" +
				"</html>"
					);
	}
}
