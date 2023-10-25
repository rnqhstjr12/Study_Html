package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmploDAO;
import com.saeyan.dto.EmploVO;


public class EmploViewAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "/emplo/emploView.jsp";
		String id = request.getParameter("id");
		EmploDAO edao = EmploDAO.Inst();
		EmploVO evo = edao.selectEmploById(id);
		request.setAttribute("emplo", evo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
