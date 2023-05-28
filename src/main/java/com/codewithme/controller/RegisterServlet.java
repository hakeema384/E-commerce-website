package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithme.model.Registration;
import com.codewithme.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String pwd = request.getParameter("pass");
		String email = request.getParameter("email");
		String bName = request.getParameter("branchName");
		
		int branchID =0;
		switch(bName) {
		case "Colombo":
			branchID=1;
			break;
		case "Jaffna":
			branchID=2;
			break;
		case "Galle":
			branchID=3;
			break;
		case "Kandy":
			branchID=4;
			break;
		case "Gampaha":
			branchID=5;
			break;
		case "Nugegoda":
			branchID=6;
			break;
		}
		
		RegisterService service = new RegisterService();
		Registration register = new Registration();
		register.setUsername(uname);
		register.setPassword(pwd);
		register.setEmail(email);
		register.setBranchID(branchID);
		
		try {
			boolean result = service.addUser(register);
			if(result) {
				request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("status", "failed");
			}

		} catch (ClassNotFoundException | SQLException e) {
			
			request.setAttribute("status", "error");
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
		rd.forward(request, response);
		
	}

}
