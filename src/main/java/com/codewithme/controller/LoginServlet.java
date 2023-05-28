package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithme.dao.LoginDao;
import com.codewithme.dao.RegistrationDao;
import com.codewithme.model.Login;
import com.codewithme.model.Registration;
import com.codewithme.service.RegisterService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setUsername(userName);
		login.setPassword(password);
		
	  RegisterService dao = new RegisterService();
		
		try {
			String authenticate = dao.validateUser(login);
			if(authenticate.equals("customer_Role")) {
				System.out.println("Customer's View");
				 
	            HttpSession session = request.getSession(); //Creating a session
	            session.setAttribute("name", login); //setting session attribute
	            request.setAttribute("validate", userName);
	            RequestDispatcher rd = request.getRequestDispatcher("CustomerView");
	    		rd.forward(request, response);
	         	}
			  else if(authenticate.equals("admin_Role"))
		        {
		            System.out.println("Admin's home");
		            HttpSession session = request.getSession();
		            session.setAttribute("admin", login);
		            request.setAttribute("validate", userName);
		            request.getRequestDispatcher("test.jsp").forward(request, response);
		        }
		        else if(authenticate.equals("SA_Role"))
		        {
		            System.out.println("SA");
		            HttpSession session = request.getSession();
		            session.setAttribute("SA", login);
		            request.setAttribute("validate", userName);
		            RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
		    		rd.forward(request, response);
		        }
		        else if(authenticate.equals("driver_Role"))
		        {
		        	HttpSession session = request.getSession();
		        	session.setAttribute("driver", login);
		        	request.setAttribute("validate", userName);
		        	RequestDispatcher rd = request.getRequestDispatcher("Driver");
		        	rd.forward(request, response);
		        }
		        else
		        {
		        	request.setAttribute("status", "failed");
		            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		    		rd.forward(request, response);
		        }
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
		
	}

}
