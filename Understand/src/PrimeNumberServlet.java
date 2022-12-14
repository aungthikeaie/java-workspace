

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeNumberServlet")
public class PrimeNumberServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
  
    public PrimeNumberServlet() 
    {
        super();
    }

    private ArrayList primeListCollection = new ArrayList();
    private int maxPrimeLists = 30;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int numPrimes = ServletUtilities.getIntParameter(request,"numPrimes",50);
		int numDigits = ServletUtilities.getIntParameter(request,"numDigits",120);
		PrimeList primeList = findPrimeList(primeListCollection, numPrimes, numDigits);
		if(primeList == null)
		{
			primeList = new PrimeList(numPrimes, numDigits, true);
			synchronized (primeListCollection) 
			{
				if(primeListCollection.size() >= maxPrimeLists)
					primeListCollection.remove(0);
					primeListCollection.add(primeList);
			}
		}
			ArrayList currentPrimes = primeList.getPrimes();
			int numCurrentPrimes = currentPrimes.size();
			int numPrimesRemaning = (numPrimes - numCurrentPrimes);
			boolean isLastResult = (numPrimesRemaning == 0);
			if(!isLastResult)
			{
				response.setIntHeader("Refresh", 5);
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Some " + numDigits + "-Digit Prime Numbers";
			out.println(ServletUtilities.headWithTitle(title) +
					"<body bgcolor=\"FDF5E6\">\n"
					+ "<h2 align=center>" + title + "</h2>\n"
					+ "<h3>Primes found with " + numDigits 
					+ " or more digits: " + numCurrentPrimes
					+ ".</h3>");
			
			if(isLastResult)
				out.println("<b>Done searching.</b>");
			else
				out.println("<b>Still looking for " + numPrimesRemaning + " more<blink>...</blink></b>");
				out.println("<ol>");
			
			for(int i = 0; i <numCurrentPrimes; i++)
			{
				out.println("<li>" + currentPrimes.get(i));
			}
			
			out.println("</ol>");
			out.println("</body></html>");
		
	}

	private PrimeList findPrimeList(ArrayList primeListCollection,int numPrimes, int numDigits) 
	{
		for(int i = 0; i < primeListCollection.size(); i++)
		{
			PrimeList primes = (PrimeList) primeListCollection.get(i);
			synchronized (primeListCollection) 
			{
				if((numPrimes == primes.numPrimes()) && (numDigits == primes.numDigits()))
				{
					return(primes);
				}
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
