package multiThread;

public class Main {

	public static void main(String[] args) {
		//duy nhat 1 doi tuong bank account
		BankAccount bankAccount  = new BankAccount();// tao duy nhat 1 doi tuong bank account

		//3 luong cung truy xuat
		//se goi vao ham run cua bankaccount
		Thread t0 = new Thread(bankAccount);
		
		Thread t1 = new Thread(bankAccount);
		
		Thread t2 = new Thread(bankAccount);
		
		
		t0.start(); // ko goi ham run cua Thread nua ma goi ham run cua bankaccount
		t1.start();
		t2.start();
		
	}

}
