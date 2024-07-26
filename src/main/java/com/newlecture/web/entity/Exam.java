package com.newlecture.web.entity;

import com.newlecture.annotations.Transient;

public class Exam {
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Exam() {
		this("", 0, 0, 0);
	}

	public Exam(String name, int kor, int eng, int math) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	@Transient
	public int getTotal() {
		return kor + eng + math;
	}

	@Transient
	public double getAvg() {
		return getTotal() / 3.0;
	}

	@Transient
	public String getGrade() {
		String grade = "F";
		double avg = getAvg();

		if (90 <= avg)
			grade = "A";
		else if (80 <= avg)
			grade = "B";
		else if (70 <= avg)
			grade = "C";
		else if (60 <= avg)
			grade = "D";
		else if (50 <= avg)
			grade = "E";

		return grade;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Exam [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

}
