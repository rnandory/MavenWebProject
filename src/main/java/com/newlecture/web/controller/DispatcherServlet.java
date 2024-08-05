package com.newlecture.web.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/", loadOnStartup = 1, initParams = {
		@WebInitParam(name = "path", value = "/WEB-INF/app.properties"),
		@WebInitParam(name = "spring", value = "/WEB-INF/spring-dispatcher.xml")
})
public class DispatcherServlet extends HttpServlet{
	
//	private Properties props;
	private ApplicationContext context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String path = config.getInitParameter("spring");
		String realPath = config.getServletContext().getRealPath(path);
		context = new ClassPathXmlApplicationContext(realPath);
		
//		// spring없이 props로 url-controller클래스 맵핑
//		props = new Properties();
//		String path = config.getInitParameter("path");
//		String realPath = config.getServletContext().getRealPath(path);
//		
//		try {
//			InputStream is = new FileInputStream(realPath);
//			props.load(is);
//			
//			System.out.println(props);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Controller controller = (Controller) context.getBean(uri);
		
		// 요청한 url이 설정목록에 없을 때
		if (controller == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		try {
			controller.handleRequest(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
