package com.productcart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productcart.productdao.Product;
import com.productcart.service.ProductService;
import com.productcart.service.ProductServiceImpl;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("home")) {
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("show")) {
			List<Product> products=productService.showAllProducts();
			request.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
			rd.forward(request, response);
		}
		
		
		
		else if(action.equalsIgnoreCase("add")) {
			RequestDispatcher rd=request.getRequestDispatcher("addProduct.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		else if(action.equalsIgnoreCase("remove")) {
			List<Product> products=productService.showAllProducts();
			request.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("removeProduct.jsp");
			rd.forward(request, response);
		}
		
		
		
		else if(action.equalsIgnoreCase("removeById")) {
			int id = Integer.parseInt(request.getParameter("id"));
			productService.deleteProduct(id);
			List<Product> products=productService.showAllProducts();
			request.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("removeProduct.jsp?message=Product removed!");
			rd.forward(request, response);
			
			
		} 
		
		
		else if(action.equalsIgnoreCase("update")) {
			List<Product> products=productService.showAllProducts();
			request.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("updateProduct.jsp");
			rd.forward(request, response);
		}
		
		
		
		else if(action.equalsIgnoreCase("updateById")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = productService.getProductById(id);
			request.setAttribute("product", product);
			RequestDispatcher rd=request.getRequestDispatcher("updateform.jsp");
			rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		if(id.equalsIgnoreCase("0")) {
			
			String productName = request.getParameter("product-name");
			int price = Integer.parseInt(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			    Product product = new Product(productName, price, quantity);
				productService.addProduct(product);
				List<Product> products=productService.showAllProducts();
				request.setAttribute("products", products);
				RequestDispatcher rd=request.getRequestDispatcher("showproduct.jsp");
				rd.forward(request, response);	
			
		}
		
		
		else {
			int productId = Integer.parseInt(id);
			String productName = request.getParameter("product-name");
			int price = Integer.parseInt(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));	
			Product product = new Product(productId, productName, price, quantity);
			productService.updateProduct(product);
			List<Product> products=productService.showAllProducts();
			request.setAttribute("products", products);
			RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp?message=Product Updated!");
			rd.forward(request, response);
			
		}
		
	}

}
