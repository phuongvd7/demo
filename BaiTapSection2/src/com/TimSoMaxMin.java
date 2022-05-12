package com;

import java.util.Scanner;

public class TimSoMaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		Max(a,b,c);
		Min(a,b,c);
	}
	public static void Max(int x,int y,int z) {
		int max = x;
		if(y>max) { 
			max = y;
		}
			if (z>max) {
				max = z;
			}
			
		
		System.out.println("so lon nhat la " + max);
	}
	public static void Min(int x,int y,int z) {
		int min = x;
		if(y<min) { 
			min = y;
		}
			if (z<min) {
				min = z;
			}
			
		
		System.out.println("so nho nhat la " + min);
	}

}
