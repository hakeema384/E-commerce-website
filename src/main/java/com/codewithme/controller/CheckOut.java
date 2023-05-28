package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithme.dao.LoginDao;
import com.codewithme.dao.OrderDao;
import com.codewithme.model.Cart;
import com.codewithme.model.Login;
import com.codewithme.model.Order;
import com.codewithme.service.OrderService;
import com.codewithme.service.RegisterService;

/**
 * Servlet implementation class CheckOut
 */
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		int price = Integer.parseInt(request.getParameter("total"));
		System.out.println(price);
		try {
			ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart_list");
			Login user = (Login) request.getSession().getAttribute("name");
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			RegisterService lg = new RegisterService();
			int idd = lg.getID(user);
			int brID = lg.getBranchID(user);
			ArrayList<Order> checkout = new ArrayList<Order>();
			if(cart_list != null && user !=null) {
				for(Cart c:cart_list) {
					Order order = new Order();
					order.setProductID(c.getProductID());
					order.setUid(idd);
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
                    checkout.add(order);
				}
				OrderService od = new OrderService();
				boolean res = od.insertMultiple(checkout,idd,price,brID);
				HttpSession session = request.getSession();
				session.setAttribute("branchID", brID);
				session.setAttribute("id", idd);
				response.sendRedirect("orders.jsp");
					}
			else
			{
				if(user==null) {
					response.sendRedirect("login.jsp");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
