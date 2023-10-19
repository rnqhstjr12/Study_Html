package com.magic.controller;

import java.io.IOException;

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
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmployeesDAO edao = EmployeesDAO.getInst();
		EmployeesVO evo = edao.getEmployees(id);
		request.setAttribute("evo", evo);
		request.setAttribute("loginUser", evo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/mypage.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		EmployeesVO evo = new EmployeesVO();
		HttpSession session = request.getSession();
		evo.setId(request.getParameter("id"));
		evo.setPw(request.getParameter("pw"));
		evo.setName(request.getParameter("name"));
		evo.setLv(request.getParameter("lv"));
		evo.setSex(Integer.parseInt(request.getParameter("sex")));
		evo.setPhone(request.getParameter("phone"));
		EmployeesDAO.getInst().editEmployees(evo);
		response.sendRedirect("member/editEnd.jsp");
		session.setAttribute("loginUser", evo);

	}
}
