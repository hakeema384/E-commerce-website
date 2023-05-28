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

import com.codewithme.model.OrderManage;
import com.codewithme.service.OrderService;

/**
 * Servlet implementation class OrderPage
 */
public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		//out.println("Orderpage servlet");
		String message = "";
		OrderManage order = new OrderManage();
		OrderService service = new OrderService();
		order.setName(request.getParameter("name"));
		order.setAddress(request.getParameter("address"));
		order.setD_location(request.getParameter("location"));
		int oID = Integer.parseInt(request.getParameter("orderID"));
		try {
			boolean result = service.addOrder(order, oID);
			if(result) {
				message = "Order has been added";
			}
			else {
				message = "Order failed";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("customerOrders.jsp");
		rd.forward(request, response);
	}

}
