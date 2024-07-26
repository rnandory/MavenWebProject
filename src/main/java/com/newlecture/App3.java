package com.newlecture;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.newlecture.web.entity.Exam;

public class App3 {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		// 객체생성
		{
			Exam exam = new Exam();
		}

		{
//			Exam exam = new Exam();
			String classname = "com.newlecture.web.entity.Exam";
//			Exam exam = new classname() X;
			Exam exam = (Exam) Class.forName(classname).getDeclaredConstructor().newInstance();
			System.out.println(exam);

//			RTTI -> RuntimeTypeInformation java에선 Class
			Class clazz = exam.getClass();
			Class clazz2 = Exam.class;

			Method[] methods = clazz.getDeclaredMethods();
			for (Method m : methods)
				System.out.println(m.getName());

			exam.setKor(30);
			System.out.println(exam);
		}
	}

}
