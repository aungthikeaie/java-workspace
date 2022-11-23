import javax.servlet.http.HttpServletRequest;


public class ServletUtilities 
{
	public static int getIntParameter(HttpServletRequest request, String paramName, int defaultValue)
	{
		String paramString = request.getParameter(paramName);
		int paramValue;
		try
		{
			paramValue = Integer.parseInt(paramString);
		}
		catch(NumberFormatException nfe)
		{
			paramValue = defaultValue;
		}
		return(paramValue);
	}
	public static String headWithTitle(String title)
	{
		return null;
	}
}
