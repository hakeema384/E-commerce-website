package com.codewithme.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.codewithme.model.Product;
import com.codewithme.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("view"))
		{
			getAllProducts(request,response);
		}
		else if(action.equals("SAView"))
		{
			getProductsSA(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("addProduct")) {
			addProduct(request, response);
			
		}
		else if(action.equals("updateProduct")) {
			updateProduct(request, response);
			
		}
		else if(action.equals("deleteProduct")) {
			
			
		}
	}
	
	private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		ProductService service = new ProductService();
		try {
			List<Product> products = service.viewProducts();
			if(products.isEmpty()) {
				message = "There's no any product to show!";
			}
			request.setAttribute("productList", products);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("Allproducts.jsp");
		rd.forward(request, response);
	}
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String message = "";
		Product product = new Product();
		ProductService service = new ProductService();
		
		product.setProductName(request.getParameter("productName"));
		product.setPrice(Integer.parseInt(request.getParameter("productPrice")));
		Part file = request.getPart("productImg");
		String image = file.getSubmittedFileName();
		product.setProductImg(image);
		
		try {
			boolean result = service.addProduct(product);
			if(result) {
				message = "Details added successfully";
			}
			else {
				message = "There was an error in adding the details";
			}
		} catch (ClassNotFoundException | SQLException e1) {
			message = e1.getMessage();
		}
		
		System.out.println(image);
		String uploadPath = "C:/Users/hakee/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/mobileshop/src/main/webapp/images/"+image;
		System.out.println(uploadPath);
		
		try {
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();
		
		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();}
		catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("Allproducts.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String message ="";
		ProductService service = new ProductService();
		Product product = new Product();
		product.setProductID(Integer.parseInt(request.getParameter("productID")));
		product.setProductName(request.getParameter("productName"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		Part file = request.getPart("productImage");
		String image = file.getSubmittedFileName();
		product.setProductImg(image);
		
		try {
			boolean result = service.updateProduct(product);
			if(result) {
				request.setAttribute("status", "updated");
			}
			else {
				request.setAttribute("status", "failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
		
		String uploadPath = "C:/Users/hakee/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/mobileshop/src/main/webapp/images/"+image;
		System.out.println(uploadPath);
		
		try {
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();
		
		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();}
		catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
		rd.forward(request, response);
		
	}
	
	private void getProductsSA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message="";
		ProductService service = new ProductService();
		try {
			List<Product> product = service.getProductsSA();
			if(product.isEmpty()) {
				message = "There aren't any products to show!";
			}
			request.setAttribute("prdList", product);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp");
		rd.forward(request, response);
	}

}
