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
		
		int page = 1;
		
		ExamService service = new ExamService();
		
		List<Exam> list = service.getList();
		
		req.setAttribute("list", list);

		// /exam/list -> forward -> /WEB-INF/view/exam/list.jsp
		req.getRequestDispatcher("/WEB-INF/view/exam/list.jsp").forward(req, resp);
		//resp.sendRedirect("list.jsp");
	}

}
