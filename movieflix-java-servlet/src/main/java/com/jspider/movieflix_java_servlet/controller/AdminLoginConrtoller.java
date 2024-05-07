package com.jspider.movieflix_java_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.movieflix_java_servlet.dao.AdminDao;
import com.jspider.movieflix_java_servlet.dto.Admin;

@WebServlet("/adminLogin")
public class AdminLoginConrtoller extends HttpServlet {	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminDao adminDao = new AdminDao();
		
		String email = req.getParameter("adminEmail");
		String password = req.getParameter("adminPassword");
		
		Admin admin = adminDao.fetchAdminByEmailForLogin(email);
				
		if(admin!=null) {
			if(admin.getAdminPassword().equals(password)) {
				req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
			}else {
				req.setAttribute("adminMsg", "Password is invalid");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("adminMsg", "Email is invalid");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
	}
}
