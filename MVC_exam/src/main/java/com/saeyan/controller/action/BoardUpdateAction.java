package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardVO bvo = new BoardVO();
		
		bvo.setNum(Integer.parseInt(request.getParameter("num")));
		bvo.setName(request.getParameter("name"));
		bvo.setPw(request.getParameter("pw"));
		bvo.setEmail(request.getParameter("email"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		BoardDAO.Inst().updateBoard(bvo);
		new BoardListAction().execute(request, response);
	}
}
