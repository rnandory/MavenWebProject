package com.newlecture.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

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
