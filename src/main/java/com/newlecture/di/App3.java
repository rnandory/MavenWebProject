package com.newlecture.di;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

public class App3 {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");

		ExamService service = context.getBean(ExamService.class);
		List<Exam> list = service.getList();
		System.out.println(list);

	}

}
