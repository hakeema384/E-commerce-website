package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithme.model.Cart;

/**
 * Servlet implementation class RemoveFromCart
 */
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hey there! It worked");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart_list");
		if (cart_list != null) {
			for(Cart c:cart_list) {
				if(c.getProductID()==id) {
					cart_list.remove(cart_list.indexOf(c));
					break;
				}
			}
			response.sendRedirect("cart.jsp");

		} else {
			response.sendRedirect("cart.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
