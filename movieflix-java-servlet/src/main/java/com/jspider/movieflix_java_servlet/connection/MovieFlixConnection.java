package com.jspider.movieflix_java_servlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MovieFlixConnection {
	/**
	 * @author Sachin
	 * {We have created this class for jdbc connection}
	 * 
	 */
	
	public static Connection getMovieFlixConnection() {
		try {
			//step-1 load/register driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mysql://localhost:3306/movieflix-java-servlet";
			String user ="root";
			String pass = "mysqlsac@123";
			
			return DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
