package com.trungtamjava.bai2;

import java.util.Scanner;

public class Teacher {
	int id;
	String name;
	String address;
	String facility;
	public void input() {
		System.out.println("Nhap vao ho ten");
		name = new Scanner(System.in).nextLine();
		System.out.println("Nhap vao dia chi");
		address = new Scanner(System.in).nextLine();
		System.out.println("Nhap vao  MSV");
		id = new Scanner(System.in).nextInt();
		System.out.println("Nhap vao chuyen mon");
		facility = new Scanner(System.in).nextLine();
		
		}
	public void info() {
		System.out.println(name);
		System.out.println(address);
		System.out.println(id);
		System.out.println(facility);
	}	

}
