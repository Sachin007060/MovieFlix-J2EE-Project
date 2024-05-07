package com.jspider.movieflix_java_servlet.service;

import com.jspider.movieflix_java_servlet.dao.UserDao;
import com.jspider.movieflix_java_servlet.dto.User;
import com.jspider.movieflix_java_servlet.verification.EmailPasswordVerification;

public class UserService {
	UserDao dao = new UserDao();
	
	public User userRegistrationService(User user) {
		String email = EmailPasswordVerification.emailVerfication(user.getEmail());
		String password = EmailPasswordVerification.passwordVerfication(user.getPassword());
		
		if((email!=null) && password!=null) {
			return dao.userRegistrationDao(user);
		}else {
			return null;
		}
	}
}
