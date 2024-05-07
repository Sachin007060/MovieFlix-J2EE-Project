package com.jspider.movieflix_java_servlet.controller;

import java.time.LocalDate;

import com.jspider.movieflix_java_servlet.dto.User;
import com.jspider.movieflix_java_servlet.service.UserService;

public class UserRegisterController {
	public static void main(String[] args) {
		UserService service = new UserService();
//		User user = new User("Mohan", "mohan123@gmail.com", "Mohan@123", LocalDate.parse("2000-10-23"), 9876543210l, "Male");
//		User user = new User("Rohan", "mohan123gmail.com", "Rohan@123", LocalDate.parse("2000-10-23"), 8876543210l, "Male");
		User user = new User("Atul", "atul123@gmail.com", "Atul@123", LocalDate.parse("2001-04-08"), 8676543210l, "Male");
		User user2 = service.userRegistrationService(user);
		if(user2!=null) {
			System.out.println("Registration successfull");
		}else {
			System.err.println("Check userEmail and Password( email should have syntax(admin123@gmail.com))");
			System.err.println("and password should have syntax Admin@123");
		}
	}
}
