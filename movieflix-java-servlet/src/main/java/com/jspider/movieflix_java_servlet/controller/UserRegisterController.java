package com.jspider.movieflix_java_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspider.movieflix_java_servlet.service.UserService;

public class UserRegisterController extends HttpServlet{
	
	
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserService service = new UserService();
			
			service.userRegistrationService(null);
		}
}
