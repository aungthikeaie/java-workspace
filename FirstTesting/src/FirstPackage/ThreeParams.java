package FirstPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThreeParams")
public class ThreeParams extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ThreeParams() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading Three Request Parameters";
		String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0"+
				"Transitional//EN\">\n";
		out.println(docType +
				"<HTML>\n" +
				"<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"+
				"<BODY BGCOLOR=\"#FDF5E6\">\n "+
				"<H1 ALIGN=\"CENTER\">"+title+"</H1>\n"+
				"<UL>\n"+
				"<LI><B>param1</B>:"
				+ request.getParameter("param1")+"\n"+
				"<LI><B>"
				);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
