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
 * Servlet implementation class MovieWriteServlet
 */
@WebServlet("/movieWrite.do")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieWrite.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("poster");
		String encType = "UTF-8";
		int sizeLimit = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		MovieVO mvo = new MovieVO();
		mvo.setTitle(multi.getParameter("title"));
		mvo.setPrice(Integer.parseInt(multi.getParameter("price")));
		mvo.setDirector(multi.getParameter("director"));
		mvo.setActor(multi.getParameter("actor"));
		mvo.setSynopsis(multi.getParameter("synopsis"));
		mvo.setPoster(multi.getParameter("poster"));
		System.out.println(mvo);
		MovieDAO.Inst().insertMovie(mvo);
		response.sendRedirect("movieList.do");
	}
}
