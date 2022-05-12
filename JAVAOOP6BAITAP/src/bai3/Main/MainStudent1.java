package bai3.Main;

import bai3.model.Student;
import serviceB3.StudentServiceImpl;

public class MainStudent1 {
	public static void main(String[] args) {
		Student student = new Student();
		
		StudentServiceImpl stuImpl = new StudentServiceImpl();
		
		stuImpl.input(student);
		stuImpl.info(student);
	}
}
