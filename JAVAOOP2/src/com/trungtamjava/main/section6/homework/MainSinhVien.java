package com.trungtamjava.main.section6.homework;

import java.util.Scanner;

import com.trungtamjava.model.homework.SinhVien;

public class MainSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Moi nhap vao so luong SV");
		int n = new Scanner(System.in).nextInt();
		SinhVien[] sv = new SinhVien[n];

		for (int i = 0; i < sv.length; i++) {
			sv[i] = new SinhVien();
			sv[i].input();
		}

		for (int i = 0; i < sv.length; i++) {
			sv[i].info();
		}

		for (int i = 0; i < sv.length - 1; i++) {
			for (int j = i + 1; j < sv.length; j++) {
				if (sv[i].age < sv[j].age) {
					SinhVien temp = sv[i];
					sv[i] = sv[j];
					sv[j] = temp;
				}
			}
		}
		System.out.println("mang sau khi sap xep");
		for (int i = 0; i < sv.length; i++) {
			sv[i].info();
		}
		

		int max = sv[0].age;
		for (int i = 0; i < sv.length; i++) {
			if (max < sv[i].age) {
				max = sv[i].age;

			}
		}
		System.out.println("sinh vien lon tuoi nhat la " + max);

	}

}
