package com.trungtamjava.model.section7.homework;

import java.util.Scanner;

public class Student extends Person {
	private String studentClass;

	@Override
	public void input() {
		System.out.println("nhap vao studentClass ");
		studentClass = new Scanner(System.in).nextLine();
		super.input();
	}
	@Override
	public void info() {
		super.info();
		System.out.println(studentClass);
	}
	
}
