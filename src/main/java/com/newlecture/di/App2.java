package com.newlecture.di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;

public class App2 {

	public static void main(String[] args)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.newlecture.web");

		Repository<Exam> repository = context.getBean(Repository.class);

		List<Exam> list = repository.findAll();
//		System.out.println(list);

		// 패키지명으로 실제 바이너리파일 경로 알아내기
		String realPath;
		String pack = "com.newlecture.web.repository";
		{
			String path = pack.replace(".", "/");

			ClassLoader classLoader = App2.class.getClassLoader();
			realPath = classLoader.getResource(path).getFile().toString();
			realPath = realPath.substring(1, realPath.length());
			System.out.println(realPath);

		}

		// realPath로 디렉토리 스캔해서 객체생성
		{
			File directory = new File(realPath);

			File[] files = directory.listFiles();
			for (File f : files) {
				String type = " ";
				if (f.isDirectory())
					type = "d";
				System.out.printf("%s:%s\n", type, f.getName());

				if (f.isDirectory())
					continue;

				String className = pack + "." + f.getName();
				String qualifiedClassName = className.substring(0, className.length() - ".class".length());

				Class clazz = Class.forName(qualifiedClassName);
				// 인터페이스면 continue
				if (clazz.isInterface())
					continue;

				Object obj = clazz.getDeclaredConstructor(null).newInstance();
				System.out.println(obj);
			}
		}

	}

}
