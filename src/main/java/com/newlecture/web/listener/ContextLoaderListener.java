package com.newlecture.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		// 리스너를 라이브러리로 만들 때, 사용자로부터 설정값을 읽어와서 xml경로설정하는 예
		// 사용자가 직접 만들어서 톰캣에 설정해주는게 아니라서 @WebListener 안 씀
		String xml = "spring-settings2.xml";		
		Object location = sce.getServletContext().getInitParameter("location");
		if (location!=null)
			xml = String.valueOf(location);
		
		System.out.println("톰캣 시작됐어?");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings2.xml");

		sce.getServletContext().setAttribute("context", context);

		System.out.println("[OK]spring context loaded");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("톰캣 종료");
	}
}
