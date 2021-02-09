package com.productcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productcart.dao.UserNotFoundException;
import com.productcart.userdao.User;
import com.productcart.service.*;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User tempUser = new User(username,password);
		
		try {
			userService.addUser(tempUser);
//			HttpSession httpSession = request.getSession();
//			httpSession.setAttribute("user", tempUser);
			response.sendRedirect("login.jsp");
		}catch(UserNotFoundException e) {
			response.sendRedirect("login.jsp?error=register failed!");
		}
	}

}
