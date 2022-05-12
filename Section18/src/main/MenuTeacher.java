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
import service.TeacherService;
import service.TeacherServiceImpl;

public class MenuTeacher {
	public static void main(String[] args) {
		menuTeacher();
	}

	public static void menuTeacher() {

		while (true) {
			System.out.println("------Teacher Menu-------");
			System.out.println("1. Insert Teacher");
			System.out.println("2. Update Teacher");
			System.out.println("3. Delete Teacher");
			System.out.println("4. Read Teacher");
			System.out.println("5. Exit");
			System.out.println("Vui long chon: ");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {
				insert();
			} else if (c == 2) {
				update();
			} else if (c == 3) { 	
				delete();
			} else if (c == 4) {
				readAll();
			} else if (c == 5) {
				System.exit(0);
				break;
			} else
				System.out.println("Vui long chon lai");
		}
	}

	private static void update() {
		TeacherService teacherService = new TeacherServiceImpl();
		System.out.println("cap nhat");
		Teacher mh = new Teacher();
		teacherService.input(mh);
		teacherService.update(mh);
		
	}

	private static void delete() {
		TeacherService teacherService = new TeacherServiceImpl();
		System.out.println("Nhap ID can xoa");
		int cId = new Scanner(System.in).nextInt();
		teacherService.delete(cId);

	}

	public static void readAll() {
		System.out.println("Doc ra");
		TeacherService teacherService = new TeacherServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau
																// ham` => ben ngoai ham while
		List<Teacher> teachers = teacherService.getAll();
		for (Teacher c : teachers)
			teacherService.info(c);
	}

	public static void insert() {
		TeacherService teacherService = new TeacherServiceImpl();	
		
		while(true) {
			System.out.println("Nhap them !");
			
			Teacher t = new Teacher();
			teacherService.input(t);
			teacherService.insert(t);
			
			System.out.println("Thoat an 0 (nhap so) !");
			int ts = new Scanner(System.in).nextInt();
			
			if(ts == 0) {
				break;
			}
		}
		
	}

}
