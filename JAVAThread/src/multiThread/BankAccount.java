package multiThread;

public class BankAccount implements Runnable{ // trong runnable co ham abstract run
	private long amount  = 1000;
	
	
	@Override
	public void run() {
		rutTien();
	}
	//lock
	public synchronized void rutTien() {
		amount -= 1000;
		try {
			 Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		if(amount >= 0 ) 
			System.out.println(Thread.currentThread().getName() + "- So du " + amount);
		else
			System.out.println(Thread.currentThread().getName() + "- ko du so du. ");
	}
}
