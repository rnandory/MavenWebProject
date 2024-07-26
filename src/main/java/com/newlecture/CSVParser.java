package com.newlecture;

import java.lang.reflect.Method;

import com.newlecture.annotations.Transient;
import com.newlecture.web.entity.Exam;

public class CSVParser {

	public static String toCSV(Exam exam) {
		// ", , ,"
		StringBuilder builder = new StringBuilder();

		// exam의 getter로 필드값 얻어와서 builder에 append
		Class clazz = exam.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		// exam의 getter만 뽑아내기
		for (Method m : methods) {
			String name = m.getName();

			if (name.startsWith("get")) {
				if (m.getAnnotation(Transient.class) == null)
					System.out.println(name);
			}
		}

		return builder.toString();
	}

}
