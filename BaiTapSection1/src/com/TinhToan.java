package com;

import java.util.Scanner;

public class TinhToan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int a;
	//	int b;
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
//		int z = tongHaiso(a,b);
//		System.out.println("gia tri tong la " + tongHaiso(a,b));
		hieuHaiso(a,b);

	
//		System.out.println("gia tri cua a la " + hieuHaiso()) ;
	}
	public static int tongHaiso(int x, int y) {
		
		int tong1 = x + y;
		return tong1;
	}
	public static void hieuHaiso(int a,int b) {
		int hieu1 = a-b;
		System.out.println("gia tri cua hieu la " + hieu1 ) ;
		
	}
}


