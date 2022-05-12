package com.trungtamjava.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person(1, "a"));
		list.add(new Person(5, "d"));
		list.add(new Person(1, "c"));
		list.add(new Person(1, "b"));
		list.add(new Person(1, "e"));
		
		System.out.println("truoc khi sap xep");
		for(Person p : list) {
			System.out.println(p.getId() + p.getName());
		}
		System.out.println("sau khi sap xep");
//		Collections.sort(list, new Comparator<Person>() { // anomynous class, override lai ham compare de so sanh
//			
//			@Override
//			public int compare(Person o1,Person o2) {
//				if(o1.getId() > o2.getId()) {
//					return 1;
//				} else if (o1.getId() < o2.getId()) {
//					return -1;
//				} else return 0;
//			}
//		});
		Collections.sort(list, new MyCompare());
		
		for(Person p : list) {
			System.out.println(p.getId() + p.getName());
		}
	}
}

class MyCompare implements Comparator<Person>{
	@Override
	public int compare(Person o1,Person o2) {
		if(o1.getId() > o2.getId()) {
			return 1;
		} else if (o1.getId() < o2.getId()) {
			return -1;
		} else return 0;
}
}
