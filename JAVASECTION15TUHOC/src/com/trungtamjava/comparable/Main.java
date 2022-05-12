package com.trungtamjava.comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person(1, "A"));
		list.add(new Person(5, "C"));
		list.add(new Person(3, "A"));
		list.add(new Person(2, "A"));
		list.add(new Person(6, "A"));
		
		System.out.println("truoc khi sap xep theo id");
		for(Person p : list) {
			System.out.println(p.getId() + p.getName());
		}
		System.out.println("sau khi sap xep theo id");
		Collections.sort(list); // ham sap xep // nho implement comparale o ham person
		// => co the sap xep theo y muon, vd nhu sap xep theo id, sap xep theo name...
		
		for(Person p : list) {
			System.out.println(p.getId() + p.getName());
		}
		
	}
}
