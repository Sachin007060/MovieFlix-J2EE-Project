package com.jspider.movieflix_java_servlet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jspider.movieflix_java_servlet.dao.MovieDao;
import com.jspider.movieflix_java_servlet.dto.Movie;

@WebServlet("/insertMovie")
public class MovieInsertController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieDao dao = new MovieDao();
		
		String name = req.getParameter("name");
		String genresType = req.getParameter("genresType");
		String language = req.getParameter("language");
		String description = req.getParameter("description");
		String productionHouse = req.getParameter("productionHouse");
		String directorname = req.getParameter("directorName");
		String quality = req.getParameter("quality");
		String url = req.getParameter("url");
		String type = req.getParameter("type");
		LocalDate releaseData = LocalDate.parse(req.getParameter("releaseDate"));
		
		Part part = req.getPart("image");
		
		Movie movie = new Movie(name, releaseData, genresType, language, description, productionHouse, directorname, quality, part.getInputStream(), url, type);
		dao.saveMovieDao(movie);
		
	}
	
}
