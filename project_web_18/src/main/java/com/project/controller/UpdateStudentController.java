package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.DAOService;
import com.project.model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

		String email = request.getParameter("email");
		String name = request.getParameter("name");
		request.setAttribute("email",email);
		request.setAttribute("name", name);
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_studentRegistration.jsp");
		rd.forward(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.updateStudentRegistration(email,name);
		
		ResultSet result=service.readStudentRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/searchUserDetails.jsp");
			rd.forward(request, response);
		
	}

}
