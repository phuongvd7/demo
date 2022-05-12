package com.trungtamjava.list;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(3);
	
		//khai bao list
		List<Person> listPerson = new ArrayList<Person>();
		
		listPerson.add(p1); // bat dau tu vi tri so 0
		listPerson.add(p2);
		listPerson.add(p3);
		listPerson.add(p3); // add 2 lan cung dc vi trong list moi phan tu co the lap lai
		
		Person p = listPerson.get(3);
		System.out.println(p.getId());
		
//		for(Person per : listPerson) {
//			System.out.println(per.getId());
//		}
		for(int i = 0; i<listPerson.size(); i++) {
			System.out.println(listPerson.get(i).getId());
		}
		
		//xoa phan tu
		listPerson.remove(3);
		for(Person per : listPerson) {
		System.out.println(per.getId());
}
}
}