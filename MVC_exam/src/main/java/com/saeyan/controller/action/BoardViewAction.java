package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "/board/boardView.jsp";
		String num = request.getParameter("num");
		BoardDAO bdao = BoardDAO.Inst();
		bdao.updateReadCount(num);
		BoardVO bvo = bdao.selectBoardByNum(num);
		request.setAttribute("board", bvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
