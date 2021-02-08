package com.productcart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.productcart.userdao.User;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {
	
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println("In am in filter");
		boolean isLogged = false;
		HttpSession httpSession = req.getSession();
		
		if(httpSession != null) {
			User user = (User) httpSession.getAttribute("user");
			if(user!=null) {
				isLogged = true;
			}
		}
		
		if(isLogged) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("login.jsp?error=Please login");
		}
		
		
		
		
		
	}
	
	public void destroy() {
		
	}


	

}
