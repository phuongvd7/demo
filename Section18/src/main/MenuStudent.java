package main;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import model.Course;
import model.Student;
import model.Teacher;
import service.CourseService;
import service.CourseServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

public class MenuStudent {
	public static void main(String[] args) {
		menuStudent();
	}

	public static void menuStudent() {

		while (true) {
			System.out.println("------Student Menu-------");
			System.out.println("1. Insert Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Read Student");
			System.out.println("5. Exit");
			System.out.println("Vui long chon: ");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {
				write();
			} else if (c == 2) {
				update();
			} else if (c == 3) { 	
				delete();
			} else if (c == 4) {
				readAll();
			} else if (c == 5) {
				break;
			} else
				System.out.println("Vui long chon lai");
		}
	}

	private static void update() {
		// TODO Auto-generated method stub
		StudentService studentService = new StudentServiceImpl();
		System.out.println("cap nhat");
		Student mh = new Student();
		studentService.input(mh);
		studentService.update(mh);
		
	}

	private static void delete() {
		StudentService studentService = new StudentServiceImpl();
		System.out.println("Nhap ID can xoa");
		int cId = new Scanner(System.in).nextInt();
		studentService.delete(cId);

	}

	public static void readAll() {
		System.out.println("Doc ra");
		StudentService studentService = new StudentServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau
																// ham` => ben ngoai ham while
		List<Student> students = studentService.getAll();
		for (Student c : students)
			studentService.info(c);
	}

	public static void write() {
		StudentService studentService = new StudentServiceImpl();// dung thong qua interface de quy chuan ham, khong
																// thi de CourseServiceImpl courseService = new
																// CourseSeviceImpl() cung duoc

		while (true) {
			Student mh = new Student();
			studentService.input(mh);
			studentService.insert(mh);

			System.out.println("Nhap them Y/N");
			String c = new Scanner(System.in).nextLine();
			if (c.equalsIgnoreCase("N")) {
				break;
			}
		}
	}
}
