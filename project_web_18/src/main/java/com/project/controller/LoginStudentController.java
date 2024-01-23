package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.model.DAOService;
import com.project.model.DAOServiceImpl;


@WebServlet("/studentLogin")
public class LoginStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		boolean status=service.verifyLoginStudentCredential(email, password);

		if(status) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_studentRegistration.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("erorr", "Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("studentLogin.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
