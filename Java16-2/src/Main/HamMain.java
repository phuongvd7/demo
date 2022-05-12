package Main;

import java.util.Scanner;

import jmaster.io.ontap.bienham.HinhVuong;

public class HamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Nhap vao canh a ");
//		Scanner sc = new Scanner(System.in);

//		int a = sc.nextInt();
//		float b = sc.nextFloat();
//		float cv = HinhVuong.chuVi(b);
//		System.out.println("Chu vi hinh vuong " + cv);
//		giaiThua(3);
//		mang();
//		mangSapxep();
		Ptb2();

	}

	public static void giaiThua(int n) {
		if (n <= 0) {
			System.out.println("n la so khong the tinh giai thua");
		} else {
			int gt = 1;
			for (int i = 1; i <= n; i++) {
				gt = gt * i;
			}
			System.out.println(gt);
		}

	}

	public static void mang() {
		int[] mangX = new int[5];
		int tong = 0;
		for (int i = 0; i < mangX.length; i++) {
			System.out.println("Nhap phan tu thu " + i + " ");
			mangX[i] = new Scanner(System.in).nextInt(); // thu gon lai thanh 1 dong
			tong = tong + mangX[i];
		}

		System.out.println("tong cua mang la = " + tong);
	}

	public static void mangSapxep() {
		int[] mangX = new int[5];
		int tong = 0;
		for (int i = 0; i < mangX.length; i++) {
			System.out.println("Nhap phan tu thu " + i + " ");
			mangX[i] = new Scanner(System.in).nextInt(); // thu gon lai thanh 1 dong
//		tong = tong + mangX[i];
		}
		System.out.println("mang truoc khi sap xep la ");
		for (int i = 0; i < mangX.length; i++) {
			System.out.println(mangX[i]);
		}

		for (int a = 0; a < mangX.length - 1; a++) {
			for (int b = a + 1; b < mangX.length; b++) {
				if (mangX[a] < mangX[b]) {
					int temp = mangX[a];
					mangX[a] = mangX[b];
					mangX[b] = temp;
				}

			}
		}
		System.out.println("mang sau khi sap xep la ");
		for (int i = 0; i < mangX.length; i++) {
			System.out.println(mangX[i]);
		}

	}

	public static void Ptb2() {
		Scanner sc = new Scanner(System.in);
		{
			float a = sc.nextInt();
			float b = sc.nextInt();
			float c = sc.nextInt();
			float delta = b * b - 4 * a * c;
			if (delta < 0) {
				System.out.println("PT vo nghiem");
			} else if (delta == 0) {
				float x = -b / (2 * a);
				System.out.println(" PT co nghiem kep " + x);
			} else {
				System.out.println(" PT co 2 nghiem pbiet");
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println(x1);
				System.out.println(x2);

			}
		}

	}
}