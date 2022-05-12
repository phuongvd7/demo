package bai2.Main;

import bai2.model.Laptop;

import serviceB2.LaptopServiceImpl;

public class MainB2 {
	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		LaptopServiceImpl laptopImpl = new LaptopServiceImpl();

		laptopImpl.input(laptop);
		laptopImpl.info(laptop);

	}
}