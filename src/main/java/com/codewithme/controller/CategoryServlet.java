package com.codewithme.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithme.model.Category;
import com.codewithme.service.CategoryService;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("all")) {
			getAllCategories(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void getAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		CategoryService service1 = new CategoryService();
		Category c = new Category();
		c.setCategoryID(1);
		c.setCategoryName("Mobilephones");
		List<Category> actual = new ArrayList();
		List<Category> expected = new ArrayList<Category>();
		 actual.add(c);
		 try {
			actual = service1.getCategories();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //expected = Arrays.asList(new Category(1,"Mobilephones"));
		try {
			System.out.println(service1.getCategories());
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //System.out.println(expected.toArray());
		 
		CategoryService service = new CategoryService();
		try {
			List<Category> category = service.getCategories();
			if(category.isEmpty()) {
				message = "There are no categories to show!";
			}
			request.setAttribute("ctList", category);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("Category.jsp");
		rd.forward(request, response);
	}

}
