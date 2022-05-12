package com.trungtamjava.bai3;

public class MainCourseScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CourseScore C1 = new CourseScore();
		CourseScore C2 = new CourseScore();
	
	System.out.println(" Nhap thong tin p1");
	C1.input();
	
	System.out.println(" Nhap thong tin p2");
	C2.input();
	
	System.out.println(" P1 va p2 lan luot la");
	C1.info();
	C2.info();
	

}
}