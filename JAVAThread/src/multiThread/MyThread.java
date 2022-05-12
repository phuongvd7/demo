package multiThread;

public class MyThread extends Thread {
	@Override
	public void run() {
		for( int i = 0; i<10;i++) {
			System.out.println(super.getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("T1");
		
		MyThread t2 = new MyThread();
		t2.setName("T2");
		
		MyThread t3 = new MyThread();
		t3.setName("T3");
		
		t1.start();
		t2.start();
		t3.start();
		
		MyThread[] tArr = new MyThread[1000];
		for(int i =0;i<tArr.length;i++) {
			tArr[i] = new MyThread();
			tArr[i].start();
		}
		
	}
}
	 