package serviceB3;

import java.util.Scanner;

import bai3.model.Address;
import bai3.model.School;
import bai3.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public void input(Student stu) {
		System.out.println("Nhap thong tin student ");
	
		System.out.println("Nhap id student ");
		stu.setIdStudent(new Scanner(System.in).nextInt());
		
		System.out.println("Nhap name student ");
		stu.setNameStudent(new Scanner(System.in).nextLine());
		
		System.out.println("Nhap tuoi student ");
		stu.setAgeStudent(new Scanner(System.in).nextInt());
		
//		School school = new School();
//		SchoolServiceImpl schImpl = new SchoolServiceImpl();
//		schImpl.input(school);
//		stu.setSchool(school);
//
//		Address address = new Address();
//		AddressServiceImpl addImpl = new AddressServiceImpl();
//		addImpl.input(address);
//		stu.setAddress(address);
		
	}

	@Override
	public void info(Student stu) {
		// TODO Auto-generated method stub
		System.out.println("--------------");
		System.out.println("Id_stu: " + stu.getIdStudent() + " | " + "Name_stu: " + stu.getNameStudent() + " | " + "Age_stu: "
				+ stu.getAgeStudent());
	}
	
}
