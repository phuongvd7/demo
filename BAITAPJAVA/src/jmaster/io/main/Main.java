package jmaster.io.main;

import java.util.Scanner;

import jmaster.io.model.MenuCourse;
import jmaster.io.model.MenuStudent;

public class Main {
	public static void main(String[] args) {
		while (true) {
			System.out.println("------MENU MAIN-------");
			System.out.println("1. Course");
			System.out.println("2. Student");
			System.out.println("3. Teacher");
			System.out.println("4. Class");
			System.out.println("5. Exit");
			System.out.println("Vui long chon: ");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {
			MenuCourse.menuCourse();

			} else if (c == 2) {
				MenuStudent.menuStudent();

			} else if (c == 3) {
				
			} else if (c == 4) {
			} else if (c == 5) {
				break;
			} else
				System.out.println("Vui long chon lai!!!");
		}
	}

//	private static void readAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private static void write() {
//		// TODO Auto-generated method stub
//		
//	}
}
