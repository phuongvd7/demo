package com.trungtamjava.list;

import java.util.List;
import java.util.Vector;

public class VectorMain {
	public static void main(String[] args) {
		Person p = new Person(1);
		
		List<Person> list  = new Vector<Person>();
		//dung interface list de lam kieu du lieu tro den cac doi tuog con cua no
//		Vector<Person> list  = new Vector<Person>();
	list.add(p);
	list.remove(0);
	for(Person p1 : list) {
		System.out.println(p1.getId());
	}//vector chi khac array list va linked list o cho moi ham trong vector deu la dong bo
	//tuc la cac thread chay song song phai doi nhau neu chay vao ham
	//=> hieu suat cua vector se thap hon array list nhung tinh bao mat cao hon
	}
}
