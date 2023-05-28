package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
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
import com.codewithme.model.Registration;
import com.codewithme.service.OrderService;
import com.codewithme.service.RegisterService;

/**
 * Servlet implementation class OrderNow
 */
public class OrderNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(request.getSession().getAttribute("name"));
			Login user = (Login) request.getSession().getAttribute("name");
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			RegisterService lg = new RegisterService();
			int idd = lg.getID(user);
			int brID = lg.getBranchID(user);
			
			
			if(user!=null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				int id = Integer.parseInt(request.getParameter("id"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				int price = Integer.parseInt(request.getParameter("price"));
				
				if(quantity <= 0) {
					quantity = 1;
				}
				OrderService orderDao = new OrderService();
				Order order = new Order();
				order.setProductID(id);
				order.setUid(idd);
				order.setQuantity(quantity);
				order.setPrice(price);
				order.setDate(formatter.format(date));
				order.setBranchID(brID);
				boolean res = orderDao.insertOrder(order);
				if(res){
					ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart_list");
					if (cart_list != null) {
						for(Cart c:cart_list) {
							if(c.getProductID()==id) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}
				}
					HttpSession session = request.getSession();
					session.setAttribute("branchID", brID);
					RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
					rd.forward(request,response);
					//response.sendRedirect("orders.jsp");
					}
				else
				{
					System.out.println("Order failed");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
