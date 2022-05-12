package MainBai2;

import java.util.Scanner;

import Model.Chicken;
import Model.Dog;
import ModelBai2.PhuongTien;
import ModelBai2.Train;
import ModelBai2.Car;

public class MainTransport {
	public static void main(String[] args) {
		while (true) {
			System.out.println("Vui long chon phuong tien !!!");
			System.out.println("1. Train");
			System.out.println("2. Car");
			System.out.println("3.Exit");

			int n = new Scanner(System.in).nextInt();

			if (n == 1) {
				System.out.println("1. Train");
				menuTrain();
				break;
			} else if (n == 2) {
				System.out.println("2. Car");
				menuCar();
				break;
			} else if (n == 3) {
				System.out.println("Ban da thoat chuong trinh");
				System.exit(n);
			} else {
				System.out.println("Ban chua chon ptien !");
			}
		}
	}

	public static void input(PhuongTien pTien) {

		System.out.println("Nhap so ghe ");
//	pTien.setSeatNumber(new Scanner(System.in).nextInt());
		int n1 = new Scanner(System.in).nextInt();
		pTien.setSeatNumber(n1);

		System.out.println("Nhap gia ve ");
		int n2 = new Scanner(System.in).nextInt();
		pTien.setPrice(n2);

/*		if(pTien instanceof Train) {
			Train t = (Train) pTien;
			
			System.out.println("Nhap so toa: ");
			t.setSoToa(new Scanner(System.in).nextInt());
		}
		
		if(pTien instanceof Car) {
			Car c = (Car) pTien;
			
			System.out.println("Nhap so chan: ");
			c.setLoaiXe(new Scanner(System.in).nextLine());
		}*/

		if (pTien instanceof Train) {
			System.out.println("Train ....");
			Train t = (Train) pTien;
			System.out.println("Nhap so toa");
			t.setSoToa(new Scanner(System.in).nextInt());
		}
		if (pTien instanceof Car) {
			System.out.println("Car ....");
			Car c = (Car) pTien;
			System.out.println("Nhap loai xe");
//			String n4 = new Scanner(System.in).nextLine();
			c.setLoaiXe(new Scanner(System.in).nextLine());
	}
		
	}

	public static void info(PhuongTien pTien) {
		System.out.println("____THONG TIN PHUONG TIEN____");

		if (pTien instanceof Train) {
			System.out.println("Train info");
			Train t = (Train) pTien;
			System.out.println("Gia ve:" + pTien.getPrice() + "|" + "So ghe:" + pTien.getSeatNumber() + "|" + "So toa: "
					+ t.getSoToa());
		}
		if (pTien instanceof Car) {
			System.out.println("Car info");
			Car c = (Car) pTien;
			System.out.println("Gia ve:" + pTien.getPrice() + "|" + "So ghe:" + pTien.getSeatNumber() + "|" + "So ghe: "
					+ c.getLoaiXe());
		}
	}

	public static void menuTrain() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong train: ");
		int n = sc.nextInt();

		Train[] trains = new Train[n];
		for (int i = 0; i < trains.length; i++) {
			trains[i] = new Train();
			input(trains[i]);
		}

		for (Train trainsss : trains) {
			info(trainsss);
		}
	}

	public static void menuCar() {
		System.out.println("Nhap so luong car: ");
		int scCar = new Scanner(System.in).nextInt();

		Car[] cars = new Car[scCar];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
			input(cars[i]);
		}
		for (Car carsss : cars) {
			info(carsss);

		}
	}
}