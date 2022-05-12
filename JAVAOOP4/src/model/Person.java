package model;

import java.util.Scanner;

public class Person {

	private int age;
	private String name;

//	public Person() {
//	}

	public Person(int Age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	protected void info() {
		System.out.println(name);
		System.out.println(age);
	}

	public void input() {
		System.out.println("nhap ten: ");
		name = new Scanner(System.in).nextLine();

		System.out.println("nhap tuoi: ");
		age = new Scanner(System.in).nextInt();

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
