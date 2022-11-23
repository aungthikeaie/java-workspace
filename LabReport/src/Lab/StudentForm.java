package Lab;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentForm extends HttpServlet
{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(req.getParameter("preview") != null)
		{
			showPreview(req, out);
		}
		else
		{
			showComfirmation(req, out);
		}
	}
	
	public void showPreview(HttpServletRequest request, PrintWriter out)
	{
		String studentName = request.getParameter("studentName");
		studentName = replacing(studentName);
		
		String studentRollNo = request.getParameter("studentRollNo");
		studentRollNo = replacing(studentRollNo);
		
		String major = request.getParameter("major");
		
		String year = request.getParameter("year");
		year = replacing(year);
		
		String fatherName = request.getParameter("fatherName");
		fatherName = replacing(fatherName);
		
		String nrcNo = request.getParameter("nrcNo");
		nrcNo = replacing(nrcNo);
		
		String address = request.getParameter("address");
		address = replacing(address);
		
		String gender = request.getParameter("gender");
		gender = radioReplace(gender);
		
		String birthday = request.getParameter("birthday");
		birthday = replacing(birthday);
		
		String skill = request.getParameter("skill");
		skill = radioReplace(skill);
		
		String textAreas = request.getParameter("textAreas");
		textAreas = replacing(textAreas);
		
		out.println("<html>" +
				"	<head>" +
				"		<title>Student's Information</title>" +
				"	</head>" +
				"	<body>" +
				"		<h1>Student's Information</h1>" +
				"		<table border=\"2px\">" +
				"			<tr>" +
				"				<td>Student Name</td>"+
				"				<td>"+studentName+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Roll No</td>" +
				"				<td>"+studentRollNo+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Major</td>" +
				"				<td>"+major+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Year</td>" +
				"				<td>"+year+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Father Name</td>" +
				"				<td>"+fatherName+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>NRC No</td>" +
				"				<td>"+nrcNo+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Address</td>" +
				"				<td>"+address+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Gender</td>" +
				"				<td>"+gender+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Birthday</td>" +
				"				<td>"+birthday+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>English Proficiency Skill</td>" +
				"				<td>"+skill+"</td>" +
				"			</tr>" +
				"			<tr>" +
				"				<td>Other</td>" +
				"				<td>"+textAreas+"</td>" +
				"			</tr>" +
				"		</table>" +
				"	</body>" +
				"</html>");
	}
	public void showComfirmation(HttpServletRequest request, PrintWriter out)
	{
		out.println(
				"<html>" +
				"<head>" +
				"	<title>Comfirmation</title>" +
				"</head>" +
				"<body>" +
				"	<h1>Registration Confirmed.</h1>" +
				"	<p>You are successfully register as Student.</p>" +
				"</body>" +
				"</html>");
	}
	public String replacing(String replace)
	{
		if(replace.trim().equals("") || replace == null)
				return "Please enter your Data!!";
		else
				return replace;
		
	}
	public String radioReplace(String replace)
	{
		if(replace == null)
			return "Please enter your Data!!";
		else 
			return replace;
	}
}
