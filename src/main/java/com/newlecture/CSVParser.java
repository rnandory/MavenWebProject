package com.newlecture;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.newlecture.annotations.Precision;
import com.newlecture.annotations.Transient;

public class CSVParser {

	public static <T> String toCSV(T entity) throws IllegalAccessException, InvocationTargetException {
		// ", , ,"
		StringBuilder builder = new StringBuilder();

		// exam의 getter로 필드값 얻어와서 builder에 append
		Class cls = entity.getClass();
		Method[] methods = cls.getDeclaredMethods();
		// exam의 getter만 뽑아내기
		for (Method m : methods) {
			String name = m.getName();

			if (name.startsWith("get")) {
				if (!m.isAnnotationPresent(Transient.class)) {
					Object value = m.invoke(entity, (Object[]) null);

					if (m.isAnnotationPresent(Precision.class)) {
						Precision precision = m.getAnnotation(Precision.class);
						int v = precision.val();
						value = String.format("%." + v + "f", value);
					}

					builder.append(value);
					builder.append(",");

				}

			}
		}

		// field에 annotation붙이기 @Target(ElementType.FIELD)
		{
			Field[] fields = cls.getDeclaredFields();

			for (Field f : fields) {
				if (f.isAnnotationPresent(Transient.class)) {
					f.setAccessible(true);
					Object value = f.get(entity);
					System.out.println("eng: " + value);
				}
			}
		}

		return builder.toString();
	}

}
