package jmaster.io.model;

import java.util.List;
import java.util.Scanner;


import jmaster.io.service.PersonService;
import jmaster.io.service.PersonServiceImpl;

public class MenuStudent {


//		public static void main(String[] args) {
//			menuCourse();
	//
//		}
		public static void menuStudent() {
//			while (true) {
//				Course mh = new Course();
//				CourseService courseService = new CourseServiceImpl(); // dung thong qua interface de quy chuan ham, khong
//																		// thi de CourseServiceImpl courseService = new
//																		// CourseSeviceImpl() cung duoc
//				courseService.input(mh);
//				courseService.insert(mh);
	//
//				System.out.println("Nhap them Y/N");
//				String c = new Scanner(System.in).nextLine();
//				if (c.equalsIgnoreCase("N")) {
//					break;
//				}
//			}
	//
//			// sau khi nhap xong doc ra
//			System.out.println("Doc ra");
//			CourseService couseService = new CourseServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau ham` => ben ngoai ham while
//			List<Course> courses = couseService.getAll();
//			for (Course c : courses)
//				couseService.info(c);
	//
//		}
			// cai menu student rieng, menu teacher rieng
			while(true) {
				System.out.println("------ Student-------");
				System.out.println("1. Add Student");
				System.out.println("2. Read Student");

				System.out.println("3. Exit");
				System.out.println("Vui long chon: ");
				int c = new Scanner(System.in).nextInt();
				if (c == 1) {

					write1();
				} else if (c == 2) {
				readAll1();
				} else if (c == 3) {
					break;
				}
				else System.out.println("Vui long chon lai");
			}
		}
			
		
			public static void readAll1() {
				System.out.println("Doc ra");
				PersonService personService = new PersonServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau ham` => ben ngoai ham while
				List<Student> st = personService.getAllStudents();
				for (Student c : st)
					personService.info(c);
			}
					
//					public static void readAll() {
//						System.out.println("Doc ra");
//						CourseService couseService = new CourseServiceImpl();// neu chi muon goi 1 lan thi de new doi tuong tren dau ham` => ben ngoai ham while
//						List<Course> courses = couseService.getAll();
//						for (Course c : courses)
//							couseService.info(c);
//			}
			public static void write1() {
					while (true) {
						Student stu = new Student();
						PersonService pService = new PersonServiceImpl(); // dung thong qua interface de quy chuan ham, khong
																				// thi de CourseServiceImpl courseService = new
																				// CourseSeviceImpl() cung duoc
						pService.input(stu);
						pService.insert(stu);

						System.out.println("Nhap them Y/N");
						String c = new Scanner(System.in).nextLine();
						if (c.equalsIgnoreCase("N")) {
							break;
						}
					}
				}

	
}	

