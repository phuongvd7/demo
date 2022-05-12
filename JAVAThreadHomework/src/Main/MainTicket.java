package Main;

import Model.Ticket;


public class MainTicket {

	public static void main(String[] args) {
		Ticket ticket  = new Ticket();// tao duy nhat 1 doi tuong bank account

		//3 luong cung truy xuat
		//se goi vao ham run cua bankaccount
		Thread t0 = new Thread(ticket);
		
		Thread t1 = new Thread(ticket);
		
		Thread t2 = new Thread(ticket);
		
		
		t0.start(); // ko goi ham run cua Thread nua ma goi ham run cua bankaccount
		t1.start();
		t2.start();
		

	}

}
