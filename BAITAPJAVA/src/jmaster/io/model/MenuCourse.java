package jmaster.io.model;

import java.util.List;
import java.util.Scanner;

import jmaster.io.service.CourseService;
import jmaster.io.service.CourseServiceImpl;

public class MenuCourse {

//	public static void main(String[] args) {
//		menuCourse();
//
//	}
	public static void menuCourse() {
//		while (true) {
//			Course mh = new Course();
//			CourseService courseService = new CourseServiceImpl(); // dung thong qua interface de quy chuan ham, khong
//																	// thi de CourseServiceImpl courseService = new
//																	// CourseSeviceImpl() cung duoc
//			courseService.input(mh);
//			courseService.insert(mh);
//
//			System.out.println("Nhap them Y/N");
//			String c = new Scanner(System.in).nextLine();
//			if (c.equalsIgnoreCase("N")) {
//				break;
//			}
//		}
//
//		// sau khi nhap xong doc ra
//		System.out.println("Doc ra");
//		CourseService couseService = new CourseServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau ham` => ben ngoai ham while
//		List<Course> courses = couseService.getAll();
//		for (Course c : courses)
//			couseService.info(c);
//
//	}
		while(true) {
			System.out.println("------Course Menu-------");
			System.out.println("1. Add Course");
			System.out.println("2. Read Course");

			System.out.println("3. Exit");
			System.out.println("Vui long chon: ");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {

				write();
			} else if (c == 2) {
				readAll();
			} else if (c == 3) {
				break;
			}
			else System.out.println("Vui long chon lai");
		}
	}
		
	
		public static void readAll() {
			System.out.println("Doc ra");
			CourseService couseService = new CourseServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau ham` => ben ngoai ham while
			List<Course> courses = couseService.getAll();
			for (Course c : courses)
				couseService.info(c);
		}
		public static void write() {
				while (true) {
					Course mh = new Course();
					CourseService courseService = new CourseServiceImpl(); // dung thong qua interface de quy chuan ham, khong
																			// thi de CourseServiceImpl courseService = new
																			// CourseSeviceImpl() cung duoc
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
	

