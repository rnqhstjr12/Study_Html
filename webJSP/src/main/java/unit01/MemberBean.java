package unit01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.javabeans.MemberBeanTQ;

/**
 * Servlet implementation class MemberBean
 */
@WebServlet("/MemberBean")
public class MemberBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBeanTQ member = new MemberBeanTQ("전수빈", "pinksubin");
		
		request.setAttribute("member", member);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("24_el.jsp");
		dispatcher.forward(request, response);
	}
}
