package main;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import model.Course;
import service.CourseService;
import service.CourseServiceImpl;

public class MainCourse {
	public static void main(String[] args) {
		menuCourse();
	}

	public static void menuCourse() {

		while (true) {
			System.out.println("------Course Menu-------");
			System.out.println("1. Add Course");
			System.out.println("2. Update Course");
			System.out.println("3. Delete Course");
			System.out.println("4. Read Course");
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
		CourseService couseService = new CourseServiceImpl();
		System.out.println("cap nhat");
		Course mh = new Course();
		couseService.input(mh);
		couseService.update(mh);
		
	}

	private static void delete() {
		CourseService couseService = new CourseServiceImpl();
		System.out.println("Nhap ID can xoa");
		int cId = new Scanner(System.in).nextInt();
		couseService.delete(cId);

	}

	public static void readAll() {
		System.out.println("Doc ra");
		CourseService couseService = new CourseServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau
																// ham` => ben ngoai ham while
		List<Course> courses = couseService.getAll();
		for (Course c : courses)
			couseService.info(c);
	}

	public static void write() {
		CourseService courseService = new CourseServiceImpl();// dung thong qua interface de quy chuan ham, khong
																// thi de CourseServiceImpl courseService = new
																// CourseSeviceImpl() cung duoc

		while (true) {
			Course mh = new Course();
			courseService.input(mh);
			courseService.insert(mh);

			System.out.println("Nhap them Y/N");
			String c = new Scanner(System.in).nextLine();
			if (c.equalsIgnoreCase("N")) {
				break;
			}
		}
	}
}
