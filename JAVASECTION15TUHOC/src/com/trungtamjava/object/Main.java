package com.trungtamjava.object;

public class Main {

	public static void main(String[] args) {
		Person p1  = new Person(1, "A");
		Person p2  = new Person(1, "A");
		// bien p1 tro den 1 new person trong bo nho heap
		// bien p2 tro den 1 person khac trong bo nho heap
		// hai doi tuong doc lap, dia chi bo nho khac nhau ==> khong the nao so sanh dc
		// do mac dinh su dung dia chi bo nho this de so sanh voi nhau ( trong class object)
		System.out.println(p1.equals(p2));
		System.out.println(p1 == p2);
	}

}
