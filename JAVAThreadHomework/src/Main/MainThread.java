package Main;

import Model.MyThread;

public class MainThread {

	public static void main(String[] args) {
		Thread[] threads = new Thread[1000];
		for(int i = 0 ; i<threads.length ;i++) {
			threads[i] = new MyThread();
		}
		
		for(Thread threadsss : threads) {
			threadsss.start();
		}
		

	}
}
