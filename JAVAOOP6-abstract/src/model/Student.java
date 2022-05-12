package model;

import java.util.Scanner;

public class Student extends Person {
	private String studentClass;
	/// 1 studen co nhieu laptop
	private Laptop[] laptops; // => 1 thang sinh vien co nhieu laptop
	
	
	// class con bat buoc phai goi constructor nhu cua class cha neu ko phai constructor default
	
	public Student() {
		super(0,"test");
	}	
// khi class cha co constructor ko phai mac dinh, thi o class con ke thua phai tao constructor va tu khoa super de goi constructor cua cha	
	
	public Student(int age, String name) {
		super(age, name);
	}
	
	@Override
	public void salary() {// khi override lai thi bo chu abstract di
		System.out.println("luong sinh vien");
	}
	
	@Override
	public void input() {
		// TODO Auto-generated method stub
		super.input();
		System.out.println("nhap ten lop: ");
		studentClass = new Scanner(System.in).nextLine();
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.println(studentClass);
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}



	public Laptop[] getLaptops() {
		return laptops;
	}



	public void setLaptops(Laptop[] laptopsArr) {
		this.laptops = laptopsArr;
	}
	

}

