package com.trungtamjava.company.section7.homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n;
		while (true) {
			System.out.println("Xin moi nhap lua chon cua ban ");
			System.out.println("1. Developer");
			System.out.println("2. Leader");
			System.out.println("Lua chon cua ban: ");
			int n = new Scanner(System.in).nextInt();
			if (n == 1) {
				Developer();
				break;
			} else if (n == 2) {
				Leader();
				break;
			}

		}
	}

	public static void Developer() {
		System.out.println("Ban chon Dev");
		System.out.println("Moi nhap vao so luong dev");
		int n1 = new Scanner(System.in).nextInt();
		Developer[] dev = new Developer[n1];

		for (int i = 0; i < dev.length; i++) {
			dev[i] = new Developer();
			dev[i].input();
		}

//		for ( int i = 0; i < dev.length ; i++) {
//			dev[i].info();
//		}

		for (Developer developersss : dev) {
			developersss.info();
		}
		System.out.println("dev co ngon ngu lap trinh Java ");
		for (int i = 0; i < dev.length; i++) {
			if (dev[i].programLanguage.equals("Java")) {
				dev[i].info();
			}
		}

	}

	public static void Leader() {
		System.out.println("Ban chon Leader ");
		System.out.println("Moi nhap vao so luong Leader");
		int n2 = new Scanner(System.in).nextInt();
		Leader[] lead = new Leader[n2];

		for (int i = 0; i < lead.length; i++) {
			lead[i] = new Leader();
			lead[i].input();
		}
		for (Leader leaddd : lead) {
			leaddd.info();
		}
		System.out.println("Leader co hon 10 nam kinh nghiem  ");
		for (int i = 0; i < lead.length; i++) {
			if (lead[i].teamSize >= 10) {
				lead[i].info();
			}
		}
		System.out.println("====");
		for (int i = 0; i < lead.length; i++) {
			lead[i].bonus();
		}
	}
}
