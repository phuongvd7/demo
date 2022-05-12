package serviceB2;

import java.util.Scanner;

import bai2.model.Laptop;

public class LaptopServiceImpl implements LaptopService {

	@Override
	public void input(Laptop It) {
		// TODO Auto-generated method stub
		System.out.println("Dien info");
		System.out.println("Nhap id: ");
		It.setId(new Scanner(System.in).nextInt());

		System.out.println("Nhap cpu: ");
		It.setCpu(new Scanner(System.in).nextLine());

		System.out.println("Nhap ram: ");
		It.setRam(new Scanner(System.in).nextLine());

		System.out.println("Nhap vga: ");
		It.setVga(new Scanner(System.in).nextLine());
	}

	@Override
	public void info(Laptop It) {
		// TODO Auto-generated method stub
		System.out.println("________");
		
		System.out.println("Id: " + It.getId() + "|" + "CPU: " + It.getCpu() + "|" + "Ram: " + It.getRam() + "|"
				+ "VGA: " + It.getVga());

	}

}
