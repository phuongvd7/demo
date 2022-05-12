package com.trungtamjava.bai3;

import java.util.Scanner;

public class CourseScore {
	int id;
	float score;
	String name;

	public void input() {
		System.out.println("Nhap vao ho ten");
		name = new Scanner(System.in).nextLine();
		System.out.println("Nhap vao  id");
		id = new Scanner(System.in).nextInt();
		System.out.println("Nhap vao  diem");
		score = new Scanner(System.in).nextFloat();

	}

	public void info() {

		if (score < 5) {
			System.out.println("diem so yeu");
		} else if (score >= 5 && score < 7) {
			System.out.println("diem so nay " + this.score + " cua " + this.name + " la diem so TB");
		} else if (score >= 7 && score < 8) {
			System.out.println("diem so gioi");
		} else
			System.out.println("xuat sac");
	}

}
