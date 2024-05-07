package com.jspider.movieflix_java_servlet.verification;

import java.util.regex.Pattern;

/**
 * @Author Sachin
 */

public class EmailPasswordVerification {

	
	public static String emailVerfication(String emailVerfication) {
		/*
		 * Pattern class is inside java.util.regex 
		 */
		boolean character = Pattern.compile("[a-z]").matcher(emailVerfication).find();
		boolean number = Pattern.compile("[0-9]").matcher(emailVerfication).find();
		boolean atTheRate = Pattern.compile("[@]").matcher(emailVerfication).find();
		boolean special = Pattern.compile("[.]").matcher(emailVerfication).find();
		
		return (character&&number&&special&&atTheRate) ? emailVerfication : null;
	}
	
	
	public static String passwordVerfication(String passwordVerfication) {
		/*
		 * Pattern class is inside java.util.regex 
		 */
		boolean character = Pattern.compile("[a-zA-Z]").matcher(passwordVerfication).find();
		boolean number = Pattern.compile("[0-9]").matcher(passwordVerfication).find();
		boolean special = Pattern.compile("[@.$%#!`~()*^]").matcher(passwordVerfication).find();
		
		return (character&&number&&special) ? passwordVerfication : null;
	}

}
