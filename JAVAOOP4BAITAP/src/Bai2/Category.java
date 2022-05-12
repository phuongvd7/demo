package Bai2;

import java.util.Scanner;

public class Category {
	private int id;
	private String name; 
	private Product product[];

	public void info(){
			System.out.println("----------------");
			System.out.println("Thong tin category");
			System.out.println("id: " + id + "| " + "name: " + name + "| " );
	}
	public void input() {
		System.out.println("enter id: ");
		 id = new Scanner(System.in).nextInt();
		
		System.out.println("enter name: ");
		 name = new Scanner(System.in).nextLine();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product[] getProduct() {
		return product;
	}
	public void setProduct(Product[] product) {
		this.product = product;
	}
	

}