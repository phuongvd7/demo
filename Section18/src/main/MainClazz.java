package main;

import java.util.List;
import java.util.Scanner;

import model.Clazz;
import service.ClazzService;
import service.ClazzServiceImpl;


public class MainClazz {

	public static void main(String[] args) {
		menuClazz();
	}

	public static void menuClazz() {
		while (true) {
			System.out.println("_____CLAZZ_____");
			System.out.println("1.Insert Clazz");
			System.out.println("2.Update Clazz");
			System.out.println("3.Delete Clazz");
			System.out.println("4.Read Clazz");
			System.out.println("5.SearchByCourseName");
			System.out.println("6.Exit");

			System.out.println("Vui long chon !");

			int n = new Scanner(System.in).nextInt();
			if (n == 1) {
				write();
				break;
			} else if (n == 2) {
				update();
				break;
			} else if (n == 3) {
				delete();
				break;
			} else if (n == 4) {
				readAll();
				break;
			} else if(n == 5) {
				searchByCourseName();
				break;
			} else {
				System.exit(n);
				break;
			}
		}
	}
	private static void searchByCourseName() {

		ClazzService c_Service = new ClazzServiceImpl();
		System.out.println("Nhap ten course can tim: ");
		
		String name = new Scanner(System.in).nextLine();
		
		List<Clazz> clazzList = c_Service.searchByCourseName(name);
		
		for(Clazz c : clazzList) {
			c_Service.info(c);
		}

	}

	private static void delete() {
		ClazzService c_Service = new ClazzServiceImpl();
		System.out.println("Nhap id can xoa: ");

		int cid = new Scanner(System.in).nextInt();
		c_Service.delete(cid);
	}

	private static void readAll() {
		
		ClazzService c_Service = new ClazzServiceImpl();
		List<Clazz> list = c_Service.getAll();
		System.out.println("Danh sach doc ra");
		for (Clazz c : list) {
			c_Service.info(c);
		}
	}

	private static void update() {
		ClazzService c_Service = new ClazzServiceImpl();
		System.out.println("Cap nhat lai !");
		Clazz c = new Clazz();
		c_Service.input(c);
		c_Service.update(c);
	}

	private static void write() {

		ClazzService c_Service = new ClazzServiceImpl();
		
		while (true) {
			Clazz c = new Clazz();
			c_Service.input(c);
			c_Service.insert(c);

			System.out.println("Thoat chon 0");
			int n = new Scanner(System.in).nextInt();
			if (n == 0) {
				break;
			}
		}
	}
}