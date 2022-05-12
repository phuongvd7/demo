package Model;

public class Ticket implements Runnable {
	private long ticket  = 2;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		buy();
	}
	private synchronized void buy() {
		ticket -= 1;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(ticket >= 0 ) 
			System.out.println(Thread.currentThread().getName() + "- So du " + ticket);
		else
			System.out.println(Thread.currentThread().getName() + "- ko du so du. ");
	}
}
