package com.jspider.movieflix_java_servlet.controller;

import com.jspider.movieflix_java_servlet.dao.UserDao;
import com.jspider.movieflix_java_servlet.dto.User;

public class UserLoginController {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
		String email = "mohan123@gmail.com";
		String password = "Mohan@123";
		User user=dao.fetchUserByEmailDao(email);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				System.out.println("Login is successful");
			}else {
				System.err.println("Password Mismatch");
			}
		}else {
			System.err.println("Email is incorrect");
		}
	}
}
