package com.codewithme.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithme.dao.LoginDao;
import com.codewithme.model.Login;
import com.codewithme.model.OrderManage;
import com.codewithme.model.SalesAgent;
import com.codewithme.service.OrderService;
import com.codewithme.service.RegisterService;
import com.codewithme.service.SAService;

/**
 * Servlet implementation class OrderStatus
 */
public class OrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		Login user = (Login) request.getSession().getAttribute("SA");
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		LoginDao lg = new LoginDao();
		int brID = 0;
		try {
			brID = lg.getBranchID(user);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		OrderService service = new OrderService();
		try {
			List<OrderManage> orders = service.viewAllOrders(brID);
			if(orders.isEmpty()) {
				message = "There aren't any orders yet!";
			}
			request.setAttribute("orderList", orders);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		HttpSession session = request.getSession();
		session.setAttribute("SAbranchID", brID);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("ordersSA.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		Login user = (Login) request.getSession().getAttribute("SA");
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		RegisterService lg = new RegisterService();
		int idd=0;
		int brID = 0;
		try {
		 idd = lg.getID(user);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 brID = lg.getBranchID(user);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		OrderManage order = new OrderManage();
		OrderService service = new OrderService();
		order.setOrderID(Integer.parseInt(request.getParameter("orderID")));
		order.setStatus(request.getParameter("status"));
		order.setDriver(request.getParameter("driverName"));
		order.setVehicle(request.getParameter("vehicle"));
		try {
			boolean result = service.updateOrder(order,brID,idd);
			if(result) {
				message = "Details updated successfully";
			}
			else {
				message = "Failed to update details";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);  
		 RequestDispatcher rd = request.getRequestDispatcher("UpdateStatus.jsp");
		 rd.forward(request, response);
	}

}
