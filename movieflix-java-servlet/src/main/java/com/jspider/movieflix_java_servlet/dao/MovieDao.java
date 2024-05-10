package com.jspider.movieflix_java_servlet.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.movieflix_java_servlet.connection.MovieFlixConnection;
import com.jspider.movieflix_java_servlet.dto.Movie;

public class MovieDao {

	Connection connection = MovieFlixConnection.getMovieFlixConnection();

	private final String INSERT_MOVIE_QUERY = "insert into movie(name, image, releasedata, genrestyle, language, description, productionhouse, directorname, quality, url, type) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	private final String SELECT_ALL_MOVIE_QUERY = "select * from movie";

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
	
	public List<Movie> getAllMovieDetailsDao(){
		try {
			
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_MOVIE_QUERY);
			ResultSet rs = ps.executeQuery();
			
			List<Movie> movies = new ArrayList<Movie>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String genresType = rs.getString("genrestyle");
				String language = rs.getString("language");
				String description = rs.getString("description");
				String productionHouse = rs.getString("productionhouse");
				String directorname = rs.getString("productionhouse");
				String quality = rs.getString("quality");
				String url = rs.getString("url");
				String type = rs.getString("type");
				InputStream image = rs.getBinaryStream("image");
				LocalDate releaseDate = rs.getDate("releasedata").toLocalDate();
				
				Movie movie = new Movie(id, name, releaseDate, genresType, language, description, productionHouse, directorname, quality, image, url, type);
				
				movies.add(movie);
				
			}
			return movies;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Movie> getSpecificTypeMovieDetails(String movieType){
		List<Movie> movies=getAllMovieDetailsDao();
		
		List<Movie> specificType = new ArrayList<Movie>();
		
		for (Movie movie : movies) {
			if(movie.getType().equalsIgnoreCase(movieType)) {
				specificType.add(movie);
			}
		}
		
		return specificType;
	}
	
	
}
