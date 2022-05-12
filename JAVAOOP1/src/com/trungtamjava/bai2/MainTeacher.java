package com.trungtamjava.bai2;

public class MainTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher T1 = new Teacher();
		Teacher T2 = new Teacher();
		
		System.out.println(" Nhap thong tin T1");
		T1.input();
		
		System.out.println(" Nhap thong tin T2");
		T2.input();
		
		System.out.println(" T1 va T2 lan luot la");
		T1.info();
		T2.info();
		
		

	}

}