package com.jspider.movieflix_java_servlet.controller;

import com.jspider.movieflix_java_servlet.dao.AdminDao;
import com.jspider.movieflix_java_servlet.dto.Admin;

public class AdminLoginConrtoller {
	public static void main(String[] args) {
		AdminDao dao = new AdminDao();
		
		String email = "sachin@123gmail.com";
		String password = "sachin@123";
		
		Admin admin =dao.fetchAdminByEmailForLogin(email);
		
		if(admin!=null) {
			if(admin.getAdminPassword().equals(password)) {
				System.out.println("Successful Login");
			}else {
				System.out.println("Password is Incorrect");
			}
		}else {
			System.out.println("Email is Incorrect");
		}
	}
}
