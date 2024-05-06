package com.jspider.movieflix_java_servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.movieflix_java_servlet.connection.MovieFlixConnection;
import com.jspider.movieflix_java_servlet.dto.Admin;

/**
 * 
 * @Sachin
 */

public class MovieFlixDao {
	/*
	 * Created fetchAdminByEmailForLogin() method
	 */
	
	private Connection connection = MovieFlixConnection.getMovieFlixConnection();
	private final String SELECT_QUERY_FOR_LOGIN="select email, password from admin where email = ?";
	
	public Admin fetchAdminByEmailForLogin(String adminEmail) {
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY_FOR_LOGIN);
			ps.setString(1, adminEmail);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String email = rs.getString("email");
			String password = rs.getString("password");
			
			return new Admin(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
