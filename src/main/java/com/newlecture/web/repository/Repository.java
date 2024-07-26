package com.newlecture.web.repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {

	List<T> findAll() throws IOException;

	List<T> findByPage(int page) throws IOException;

	int save();

	int update();

}
