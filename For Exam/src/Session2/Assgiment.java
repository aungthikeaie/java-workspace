package Session2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assgiment
 */
@WebServlet("/Assgiment")
public class Assgiment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assgiment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		String title = "Display of CEIT 4th Year Timetable";
		
		out.println("<html>"
				+ "<head><title>"+title+"</title></head>"
						+ "<body><h2>"+title+"</h2><br><hr><br>"
								+ "<b>Current Date and Time : "+d
								+ "</b><br><br><hr><br>"
								+ "<ul>"
								+ "<li>Programming Language V class is in Monday"
								+ "<li>Software Engineering calss is in Tuesday"
								+ "<li>Actiity class is in Wednesday"
								+ "<li>Network class is in Thursday"
								+ "<li>Image Processing class is in Friday"
								+ "</ul></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
