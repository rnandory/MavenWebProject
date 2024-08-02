package com.newlecture.web.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;

@Component
public class ExamService {

	Repository<Exam> repository;

	public ExamService() {
		// TODO Auto-generated constructor stub
	}

	// Constructor Dependency Injection
	@Autowired
	public ExamService(Repository<Exam> repository) {
		this.repository = repository;
//		repository = new FileExamRepository();
//		repository = new JDBCRepository();
	}

	public List<Exam> getList() throws IOException {
		return getList(1);
	}

	public List<Exam> getList(int page) throws IOException {

//		List<Exam> list = repository.findAll();

		List<Exam> list = repository.findByPage(page);

		return list;
	}

	public void setRepository(Repository<Exam> repository) {
		this.repository = repository;
	}

}
