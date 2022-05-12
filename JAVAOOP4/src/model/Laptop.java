package model;

import java.util.Scanner;

public class Laptop {
	private int price;
	private String model;
	
	
	//owner
	private Student owner; // null
	
	public void info() {
		System.out.println(model);
		System.out.println(price);
	}
	
	public void input() {
		System.out.println("nhap model: ");
		model = new Scanner(System.in).nextLine();

		System.out.println("nhap price: ");
		price = new Scanner(System.in).nextInt();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Student getOwner() {
		return owner;
	}

	public void setOwner(Student st) {
		this.owner = st;
	}
	
}
