package com.group4.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
	String un = request.getParameter("username");
	String psw = request.getParameter("password");
	
	Cookie c = new Cookie("auth",un);
	c.setMaxAge(60*60*24);
	if(un.equals("mtustu") && psw.equals("student")){
		response.addCookie(c);
		response.sendRedirect("student-home.jsp");
	}
	else if(un.equals("thandaraung@gmail.com") && psw.equals("thandaraung")){
		response.addCookie(c);
		response.sendRedirect("SE-techal-home.jsp");
	}
	else{
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		out.println("<font color=red><h1>Either username or password is wrong.</h1></font>");
		dispatcher.include(request, response);
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
