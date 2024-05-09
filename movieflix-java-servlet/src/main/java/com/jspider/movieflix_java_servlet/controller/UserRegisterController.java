package com.jspider.movieflix_java_servlet.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jspider.movieflix_java_servlet.dto.User;
import com.jspider.movieflix_java_servlet.service.UserService;
import com.jspider.movieflix_java_servlet.verification.EmailPasswordVerification;

@WebServlet("/userRegistration")
public class UserRegisterController extends HttpServlet{
	
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserService service = new UserService();
			
			String name = req.getParameter("name");
			String email = EmailPasswordVerification.emailVerfication(req.getParameter("email"));
			String password = EmailPasswordVerification.passwordVerfication(req.getParameter("password"));
			String gender = req.getParameter("gender");
			LocalDate date = LocalDate.parse(req.getParameter("dob"));
			Part image = req.getPart("image");
			long phone = Long.parseLong(req.getParameter("phone"));
			
			if((email!=null) && (password!=null)) {
				User user = new User(name, email, password, date, phone, gender);
				service.userRegistrationService(user);
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}else {
				req.setAttribute("userMsg", "Email must contains @. and number (xyz123@gmail.com)");
				req.setAttribute("userPass", "Password must contains any one special char, number, alphabet should have one uppercase and lowecase");
				req.getRequestDispatcher("user-registration.jsp").forward(req, resp);
			}
			service.userRegistrationService(null);
		}
}
