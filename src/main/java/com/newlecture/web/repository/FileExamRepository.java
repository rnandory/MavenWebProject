package com.newlecture.web.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.entity.Exam;

public class FileExamRepository implements ExamRepository {

	public List<Exam> findAll() throws IOException {
		List<Exam> list = new ArrayList<>();

		FileInputStream fis = new FileInputStream("c:/res/data.csv");
		Scanner scan = new Scanner(fis);

		scan.nextLine(); // 컬럼명 버리기

		// 출력할 페이지 이전 성적들 버리기
//		for (int i = 0; scan.hasNextLine() && i < 6 * (page - 1); i++)
//			scan.nextLine();

		for (int i = 0; scan.hasNextLine()/* && i < 6 */; i++) {

			String name;
			int kor, eng, math;
//			int total;
//			double avg;
//			String grade = "F";

			// -----------------------------
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			// System.out.printf("tokens:", Arrays.toString(tokens));

			name = tokens[0];
			// 문자열 토큰 값을 숫자로 변경
			if (isNumeric(tokens[1]))
				kor = Integer.parseInt(tokens[1]);
			else
				kor = 0;

			// 유효성 검사
			if (!(0 <= kor && kor <= 100))
				kor = 0;

			// ----------------------------------

			// kor 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[2]))
				eng = 0;
			else
				eng = Integer.parseInt(tokens[2]);

			// kor 값의 유효성 검사
			if (!(0 <= eng && eng <= 100))
				eng = 0;

			// eng 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[3]))
				math = 0;
			else
				math = Integer.parseInt(tokens[3]);

			// eng 값의 유효성 검사
			if (!(0 <= math && math <= 100))
				math = 0;

//			// 성적 계산
//			total = kor + eng + math;
//			avg = total / 3.0;
//
//			grade = "F";
//
//			if (90 <= avg)
//				grade = "A";
//			else if (80 <= avg)
//				grade = "B";
//			else if (70 <= avg)
//				grade = "C";
//			else if (60 <= avg)
//				grade = "D";
//			else if (50 <= avg)
//				grade = "E";
			// else
			// grade = "F";

			// System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", name, kor, eng, math,
			// total, avg, grade);
//			String temp = String.format(row, name, kor, eng, math, total, avg, grade);

			list.add(new Exam(name, kor, eng, math));
		}

		scan.close();
		fis.close();

		return list;
	}

	@Override
	public List<Exam> findByPage(int page) throws IOException {
		List<Exam> list = new ArrayList<>();

		FileInputStream fis = new FileInputStream("c:/res/data.csv");
		Scanner scan = new Scanner(fis);

		scan.nextLine(); // 컬럼명 버리기

		// 출력할 페이지 이전 성적들 버리기
		for (int i = 0; scan.hasNextLine() && i < 6 * (page - 1); i++)
			scan.nextLine();

		for (int i = 0; scan.hasNextLine() && i < 6; i++) {

			String name;
			int kor, eng, math;
//			int total;
//			double avg;
//			String grade = "F";

			// -----------------------------
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			// System.out.printf("tokens:", Arrays.toString(tokens));

			name = tokens[0];
			// 문자열 토큰 값을 숫자로 변경
			if (isNumeric(tokens[1]))
				kor = Integer.parseInt(tokens[1]);
			else
				kor = 0;

			// 유효성 검사
			if (!(0 <= kor && kor <= 100))
				kor = 0;

			// ----------------------------------

			// kor 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[2]))
				eng = 0;
			else
				eng = Integer.parseInt(tokens[2]);

			// kor 값의 유효성 검사
			if (!(0 <= eng && eng <= 100))
				eng = 0;

			// eng 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[3]))
				math = 0;
			else
				math = Integer.parseInt(tokens[3]);

			// eng 값의 유효성 검사
			if (!(0 <= math && math <= 100))
				math = 0;

//			// 성적 계산
//			total = kor + eng + math;
//			avg = total / 3.0;
//
//			grade = "F";
//
//			if (90 <= avg)
//				grade = "A";
//			else if (80 <= avg)
//				grade = "B";
//			else if (70 <= avg)
//				grade = "C";
//			else if (60 <= avg)
//				grade = "D";
//			else if (50 <= avg)
//				grade = "E";
			// else
			// grade = "F";

			// System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", name, kor, eng, math,
			// total, avg, grade);
//			String temp = String.format(row, name, kor, eng, math, total, avg, grade);

			list.add(new Exam(name, kor, eng, math));
		}

		scan.close();
		fis.close();

		return list;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

}
