package com.newlecture.web.service;

import java.io.IOException;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.FileExamRepository;

public class ExamService {

	FileExamRepository repository = new FileExamRepository();

	public List<Exam> getList() throws IOException {
		return getList(1);
	}

	public List<Exam> getList(int page) throws IOException {

		List<Exam> list = repository.findAll();

		return list;
	}
}
