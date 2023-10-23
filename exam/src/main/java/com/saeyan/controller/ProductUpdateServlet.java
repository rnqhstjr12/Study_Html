package com.saeyan.controller;

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
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductVO pvo = ProductDAO.Inst().selectProductByCode(code);
		
		request.setAttribute("product", pvo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		Integer price = Integer.parseInt(multi.getParameter("price"));
		String des = multi.getParameter("des");
		String imgUrl = multi.getFilesystemName("imgUrl");
		if (imgUrl == null) {
			imgUrl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO pvo = new ProductVO();
		pvo.setCode(Integer.parseInt(code));
		pvo.setName(name);
		pvo.setPrice(price);
		pvo.setDes(des);
		pvo.setImgUrl(imgUrl);
		
		ProductDAO.Inst().updateProduct(pvo);
		response.sendRedirect("productList.do");
	}
}
