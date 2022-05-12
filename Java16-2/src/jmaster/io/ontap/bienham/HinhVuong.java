package jmaster.io.ontap.bienham;

import java.util.Scanner;

public class HinhVuong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		int a = scan.nextInt();
		float b = scan.nextFloat();
		
//		System.out.println(chuVi(a));
		System.out.println(chuVi(b));
	}
	
		public static int chuVi(int a) {
		return a*4;	
		}
		public static float chuVi(float a) { //quan trong la thay doi tham so () là dc overload
			return a*4;		
			}
		
		public static void ChuVi(float a) {
			System.out.println("Chu vi hinh vuong la " +(4*a));
		}
	

	

}
