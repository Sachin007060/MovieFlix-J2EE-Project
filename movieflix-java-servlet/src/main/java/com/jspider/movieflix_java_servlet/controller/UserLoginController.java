package com.jspider.movieflix_java_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.movieflix_java_servlet.dao.UserDao;
import com.jspider.movieflix_java_servlet.dto.User;

@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao dao = new UserDao();
		
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		
		User user= dao.fetchUserByEmailDao(email);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				req.getRequestDispatcher("user-home.jsp").forward(req, resp);
			}else {
				req.setAttribute("userMsg", "Password is invalid");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("userMsg", "Email is invalid");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}
