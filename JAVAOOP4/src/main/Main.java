package main;

import model.Laptop;
import model.Person;
import model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student duy = new Student();
		duy.input(); 
		
		Student duong = new Student();
		duong.input();
		
		Laptop asus = new Laptop();
		asus.input();
		
		Laptop acer = new Laptop();
		acer.input();
		
		///tao quan he
		asus.setOwner(duy);
		acer.setOwner(duong);
		
		System.out.println("========INFO=========");
		asus.info();
		asus.getOwner().info();// chinh la duy
		duy.info(); // tuong duong cau lenh tren	
		
		System.out.println("acer info");
		acer.getOwner().info();
		duong.info();
	}

}
