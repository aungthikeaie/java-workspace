package com.code2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/valkyrie")
public class ValyrieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ValyrieServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String vname = request.getParameter("name");
		String vemail = request.getParameter("email");
		
		
		List<Hero> heroList = new ArrayList<>();
		heroList.add(new Hero(vname,vemail));
		request.setAttribute("heroList", heroList);
		//request.setAttribute("Vname", vname);
//		
//		PrintWriter out = response.getWriter();
//		out.println(name+","+email);
//		
		// to send the data to another page
		RequestDispatcher dispatcher = request.getRequestDispatcher("valkyrie-response.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
