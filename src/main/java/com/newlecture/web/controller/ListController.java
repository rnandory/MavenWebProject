package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/exam/list")
@MultipartConfig(maxFileSize = 20 * 1024 * 1024, maxRequestSize = 200 * 1024 * 1024)
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; UTF-8");
		PrintWriter out = resp.getWriter();

		// 칼라
		String[] colors = {};
		String[] colors_ = req.getParameterValues("c");

		if (colors_ != null)
			colors = colors_;

		for (int i = 0; i < colors.length; i++)
			System.out.println(colors[i]);

		// 페이지 옵션
		int page = 1;
		String page_ = req.getParameter("p");
		if (page_ != null)
			page = Integer.parseInt(page_);

		ExamService service = new ExamService();

		List<Exam> list = service.getList(page);

		req.setAttribute("list", list);
		req.setAttribute("page", page);

		// /exam/list -> forward -> /WEB-INF/view/exam/list.jsp
		req.getRequestDispatcher("/WEB-INF/view/exam/list.jsp").forward(req, resp);
		// resp.sendRedirect("list.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part imgPart = req.getPart("img");
		String imgName = imgPart.getSubmittedFileName();
		InputStream is = imgPart.getInputStream();

		String path = "c:/8th/WebWork/" + imgName;

		FileOutputStream fos = new FileOutputStream(path);

		for (int b = 0; (b = is.read()) != -1;)
			fos.write(b);
	}
}
