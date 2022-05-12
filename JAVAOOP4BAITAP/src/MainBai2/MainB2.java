package MainBai2;

import java.util.Scanner;

import Bai2.Category;
import Bai2.Product;

public class MainB2 {
	
	public static void main(String[] args) {
		createProducts();
	}
	
	public static void createProducts() {
		Category categories = new Category();
		categories.input();
		System.out.println("nhap vao so luong product ");
		
		int n1 = new Scanner(System.in).nextInt();
		
		Product [] products = new Product[n1];
		
		for(int i = 0; i < products.length ; i++) {
			products[i] = new Product();
			products[i].input();
			products[i].setCategory(categories);
		}
		for (Product product : products) {
			product.info();
			product.getCategory().info();
		}
		
	}
	
}
