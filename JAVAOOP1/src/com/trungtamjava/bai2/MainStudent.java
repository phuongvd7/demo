package com.trungtamjava.bai2;

public class MainStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student S1 = new Student();
		Student S2 = new Student();
		
		System.out.println(" Nhap thong tin S1");
		S1.input();
		
		System.out.println(" Nhap thong tin S2");
		S2.input();
		
		System.out.println(" S1 va S2 lan luot la");
		S1.info();
		S2.info();
		
		

	}

}
