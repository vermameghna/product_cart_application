package com.productcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.productcart.dao.UserNotFoundException;
import com.productcart.service.UserService;
import com.productcart.service.UserServiceImpl;
import com.productcart.userdao.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User user = userService.getUser(username, password);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			response.sendRedirect("ProductController.do?action=home");
		}catch(UserNotFoundException e) {
			response.sendRedirect("login.jsp?error=login failed!");
		}
	}

}
