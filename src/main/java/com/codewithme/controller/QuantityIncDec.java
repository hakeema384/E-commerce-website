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
 * Servlet implementation class QuantityIncDec
 */
public class QuantityIncDec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuantityIncDec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("inc dec servlet");
		
	try {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart_list");
		if(action.equals("inc")) {
			for(Cart c:cart_list) {
				if(c.getProductID() == id) {
					int quantity = c.getQuantity();
					quantity++;
					c.setQuantity(quantity);
					response.sendRedirect("cart.jsp");
				}
			}
		}
		
		else if(action.equals("dec")) {
			for(Cart c:cart_list) {
				if(c.getProductID() == id && c.getQuantity()>1) {
					int quantity = c.getQuantity();
					quantity--;
					c.setQuantity(quantity);
					break;
				}
			} response.sendRedirect("cart.jsp");
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}

}
