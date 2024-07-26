package com.newlecture;

import java.lang.reflect.InvocationTargetException;

import com.newlecture.web.entity.Exam;

public class App3 {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		// 간단한 처리기(CSVParer: Exam -> .csv)만들고 어노테이션 정의해서 설정해보기
		{
			Exam exam = new Exam("강호동", 80, 50, 60);
			String csv = CSVParser.toCSV(exam);

			System.out.println(csv);
		}

//		{
////			Exam exam = new Exam();
//			String classname = "com.newlecture.web.entity.Exam";
//			String callMethodName = "setName";
//			String value = "newlecture";
////			Exam exam = new classname() X;
//			Object obj = Class.forName(classname).getDeclaredConstructor().newInstance();
//			System.out.println(obj);
//
////			RTTI -> RuntimeTypeInformation java에선 Class
//			Class clazz = obj.getClass();
////			Class clazz2 = Exam.class;
//
//			Method[] methods = clazz.getDeclaredMethods();
//			for (Method m : methods) {
//				System.out.println(m.getName());
//				if (m.getName().equals(callMethodName))
//					m.invoke(obj, value); // 인스턴스 메소드는 호출 시 인스턴스도 필요 => obj도 인자로 전달
//			}
//			System.out.println(obj);
//		}
	}

}
