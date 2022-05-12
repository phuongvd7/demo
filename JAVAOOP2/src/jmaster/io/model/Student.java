package jmaster.io.model;

import java.util.Scanner;

public class Student {
	int age;
	String name;

	public Student() {}

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
		
	}
	public void input() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("nhap vao tuoi");
		this.age = sc.nextInt();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("nhap vao ten");
		this.name = sc1.nextLine();
		}
	public void info() {
		System.out.println(this.age);
		System.out.println(this.name);
	}
	
}