package com.trungtamjava.main.section6.homework;

import java.util.Scanner;

import com.trungtamjava.model.homework.School;

public class MainSchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("nhap vao so luong sinh vien ");
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt(); tuong duong voi
		int n = new Scanner(System.in).nextInt();
		School [] schools = new School[n];
		for (int i = 0 ; i < schools.length ; i++) {
			schools[i] = new School();
			schools[i].input();
		}
		
		for (int i = 0 ; i < schools.length ; i++) {
			schools[i].info();
		}
		System.out.println("nhap vao ki tu ");
		String check = new Scanner(System.in).nextLine();
		for (int i = 0 ; i < schools.length ; i++) {
			if(schools[i].schoolName.toLowerCase().contains(check.toLowerCase().trim())) {
				schools[i].info();
			}
		}
	}

}
