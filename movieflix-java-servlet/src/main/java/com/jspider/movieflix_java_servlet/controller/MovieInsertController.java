package com.jspider.movieflix_java_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertMovie")
public class MovieInsertController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("");
		String genresType = req.getParameter("");
		String language = req.getParameter("");
		String description = req.getParameter("");
		String productionhouse = req.getParameter("");
		String directorname = req.getParameter("");
		String quality = req.getParameter("");
		String name = req.getParameter("");
		String url = req.getParameter("");
		String type = req.getParameter("");
	}
}
