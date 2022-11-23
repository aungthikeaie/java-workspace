package FirstPackage;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Assignment1")
public class Assignment1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private String dt;   
   
    public Assignment1() 
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		//dt = d+"";
		String t = "Time Table";
		
		out.println(
				"<html>\n"+
				"	<head>\n"+
				"		<title>"+t+"</title>\n"+
				"	</head>\n"+
				"	<body bgcolor=\"#FDF5E6\">\n"+
				"		<h1>Display of CEIT 4th year TimeTable</h1><hr>\n"+
				"		<b>Current Date and Time "+d+"</b><br><br><hr>\n"+
				"		<ul>\n"+
				"			<li>Programming V class is in Monday</li>\n"+
				"			<li>Software Engineering class is in Tuesday</li>\n"+
				"			<li>Activity class is in Wednesday</li>\n"+
				"			<li>Networking class is in Thusday</li>\n"+
				"			<li>Image Processing class is in Friday</li>\n"+
				"		</ul>\n"+
				"	</body>\n"+
				"</html>\n"
				);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
