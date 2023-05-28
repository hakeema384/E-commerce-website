package com.codewithme.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithme.model.Brand;
import com.codewithme.service.BrandService;

/**
 * Servlet implementation class BrandServlet
 */
public class BrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("all")) {
			getAllBrands(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void getAllBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		BrandService service = new BrandService();
		
		try {
			List<Brand> brand = service.getAllBrands();
			if(brand.isEmpty()) {
				message="There aren't any brands to show";
			}
			request.setAttribute("brandList", brand);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("Brand.jsp");
		rd.forward(request, response);
		
	}

}
