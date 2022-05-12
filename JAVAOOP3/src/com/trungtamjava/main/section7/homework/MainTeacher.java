package com.trungtamjava.main.section7.homework;

import java.util.Scanner;

import com.trungtamjava.model.section7.homework.Student;
import com.trungtamjava.model.section7.homework.Teacher;

public class MainTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teacher();

	}
	
	public static void teacher() {
		System.out.println("nhap SL ");
		int  n = new Scanner(System.in).nextInt();
		Teacher[] t = new Teacher[n];
		for ( int i = 0 ; i < t.length ; i++) {
			t[i] = new Teacher();
			t[i].input();
		}
		
		
		for ( int i = 0 ; i < t.length ; i++) {
			t[i].info();
		}
		
	}

}
