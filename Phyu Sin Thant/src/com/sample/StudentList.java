package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.dao.StudentDAO;
import com.sample.model.Student;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/Student")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = StudentDAO.getStudents();
		
		
//		PrintWriter out = response.getWriter();
//		for(Student studentsList:students){
//			out.println("<html><body>" + studentsList.getId() + "</body></html>");
//		}
		request.setAttribute("studentList",students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
