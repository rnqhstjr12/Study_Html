package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSet
 */
@WebServlet("/LoginSet")
public class LoginSet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String rNum = request.getParameter("jumin_1") +
				"-" + request.getParameter("jumin_2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		if (request.getParameter("hdEmail_dns").trim() == "") {
			email += "@" + request.getParameter("emailaddr");
		} else {
			email += "@" + request.getParameter("hdEmail_dns");
		}
		String zipCode = request.getParameter("zip");
		String addr = request.getParameter("addr1") +
				"-" + request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String coffs[] = request.getParameterValues("interest");
		
		out.print("<html><body>");
		out.println("이름 : ");
		out.print(name);

		out.println("<br>주민번호 : ");
		out.print(rNum);

		out.println("<br>아 이 디 : ");
		out.print(id);

		out.println("<br>비밀번호 : ");
		out.print(pwd);

		out.println("<br>이 메 일 : ");
		out.print(email);

		out.println("<br>우편번호 : ");
		out.print(zipCode);

		out.println("<br>주소 : ");
		out.print(addr);

		out.println("<br>핸드폰번호 : ");
		out.print(phone);

		out.println("<br>직업 : ");
		out.print(job);

		out.println("<br>관심분야 : ");
		if (coffs.length == 0) {
			out.print("선택한 항목이 없습니다."); 
		} else {
			for (String coff : coffs) {
				out.print(coff + " "); 
			} 
		}
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
