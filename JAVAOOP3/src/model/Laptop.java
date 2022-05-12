package model;

import java.util.Scanner;

public class Laptop {
	private String model;
	private int price;
	
	public void input() {
		System.out.println("Enter model");
		model = new Scanner(System.in).nextLine();
		
		System.out.println("Enter price");
		price = new Scanner(System.in).nextInt();
	}
	
	public void info() {
		System.out.println("model: " + model);
		System.out.println("price " + price);
	}
	
	
	
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return this.model;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
}
