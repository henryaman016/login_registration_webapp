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

@WebServlet("/userLogin")
public class RegisterLoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterLoginUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_userLogin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		try {
			
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(30);
		if(session.getAttribute("email")!=null) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		request.setAttribute("msg", "record is saved!");
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.verifyUserCredential(email,password);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_userLogin.jsp");
		rd.forward(request, response);
		
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("loginjsp.jsp");
			rd.forward(request, response);
		}
	}catch(Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("loginjsp.jsp");
	rd.forward(request, response);
	
	}
}
}
