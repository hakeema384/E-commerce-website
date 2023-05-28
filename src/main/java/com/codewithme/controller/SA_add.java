package com.codewithme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithme.model.Login;
import com.codewithme.model.Product;
import com.codewithme.model.SalesAgent;
import com.codewithme.service.ProductService;
import com.codewithme.service.RegisterService;
import com.codewithme.service.SAService;

/**
 * Servlet implementation class SA_add
 */
public class SA_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("all")) {
			getAllSA(request,response);
		}
		else if(action.equals("request")) {
			insertRequest(request,response);
		}
		else if(action.equals("viewRequests")) {
			viewRequests(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			addSA(request, response);
			
		}
		else if(action.equals("edit")) {
			editSA(request,response);
		}
		
		else if(action.equals("delete")) {
			
			deleteSA(request,response);
		}
	}
	
	
	private void getAllSA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		SAService service = new SAService();
		try {
			List<SalesAgent> agent = service.getAllSA();
			if(agent.isEmpty()) {
				message = "There are no sales agents at the moment";
			}
			request.setAttribute("agentList", agent);
			
		    } 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}
	
	
	private void addSA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		SAService service = new SAService();
		SalesAgent agent = new SalesAgent();
		agent.setSA_id(Integer.parseInt(request.getParameter("agentID")));
		agent.setBranch_id(Integer.parseInt(request.getParameter("branchID")));
		agent.setSA_name(request.getParameter("agentName"));
		agent.setUsername(request.getParameter("agentUname"));
		agent.setPassword(request.getParameter("agentPassword"));
		agent.setSA_email(request.getParameter("agentEmail"));
		try {
			boolean result = service.addSA(agent);
			if(result) {
				request.setAttribute("status", "success");
			}
			else
			{
				request.setAttribute("status", "failed");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("AddSA.jsp");
		rd.forward(request, response);	
	}
	
	private void deleteSA(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String message = "";
    	int agentID = Integer.parseInt(request.getParameter("agentID"));
    	SAService service = new SAService();
    	try {
			service.deleteSA(agentID);
			request.setAttribute("status", "success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("status", "error");
		}
    	response.sendRedirect("/mobileshop/SA_view?action=all");
    	
     }
	
	private void editSA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		SalesAgent agent = new SalesAgent();
		SAService service = new SAService();
		agent.setSA_id(Integer.parseInt(request.getParameter("agentID")));
		agent.setBranch_id(Integer.parseInt(request.getParameter("branchID")));
		agent.setSA_name(request.getParameter("name"));
		agent.setUsername(request.getParameter("username"));
		agent.setPassword(request.getParameter("password"));
		agent.setSA_email(request.getParameter("email"));
		 
		try {
			boolean result = service.updateSA(agent);
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
		response.sendRedirect("/mobileshop/SA_view?action=all");
	}
	
	private void insertRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Product product = new Product();
		ProductService service = new ProductService();
		product.setProductID(Integer.parseInt(request.getParameter("productID")));
		product.setProductName(request.getParameter("productName"));
		product.setBrandID(Integer.parseInt(request.getParameter("brandID")));
		product.setCategoryID(Integer.parseInt(request.getParameter("categoryID")));
		product.setSa_ID(Integer.parseInt(request.getParameter("saID")));
		product.setBranch_ID(Integer.parseInt(request.getParameter("brID")));
		product.setDate(formatter.format(date));
		try {
			boolean result = service.sendRequest(product);
			if(result) {
				request.setAttribute("status", "success");
			}
			else
			{
				request.setAttribute("status", "failed");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
		RequestDispatcher rd = request.getRequestDispatcher("Requests.jsp");
		rd.forward(request, response);
	}
	
	private void viewRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		int id=0;
		Login user = (Login) request.getSession().getAttribute("SA");
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		RegisterService lg = new RegisterService();
		try {
			id = lg.getID(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductService service = new ProductService();
		try {
			List<Product> product = service.viewRequests(id);
			if(product.isEmpty()) {
				message = "You haven't made any requests yet!";
			}
			request.setAttribute("requests", product);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("ViewRequests.jsp");
		rd.forward(request, response);
	}

}
