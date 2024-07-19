package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exam/list")
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
}
