package com.tlqkf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tlqkf.dao.MovieDAO;
import com.tlqkf.dto.MovieVO;

/**
 * Servlet implementation class MovieUpdateServlet
 */
@WebServlet("/movieUpdate.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MovieVO mvo = MovieDAO.Inst().selectMovieByCode(code);
		
		request.setAttribute("movie", mvo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieUpdate.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("poster");
		String encType = "UTF-8";
		int sizeLimit = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String title = multi.getParameter("title");
		Integer price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis = multi.getParameter("synopsis");
		String poster = multi.getParameter("poster");
		if (poster == null) {
			poster = multi.getParameter("nonmakeImg");
		}
		MovieVO mvo = new MovieVO();
		mvo.setCode(Integer.parseInt(code));
		mvo.setTitle(title);
		mvo.setPrice(price);
		mvo.setDirector(director);
		mvo.setActor(actor);
		mvo.setSynopsis(synopsis);
		mvo.setPoster(poster);
		
		MovieDAO.Inst().updateMovie(mvo);
		response.sendRedirect("movieList.do");
	}
}
