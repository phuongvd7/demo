package com.trungtamjava.main.section7.homework;

import java.util.Scanner;

import com.trungtamjava.model.section7.homework.Student;

public class MainStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student();
	}
	
	public static void student() {
		System.out.println("nhap SL ");
		int  n = new Scanner(System.in).nextInt();
		Student[] st = new Student[n];
		for ( int i = 0 ; i < st.length ; i++) {
			st[i] = new Student();
			st[i].input();
		}
		
		
		for ( int i = 0 ; i < st.length ; i++) {
			st[i].info();
		}
		
	}

}
