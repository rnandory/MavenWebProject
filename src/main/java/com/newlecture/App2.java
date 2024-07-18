package com.newlecture;

import java.util.HashMap;
import java.util.Map;

// 자료구조 컬랙션

public class App2 {

	public static void main(String[] args) {
		{
			Map<String, Object> map = new HashMap<>();
			map.put("id", 1);
			map.put("title", "안녕하세요");
			map.put("writerId", 3);
			map.put("content", "냉무");

			// key값으로 꺼내기
			String title = (String) map.get("title");

			// 순회
			for (String key : map.keySet())
				System.out.println(key);

			for (Object value : map.values())
				System.out.println(value);

			for (Map.Entry<String, Object> entry : map.entrySet())
				System.out.printf("key:%s, value:%s\n", entry.getKey(), entry.getValue());

		}

//		{
//			List<Integer> list = new ArrayList<>();
//			list.add(Integer.valueOf(3));
//			// list.add("a");
//			list.add(4);
//			list.add(3);
//
//			int num = list.get(0);
//			System.out.println(num);
//		}

//			Set set = new HashSet();
//			set.add(3);
//			set.add(3);
//			set.add(4);
//			set.add(3);
//			int size = set.size();
//			System.out.println(size);
//			boolean hasNum = set.contains(3);

//		{
//			Exam exam = new Exam("hong", 1, 1, 1);
//			Exam exam1 = new Exam("ha", 2, 2, 2);
//
//			Set<Exam> exams = new HashSet<>(); // set의 중복기준 : 객체의 값이 아니라 객체 자체
//			exams.add(exam);
//			exams.add(exam1);
////			System.out.println(exams.size());
//
//			// 같은게 exam 출력
//			System.out.println(exams.iterator().next());
//			System.out.println(exams.iterator().next());
//
//			// 차례대로 exam 출력
//			Iterator it1 = exams.iterator();
//			while (it1.hasNext())
//				System.out.println(it1.next());
//
//			// for each : collection에서 iterator를 꺼내기 귀찮아서 생긴 제어문
//			for (Exam exa : exams) // exams는 iterator를 가지고 있어야 됨
//				System.out.println(exa);
//
//		}
	}

}
