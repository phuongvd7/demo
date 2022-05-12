package model;

import java.util.Scanner;

public class Laptop {
	String ram;
	String processor;
	String Name;
	String Color = "yellow";
	static String NoiSx;

//	public Laptop(String ram,String processor , String Name, String Color) {
//		this.ram = ram;
//		this.processor = processor;
//		this.Name = Name;
//		this.Color = Color;
//	}
	
public void info() {
	System.out.println(Name);
	System.out.println(ram);
	System.out.println(processor);
	System.out.println(Color);
}

public void input() {
	System.out.println("nhap thong tin ram");
	ram = new Scanner(System.in).nextLine();// cu co new tuc la goi 1 ham
	
	System.out.println("nhap thong tin chip");
	processor = new Scanner(System.in).nextLine(); // dat ten bien cung ten bien trong class thi no se lay bien ben trong class luon
	
	System.out.println("nhap thong tin mau sac");
	Color = new Scanner(System.in).nextLine();
	
	System.out.println("nhap hang thiet bi");
	NoiSx = new Scanner(System.in).nextLine();
}
}