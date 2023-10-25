package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmploDAO;
import com.saeyan.dto.EmploVO;

public class EmploWriteAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmploVO	evo = new EmploVO();
		evo.setId(request.getParameter("id"));
		evo.setPw(request.getParameter("pw"));
		evo.setName(request.getParameter("name"));
		evo.setLv(request.getParameter("lv"));
		evo.setGender(request.getParameter("gender"));
		evo.setPhone(request.getParameter("phone"));
		EmploDAO.Inst().insertEmplo(evo);
		
		new EmploListAction().execute(request, response);
	}
}
