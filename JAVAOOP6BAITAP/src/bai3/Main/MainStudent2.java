package bai3.Main;

import java.util.Scanner;

import bai3.model.Student;
import serviceB3.StudentServiceImpl;

public class MainStudent2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Moi nhap vao so luong sinh vien ");
		int n = new Scanner(System.in).nextInt();
		Student[] students = new Student[n];

		StudentServiceImpl[] stuImpl = new StudentServiceImpl[n];
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student();
			stuImpl[i] = new StudentServiceImpl();
			stuImpl[i].input(students[i]);

		}

		for (int i = 0; i < stuImpl.length; i++) {

			stuImpl[i].info(students[i]);
		}
		int max = students[0].getAgeStudent();
		for ( int i = 1; i < students.length; i++) {
			if ( max < students[i].getAgeStudent()) {
				max = students[i].getAgeStudent();
			}
		}
		System.out.println("\nSinh vien co tuoi lon nhat: ");
		for (int i = 0; i < students.length; i++) {
			if( students[i].getAgeStudent() == max ) {
				stuImpl[i].info(students[i]);
			}
		}
	}
	
		

// cach 2 
//	public static void main(String[] args) {
//
//		System.out.println("Nhap n-stu: ");
//		int n = new Scanner(System.in).nextInt();
//
//		Student[] students = new Student[n];
//		StudentServiceImpl studentImpl = new StudentServiceImpl();
//
//		for (int i = 0; i < students.length; i++) {
//			students[i] = new Student();
//			studentImpl.input(students[i]);
//		}
//
//		for (Student student : students) {
//			studentImpl.info(student);
//		}


}