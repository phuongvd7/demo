package bai1;

import java.util.FormatFlagsConversionMismatchException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TongHaiSo {
	public static void main(String[] args) {
		while(true)
		try {
			System.out.println("Nhap x: ");
			int x = new Scanner(System.in).nextInt();

			System.out.println("Nhap y: ");
			int y = new Scanner(System.in).nextInt();

			int sum = x + y;
			System.out.println("Tong 2 so x + y = " + sum);
			break;
		} catch (FormatFlagsConversionMismatchException a) {
			System.out.println(a);
			System.out.println("vui long nhap lai dee");
		}catch (Exception b) {
			System.out.println(b);
			System.out.println("vui long nhap lai so");
		}
	}
}
