package com.trungtamjava.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedlistMain {

	public static void main(String[] args) {
		Person person = new Person(1);
		
		List<Person> list = new LinkedList<Person>();
		
		list.add(person);
		
		for(Person p : list) {
			System.out.println(p.getId());
		}
		
		list.remove(0);
// linked list  khac arraylist o cho cach no implement den ham cua interface
// trong cach sd,, tinh ve hieu suat thi linked list phu hop cho viec thuong xuyen them,sua,xoa du lieu trong list
// array list thi luu va truy xuat du lieu		

	}

}
