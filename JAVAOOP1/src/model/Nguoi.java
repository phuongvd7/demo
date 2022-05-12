package model;

import java.util.Scanner;

public class Nguoi {
	int Age;
	String Name; // => duoc goi la bien non static => con goi la ham va bien doi tuong
	String Gender; // string la kieu class => luon phai viet hoa
	static String Quoctich; // static => dung chung cho tat ca doi tuong => neu thay doi, tat ca doi tuong
							// thay doi ==> dc goi la bien static hay ham va bien class
	
	public Nguoi() {
		System.out.println("cai cua minh tao ra");
	}
	public Nguoi(int Age) {
		System.out.println("thiet lap tuoi");
		this.Age = Age;  // chi ro ra tham so Age nhap vao dung cho bien Age o tren class
	}
	public Nguoi(String Name,String Gender) {
		
	}
	public void info() { // cai ham nay thi goi la gi??? la mot ham binh thuong ?????????????????????????????
		System.out.println(Name);
		System.out.println(Age);
		System.out.println(Gender);
		System.out.println(Quoctich);
	}

	public void input() {
		System.out.println("nhap ten");
		Name = new Scanner(System.in).nextLine();// cu co new tuc la goi 1 ham
		
		System.out.println("nhap gioi tinh");
		Gender = new Scanner(System.in).nextLine();
		
		System.out.println("nhap tuoi");
		Age = new Scanner(System.in).nextInt();
		
		System.out.println("nhap qt");
		Quoctich = new Scanner(System.in).nextLine();

	}
}
