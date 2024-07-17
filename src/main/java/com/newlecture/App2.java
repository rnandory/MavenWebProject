package com.newlecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Exam;

// 자료구조 컬랙션

public class App2 {

	public static void main(String[] args) {
		Map map = new HashMap();

		{
			List<Integer> list = new ArrayList<>();
			list.add(Integer.valueOf(3));
			// list.add("a");
			list.add(4);
			list.add(3);

			int num = list.get(0);
			System.out.println(num);
		}
		{
			Exam exam = new Exam("hong", 1, 1, 1);
			Exam exam1 = new Exam("ha", 2, 2, 2);

			Set<Exam> exams = new HashSet<>(); // set의 중복기준 : 객체의 값이 아니라 객체 자체
			exams.add(exam);
			exams.add(exam1);
//			System.out.println(exams.size());

			// 같은게 exam 출력
			System.out.println(exams.iterator().next());
			System.out.println(exams.iterator().next());

//			Set set = new HashSet();
//			set.add(3);
//			set.add(3);
//			set.add(4);
//			set.add(3);
//			int size = set.size();
//			System.out.println(size);
//			boolean hasNum = set.contains(3);
		}
	}

}
