package Bai2;

import java.util.Scanner;

public class Product {
	private Category category;
	private int price;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void info() {
		System.out.println("----------------");
		System.out.println("Thong tin price");
		System.out.println("price: " + price + "| ");
	}

	public void input() {
		System.out.println("enter price: ");
		price = new Scanner(System.in).nextInt();
//		this.price = price;
	}
}