package serviceB3;

import java.util.Scanner;

import bai3.model.School;

public class SchoolServiceImpl implements SchoolService{

	@Override
	public void input(School sch) {
		System.out.println("Nhap thong tin School");

		System.out.println("Nhap id school: ");
		sch.setIdSchool(new Scanner(System.in).nextInt());

		System.out.println("Nhap name school: ");
		sch.setNameSchool(new Scanner(System.in).nextLine());

	}

	@Override
	public void info(School sch) {

		System.out.println("Id_sch: " + sch.getIdSchool() + " | " + "Name_sch: " + sch.getNameSchool());
	}
	
	
}
