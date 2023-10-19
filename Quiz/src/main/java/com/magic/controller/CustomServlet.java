package com.magic.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/custom.do")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/custom.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		EmployeesVO evo = new EmployeesVO();
		evo.setId(request.getParameter("id"));
		evo.setPw(request.getParameter("pw"));
		evo.setName(request.getParameter("name"));
		evo.setLv(request.getParameter("lv"));
		evo.setSex(Integer.parseInt(request.getParameter("sex")));
		evo.setPhone(request.getParameter("phone"));
		int result = EmployeesDAO.getInst().insertMember(evo);
		System.out.println(result);
		HttpSession session = request.getSession();
		if (result == 1) {
			session.setAttribute("id", evo.getId());
			request.setAttribute("loginUser", evo);
			request.setAttribute("message", "회원 등록에 성공했습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customend.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("message", "회원 등록에 실패했습니다.");
		}
	}

}
