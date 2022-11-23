package FirstPackage;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SubmitResume")
public class SubmitResume extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public SubmitResume() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(request.getParameter("previewButton") != null)
		{
			showPreview(request, out);
		}
		else
		{
			storeResume(request);
			showConfirmation(request, out);
		}
	}
	private void showPreview(HttpServletRequest request, PrintWriter out)
	{
		String headingFont = request.getParameter("headingFont");
		headingFont = replaceIfMissingOrDefault(headingFont,"");
		int headingSize = getSize(request.getParameter("headingSize"), 32);
		String bodyFont = request.getParameter("bodyFont");
		bodyFont = replaceIfMissingOrDefault(bodyFont,"");
		int bodySize = getSize(request.getParameter("bodySize"),18);
		String fgColor = request.getParameter("fgColor");
		fgColor = replaceIfMissing(fgColor, "BLACK");
		String bgColor = request.getParameter("bgColor");
		bgColor = replaceIfMissing(bgColor, "WHITE");
		String name = request.getParameter("name");
		name = replaceIfMissing(name, "Lou Zer");
		String title = request.getParameter("title");
		title = replaceIfMissing(title, "Lozer");
		String email = request.getParameter("email");
		email = replaceIfMissing(email, "contact@hot-computer-jobs.com");
		String languages = request.getParameter("languages");
		languages = replaceIfMissing(languages, "<I>None</I>");
		String languageList = makeList(languages);
		String skills = request.getParameter("skills");
		skills = replaceIfMissing(skills, "Not many, obviously.");
		out.println
		(ServletUtilities.DOCTYPE+"\n"+
		"<html><head><title>Resume for "+name+"</title>\n"+
			makeStyleSheet(headingFont, headingSize, bodyFont, bodySize,
			fgColor, bgColor)+"\n"+
			"</head>\n"+
			"<body>\n"+
			"<center>\n"+
			"<span class = \"HEADING1\">"+name+"</span></br>\n"+
			"<span class = \"HEADING2\">"+title+"<br>\n"+
			"<a herf=\"mailto:" + email + "\">" + email +
			"</a></span>\n" +
			"</center><br><br>\n" +
			"<span class = \"HEADING3\">Programming Languages" +
			"</span>\n" +
			makeList(languages) + "<br><br>\n" +
			"<span class=\"HEADING3\">Skills and Experience" +
			"</span><br><br>\n" +
			skills + "\n" +
			"</body></html>");
	}
	
	private String makeStyleSheet(String headingFont,int headingSize,
			String bodyFont, int bodySize, String fgColor, String bgColor)
			{
				int heading1Size = headingSize*8/10;
				int heading2Size = headingSize*7/10;
				int heading3Size = headingSize*6/10;
				String styleSheet =
				"<style type=\"text/css\">\n" + "<!--\n" +
				".HEADING1 {font-size: " + heading1Size + "px;\n" +
				"font-weight : bold;\n" +
				"font-family : " + headingFont +
				"Arial, Helvetica, sans-serif;\n" + "}\n" +
				".HEADING2 {font-size :" + heading2Size + "px;\n" +
				"font-weight : bold;\n" +
				"font-family : " + headingFont +
				"Arial, Helvetica, sans-serif;\n" + "}\n" +
				".HEADING3 {font-size :" + heading3Size + "px;\n" +
				"font-weight : bold;\n" +
				"font-family : " + headingFont +
				"Arial, Helvetica, sans-serif;\n" + "}\n" +
				"body {color: }"+fgColor + ";\n" +
				"background-color : " + bgColor + ";\n" +
				"font-size : " + bodySize + "px;\n" +
				"font-family : " + bodyFont +
				"Times New Roman, Times , serif;\n" + "}\n" +
				"A:hover{color: red}\n" + "-->\n" +
				"</style>";
		return(styleSheet);
			}
	
	private String replaceIfMissing(String orig, String replacement)
	{
		if((orig == null) || (orig.trim().equals("")))
		{
			return(replacement);
		}
		else
		{
			return(orig);
		}
	}
	
	private String replaceIfMissingOrDefault(String orig, String replacement)
	{
		if((orig == null) || (orig.trim().equals("")) || (orig.equals("default")))
		{
			return(replacement);
		}
		else
		{
			return(orig + ", ");
		}
	}
	
	private int getSize(String sizeString, int defaultSize)
	{
		try
		{
			return(Integer.parseInt(sizeString));
		}
		catch(NumberFormatException nfe)
		{
			return(defaultSize);
		}
	}
	
	private String makeList(String listItems)
	{
		StringTokenizer tokenizer = new StringTokenizer(listItems, ",");
		String list = "<UL>\n";
		while(tokenizer.hasMoreTokens())
		{
			list = list + "<LI>" +tokenizer.nextToken() + "\n";
		}
		list = list + "</UL>";
		return(list);
	}
	
	private void showConfirmation(HttpServletRequest request,
			PrintWriter out)
		{
			String title = "Submission Comfirmed.";
			out.println(ServletUtilities1.headWithTitle(title) + 
				"<body>\n" + 
				"<h1>" + title + "</h1>\n" + 
				"Your resume should appear online within\n" + 
				"24 hours. If it doesn't, try submitting\n" +
				"again with a different email address.\n" +
				"</body></html>");
		}
	
	private void storeResume(HttpServletRequest request)
	{
		String email = request.getParameter("email");
		putInSpamList(email);
	}
	
	private void putInSpamList(String emailAddress)
	{
		
	}
	

}
