package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithme.model.Cart;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setProductID(id);
			cm.setQuantity(1);
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
			
			if(cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart_list", cartList);
				request.setAttribute("status", "success");
			}
			else {
				cartList = cart_list;
				boolean exist = false;
				
				for(Cart c:cart_list) {
					if(c.getProductID() == id) {
						exist = true;
						request.setAttribute("status", "exists");
					}
				}
				if(!exist) {
					cartList.add(cm);
					request.setAttribute("status", "added");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("CustomerView");
			rd.forward(request, response);
		
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
