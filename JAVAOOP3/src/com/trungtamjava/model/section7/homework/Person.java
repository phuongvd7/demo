package com.trungtamjava.model.section7.homework;

import java.util.Scanner;

public class Person {
	private int Age;
	private String Name;
	String Gender;
	String Quoctich;

//	public Person() {
//		System.out.println("cai cua minh tao ra");
//	}
//
//	public Person(int Age) {
//		System.out.println("thiet lap tuoi");
//		this.Age = Age;
//	}
//
//	public Person(String Name, String Gender) {
//
//	}

	protected void info() {
		System.out.println(Name);
		System.out.println(Age);
//		System.out.println(Gender);
//		System.out.println(Quoctich);
	}

	public void input() {
		System.out.println("nhap ten");
		Name = new Scanner(System.in).nextLine();// cu co new tuc la goi 1 ham

//		System.out.println("nhap gioi tinh");
//		Gender = new Scanner(System.in).nextLine();

		System.out.println("nhap tuoi");
		Age = new Scanner(System.in).nextInt();

//		System.out.println("nhap qt");
//		Quoctich = new Scanner(System.in).nextLine();

	}
}
