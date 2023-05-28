package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithme.model.Order;
import com.codewithme.model.OrderManage;
import com.codewithme.service.OrderService;


/**
 * Servlet implementation class OrdersAdmin
 */
public class OrdersAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("orders")) {
			viewOrders(request,response);
		}
		else if(action.equals("all")) {
			OrderDeets(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void viewOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		OrderService service = new OrderService();
		try {
			List<OrderManage> order = service.viewOrdersAdmin();
			if(order.isEmpty()) {
				message = "There haven't been any orders yet!";
			}
			request.setAttribute("ordersAdmin", order);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewOrdersAdmin.jsp");
		rd.forward(request, response);
	}
	
	private void OrderDeets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		int id = Integer.parseInt(request.getParameter("orderID"));
		OrderService service = new OrderService();
		try {
			List<Order> order = service.orderDeets(id);
			if(order.isEmpty()) {
				message = "There are no orders to show!";
			}
			request.setAttribute("cartOrders", order);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("OrderDeets.jsp");
		rd.forward(request, response);
	}

}
