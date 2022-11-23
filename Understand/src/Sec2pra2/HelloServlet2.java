package Sec2pra2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloServlet2")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloServlet2() 
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>Hello (2)</title></head>\n" +
				"<body bgcolor=\"#FDF5E6\">\n" +
				"<h1>Hello (2)</h1>\n" +
				"</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
