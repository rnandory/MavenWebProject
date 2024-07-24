package com.newlecture.web.repository;

import java.io.IOException;
import java.util.List;

import com.newlecture.web.entity.Exam;

public interface ExamRepository {

	List<Exam> findAll() throws IOException;

	List<Exam> findByPage(int page) throws IOException;

}
