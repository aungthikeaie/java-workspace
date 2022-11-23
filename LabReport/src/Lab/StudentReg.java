package Lab;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentReg
 */
@WebServlet("/StudentReg")
public class StudentReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(request.getParameter("preview")!=null){
			showPreview(request,out);
		}
		else{
			makeRegister(request,out);
		}
	}

	private void makeRegister(HttpServletRequest request, PrintWriter out) {
		out.println("<HTML>" +
						"<HEAD></HEAD>" +
						"<BODY>" +
						" <H1> Registration Confirmed</H1><BR>" +
						"You are successfully reigster as Student" +
				"</BODY></HTML>");
		
	}

	private String checkContent(HttpServletRequest request, PrintWriter out) {
		String name=request.getParameter("studentName");
		
		String rollno=request.getParameter("rollno");
		
		String  major=request.getParameter("major");
		
		String year=request.getParameter("year");
		
		String fathername=request.getParameter("fathername");
		
		String nrc=request.getParameter("nrc");
		
		String address=request.getParameter("address");
		
		String  gender=request.getParameter("gender");
		
		String birth=request.getParameter("birthday");
	
		String skill=request.getParameter("skill");
	
			
		return null;
	}

	private void showPreview(HttpServletRequest request, PrintWriter out) {
		String name=request.getParameter("studentName");
		name=ReplaceIfMissingOrDefault(name);
		
		String rollno=request.getParameter("rollno");
		rollno=ReplaceIfMissingOrDefault(rollno);
		
		String  major=request.getParameter("major");
		major=ReplaceIfMissingOrDefault(major);
		
		String year=request.getParameter("year");
		year=ReplaceIfMissingOrDefault(year);
		
		String fathername=request.getParameter("fathername");
		fathername=ReplaceIfMissingOrDefault(fathername);
		
		String nrc=request.getParameter("nrc");
		nrc=ReplaceIfMissingOrDefault(nrc);
		
		String address=request.getParameter("address");
		address=ReplaceIfMissingOrDefault(address);
		
		String  gender=request.getParameter("gender");
		
		String birth=request.getParameter("birthday");
		birth=ReplaceIfMissingOrDefault(birth);
		
		String skill=request.getParameter("skill");
		
		String  others=request.getParameter("other");
		others=ReplaceIfMissingOrDefault(others);
		
		out.println("<HTML>" +
				"	<HEAD>" +
				"<style>" +
				"table{bordern : 3px solid black}" +
				"</style>" +
				"</HEAD>" +
					" <BODY>" +
					"<CENTER><H1>Student Information</H1><BR>" +
					" <TABLE>" +
						" <tr>" +
							"	<td> Student Name</td>"+"	<td>"+ name+"</td>"+
							
						"</tr>" +
						" <tr>" +
						"	<td> Roll No</td>"+"	<td>"+ rollno+"</td>"+
						
						"</tr>" +
						" <tr>" +
						"	<td> Major</td>"+"	<td>"+ major+"</td>"+
					
						"</tr>" +
						" <tr>" +
						"	<td> Year </td>"+"	<td>"+ year+"</td>"+
				
						"</tr>" +" <tr>" +
						"	<td> Father Name</td>"+"	<td>"+ fathername+"</td>"+
			
						"</tr>" +" <tr>" +
						"	<td> NRC No</td>"+"	<td>"+ nrc+"</td>"+
		
						"</tr>" +" <tr>" +
						"	<td> Address </td>"+"	<td>"+address+"</td>"+
	
						"</tr>" +
						"</tr>" +" <tr>" +
						"	<td> Gender </td>"+"	<td>"+gender+"</td>"+
	
						"</tr>" +
						"</tr>" +" <tr>" +
						"	<td> Birthday </td>"+"	<td>"+birth+"</td>"+
	
						"</tr>" +
						"</tr>" +" <tr>" +
						"	<td> English Proficiency Skill </td>"+"	<td>"+skill+"</td>"+
	
						"</tr>" +
						"</tr>" +" <tr>" +
						"	<td> others </td>"+"	<td>"+others+"</td>"+
	
						"</tr>" +
						"</TABLE></CENTER></BODY>" +
				"</HTML>");
		
	}

	private String ReplaceIfMissingOrDefault(String name) {
		if(name==null || name.equals("")){
			return "Please Enter Data";
		}
		else{
			return name;
		}
	}

}
