package com.trungtamjava.company.section7.homework;

import java.util.Scanner;

public class Human {
	private int Age;
	public String Name;
	private int id;

	protected void info() {
		System.out.println(Name);
		System.out.println(Age);
		System.out.println(id);
	}
	

	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void input() {
		System.out.println("nhap ten");
		Name = new Scanner(System.in).nextLine();

		System.out.println("nhap tuoi");
		Age = new Scanner(System.in).nextInt();
		
		System.out.println("nhap ma id");
		id = new Scanner(System.in).nextInt();
	}
}