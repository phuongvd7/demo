package com.trungtamjava.model;

public class Table {
	int size;
	 String color;
	String material;
	static String kieudang;
	
//	public Table() {
//		System.out.println(this);// this dai dien cho doi tuong
//	}
	
//	public void Table() {
//		
//	}
	public  Table(String color) {
		System.out.println("chon mau");
		this.color = color;
	}
	
	//size1 la mot tham so
	public void setSize(int size) { 
		this.size = size;
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public static String getKieudang() {
		return kieudang;
	}

	public static void setKieudang(String kieudang) {
		Table.kieudang = kieudang;
	}

	public int getSize() {
		return size;
	}
}
