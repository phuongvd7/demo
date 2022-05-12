package com.trungtamjava.model.homework;

import java.util.Scanner;

public class School {
	private int id;
	private String address;
	public String schoolName;
	
	public School() {}
	
	public void info() {
		System.out.println(id);
		System.out.println(address);
		System.out.println(schoolName);
	}
	
	public void input() {
		System.out.println("moi nhap vao id ");
		id = new Scanner(System.in).nextInt();
		
		System.out.println("moi nhap vao dia chi ");
		address = new Scanner(System.in).nextLine();
		
		System.out.println("moi nhap ten truong ");
		schoolName = new Scanner(System.in).nextLine();
		
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public int getId() {
		return id;
	}
}
