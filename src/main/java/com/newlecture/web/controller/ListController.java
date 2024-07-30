package com.newlecture.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

	ExamService service;

	public ListController() {
//		Repository<Exam> repository = new JDBCExamRepository();
//		service = new ExamService(repository);
		// service = new ExamService(new JDBCExamRepository());
		service = context.getBean(service);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; UTF-8");
//		PrintWriter out = resp.getWriter();

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

		String realPath = req.getServletContext().getRealPath("/notice/upload");

		File pathFile = new File(realPath);
		if (!pathFile.exists())
			pathFile.mkdirs();

		String path = realPath + File.separator + imgName;
		FileOutputStream fos = new FileOutputStream(path);

		byte[] buf = new byte[1024];
		for (int size = 0; (size = is.read(buf)) != -1;)
			fos.write(buf, 0, size);
	}
}
