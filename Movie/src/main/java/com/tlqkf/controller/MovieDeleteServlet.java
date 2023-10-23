package com.tlqkf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tlqkf.dao.MovieDAO;

/**
 * Servlet implementation class MovieDeleteServlet
 */
@WebServlet("/movieDelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		request.setAttribute("movie", MovieDAO.Inst().selectMovieByCode(code));
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieDelete.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MovieDAO.Inst().deleteMovie(code);
		response.sendRedirect("movieList.do");
	}
}
