package com.trungtamjava.model.homework;

import java.util.Scanner;

public class SinhVien {
	int id;
	public String name;
	public int age;

	public void info() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
	}

	public void input() {
		System.out.println("moi nhap vao id ");
		id = new Scanner(System.in).nextInt();

		System.out.println("moi nhap vao ho ten ");
		name = new Scanner(System.in).nextLine();

		System.out.println("moi nhap tuoi ");
		age = new Scanner(System.in).nextInt();

	}

}
