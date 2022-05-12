package com.trungtamjava.model;

public class MainTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table t1 = new Table("do");
		Table t2 = new Table("den");
		Table t3 = new Table("trang");
		
		 t1.setSize(20);
		 t2.setSize(100);
		 System.out.println(t1.getSize() + " " + t2.getSize()); 
		 t1.material = "Wood";
		 t2.material = "Plastic";
		 
		 t1.size = 20;
		 t2.size = 100;
		 System.out.println(t1.size + " " + t2.size);
		 System.out.println(t1.material + " " + t2.material);
		 System.out.println(t1.color + " " + t2.color);
	}
	
}
