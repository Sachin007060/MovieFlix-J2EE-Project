package com.jspider.movieflix_java_servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspider.movieflix_java_servlet.connection.MovieFlixConnection;
import com.jspider.movieflix_java_servlet.dto.Movie;

public class MovieDao {

	Connection connection = MovieFlixConnection.getMovieFlixConnection();

	private final String INSERT_MOVIE_QUERY = "insert into movie(name, image, releasedata, genrestyle, language, description, productionhouse, directorname, quality, url, type) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public Movie saveMovieDao(Movie movie) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_MOVIE_QUERY);
			ps.setString(1, movie.getName());
			ps.setBlob(2, movie.getImage());
			ps.setObject(3, movie.getReleasedYear());
			ps.setString(4, movie.getGenresType());
			ps.setString(5, movie.getLanguage());
			ps.setString(6, movie.getDescription());
			ps.setString(7, movie.getProductionHouse());
			ps.setString(8, movie.getDirectorName());
			ps.setString(9, movie.getQuality());
			ps.setString(10, movie.getUrl());
			ps.setString(11, movie.getType());
			ps.execute();
			return movie;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
