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




@WebServlet("/stuReg")
public class RegisterStudentInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterStudentInquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_studentRegistration.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(60);
		if(session.getAttribute("email")!=null) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String inquiry_table = request.getParameter("inquiry_table");
		String inquiry_discription = request.getParameter("inquiry_discription");

		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.verifyStudentCredential(name,email,date,inquiry_table,inquiry_discription);
		
request.setAttribute("msg", "record is saved!");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_studentRegistration.jsp");
	rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("studentLogin.jsp");
		rd.forward(request, response);
		}
	}catch(Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("studentLogin.jsp");
		rd.forward(request, response);
	}
	}

}
