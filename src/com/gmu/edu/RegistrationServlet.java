package com.gmu.edu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doPerform(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doPerform(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPerform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		Registration registration=new Registration();
		Map<String, String> errors = new HashMap<String, String>();
		registration.setName(request.getParameter("name"));
		if(registration.getName().startsWith("A"))
		{
			errors.put("name", "name not valid");
			request.setAttribute("errors", errors);
	        request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		registration.setCity(request.getParameter("city"));
		registration.setEmail(request.getParameter("email"));
		registration.setPassword(request.getParameter("password"));
		RegistrationDao registrationDao=new RegistrationDao();
		registrationDao.registerUser(registration);
		
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registered.jsp");
			requestDispatcher.forward(request, response);
		
	}

}
