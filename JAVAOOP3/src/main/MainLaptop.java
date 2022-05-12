package main;
import model.Mac;
public class MainLaptop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mac mac = new Mac();
		
		mac.setModel("macbook");
		mac.setPrice(1000000);
		System.out.println(mac.getModel());
		
		mac.input();// goi ham class mac
		mac.info();
	}

}
