package com.trungtamjava.company.section7.homework;

import java.util.Scanner;

public class Developer extends Human {
	String programLanguage;

	@Override
	protected void info() {
		super.info();
		System.out.println(programLanguage);
	}

	@Override
	public void input() {
		super.input();
		System.out.println("nhap ngon ngu lap trinh");
		programLanguage = new Scanner(System.in).nextLine();

	}
}
