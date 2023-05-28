package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithme.dao.LoginDao;
import com.codewithme.model.Login;
import com.codewithme.model.OrderLogs;
import com.codewithme.service.OrderService;

/**
 * Servlet implementation class Driver
 */
public class Driver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Driver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		Login user = (Login) request.getSession().getAttribute("driver");
		String name = user.getUsername();
		
		OrderService service = new OrderService();
		try {
			List<OrderLogs> logs = service.getOrderLogs(name);
			if(logs.isEmpty()) {
				message = "There haven't been any orders yet";
			}
			request.setAttribute("logs", logs);
		}
		catch(Exception e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("driver.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
