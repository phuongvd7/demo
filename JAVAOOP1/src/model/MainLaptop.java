package model;

public class MainLaptop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laptop.NoiSx = "China";
		
//		Laptop L1 = new Laptop("5GB","A13","Dell","white");// phai tao new doi tuong truoc thi` moi dung duoc bien non static , con rieng bien static thi co the tao truoc
		Laptop L2 = new Laptop();
//		Laptop L2 = new Laptop("5GB","A13","Dell","Blue");
	//  vay neu khai bao ham contructor o ham laptop vd ( public Laptop(String ram)) thi se khong goi ham Laptop dc. khi ay nhap bien Color ,ram, processor cho tung doi tuong kieu gi???)
		
		System.out.println(Laptop.NoiSx);
//		L1.Color = "Black";
//		L2.Color = "Red";
//		System.out.println(L1.Color);
//		System.out.println(L2.Color);
		L2.input();
		L2.info();
	}
	

}
