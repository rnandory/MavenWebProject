package com.newlecture.di;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;
import com.newlecture.web.service.ExamService;

public class App {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");

		Object exam = context.getBean("exam");
		System.out.println(exam);

		ExamService service = context.getBean(ExamService.class);
		List<Exam> list = service.getList();
		System.out.println(list);

		Repository<Exam> repository = context.getBean(Repository.class);
		List<Exam> list1 = repository.findAll();
		System.out.println(list1);
	}

}