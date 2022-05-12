package com.trungtamjava.company.section7.homework;

import java.util.Scanner;

public class Leader extends Human {
	int teamSize;
	int luongCoBan = 10000000;
	@Override
	protected void info() {
		super.info();
		System.out.println(teamSize);
	}

	@Override
	public void input() {
		super.input();
		System.out.println("nhap vao so nam kinh nghiem");
		teamSize = new Scanner(System.in).nextInt();
	}
	
	public void bonus() {
		if(teamSize >= 10) {
			System.out.println("Luong cua Leader " + super.Name + " hoac " + super.getName() + " :" + luongCoBan * 50 / 100);
		}else {
			System.out.println("Luong cua Leader " + super.Name + " hoac " + super.getName() + " :" + luongCoBan * 10 / 100);
		}
	}
}
