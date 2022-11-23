

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ShowItems")
public class ShowItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
		
		if(previousItems == null)
		{
			previousItems = new ArrayList<String>();
			session.setAttribute("previousItems", previousItems);
		}
		
		String newItem = request.getParameter("newItem");
		if((newItem != null) && !newItem.trim().equals(""))
		{
			previousItems.add(newItem);
		}
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
