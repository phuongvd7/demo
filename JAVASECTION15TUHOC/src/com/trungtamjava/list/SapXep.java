package com.trungtamjava.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SapXep {

	public static void main(String[] args) {
		List<String> listString = new ArrayList<String>();

		listString.add("a");
		listString.add("d");
		listString.add("b");
		listString.add("c");
		for (String s : listString) {
			System.out.println(s);
		}
		System.out.println("sap xep tang dan");
		Collections.sort(listString);

		for (String s : listString) {
			System.out.println(s);
		}

		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(7);
		list.add(6);
		list.add(8);
		list.add(9);

		for (int i : list) {
			System.out.println(i);
		}
		System.out.println("Sau khi sap xep tang dan");
		Collections.sort(list);
		for (int i : list) {
			System.out.println(i);
		}
	}

}
