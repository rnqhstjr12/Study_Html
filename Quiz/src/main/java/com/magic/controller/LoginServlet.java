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
 * Servlet implementation class loginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = "member/login.jsp";
		
		String id = request.getParameter("id"); // 입력받은 id를 가져온다
		String pw = request.getParameter("pw"); // 입력받은 pw를 가져온다
		String lv = request.getParameter("lv");
		EmployeesDAO edao = EmployeesDAO.getInst(); // EmployeesDAO의 getInst(new없이 바로사용할수있게)메서드를 변수 edao로 선언
		int result = edao.userCheck(id, pw, lv); // -1, 0, 1 로만 반환값을 가지는 userCheck메서드를 result라는 변수로 선언
		if (result == 2 || result == 3) {
			EmployeesVO evo = edao.getEmployees(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", evo);
			session.setAttribute("result", result);
			request.setAttribute("message", "회원 등록에 성공했습니다.");
			url = "main.jsp";
		} else {
			url = "member/login.jsp";
			if (result == 1) {
				request.setAttribute("message", "등급이 맞지 않습니다.");
			} else if (result == 0) {
				request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			} else if (result == -1) {
				request.setAttribute("message", "존재하지 않는 회원입니다.");
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}