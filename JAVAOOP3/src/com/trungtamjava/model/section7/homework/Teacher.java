package com.trungtamjava.model.section7.homework;

import java.util.Scanner;

public class Teacher extends Person {
	private String major;
	
	@Override
	public void input() {
		System.out.println("nhap vao major ");
		major = new Scanner(System.in).nextLine();
		super.input();
	}
	@Override
	public void info() {
		super.info();
		System.out.println(major);
	}
	
}

