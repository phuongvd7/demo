package main;

import model.Laptop;
import model.Student;
import service.PersonService;
import service.PersonServiceImpl;
import model.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//da abtract thi ko the new doi tuong dc		Person p = new Person();
		//interface cung khong the new doi tuong duoc
//		PersonService pService = new PersonService();
		PersonService pService = new PersonServiceImpl();
		
		pService.input();
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
