package com.jspider.movieflix_java_servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspider.movieflix_java_servlet.connection.MovieFlixConnection;
import com.jspider.movieflix_java_servlet.dto.User;
import com.jspider.movieflix_java_servlet.verification.EmailPasswordVerification;

public class UserDao {
	private Connection connection = MovieFlixConnection.getMovieFlixConnection();

	private final String INSERT_USER_QUERY = "insert into user(name, email, password, dob, phone, gender) values(?, ?, ?, ?, ?, ?)";

	public User userRegistrationDao(User user) {

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_QUERY);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setObject(4, user.getDob());
			ps.setLong(5, user.getPhone());
			ps.setString(6, user.getGender());
			ps.execute();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
